package com.cognizant.nginx;

import java.util.Comparator;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext;

import scala.Tuple2;
import org.apache.spark.mllib.recommendation.ALS;
import org.apache.spark.mllib.recommendation.MatrixFactorizationModel;
import org.apache.spark.mllib.recommendation.Rating;

public class NginxLogAnalyzer {
	public static void main(String[] args) {

		// Create a Spark Context.
		SparkConf conf = new SparkConf().setAppName("Log Analyzer");
		JavaSparkContext sc = new JavaSparkContext(conf);
		// Load the text file into Spark.
		if (args.length == 0) {
			System.out.println("Must specify an access logs file.");
			System.exit(-1);
		}
		
		String logFile = args[0];
		JavaRDD<String> logLines = sc.textFile(logFile);

		// Convert the text log lines to NginxAccessLogModel objects and
		// cache them since multiple transformations and actions
		// will be called on the data.
		JavaRDD<NginxAccessLogModel> accessLogs = logLines.map(NginxAccessLogModel::parseFromLogLine).cache();
		
		SQLContext sqlContext = new SQLContext(sc);
	    DataFrame sqlDataFrame = sqlContext.createDataFrame(accessLogs, NginxAccessLogModel.class);
	    sqlDataFrame.registerTempTable("logs");
	    sqlContext.cacheTable("logs");
	    //sqlDataFrame.show();

	    // Calculate statistics based on the content size.
	    Row requestLengthStats = sqlContext.sql(
	        "SELECT SUM(requestLength), COUNT(*), MIN(requestLength), MAX(requestLength) FROM logs")
	            .javaRDD()
	            .collect()
	            .get(0);
	    System.out.println(String.format("Content Size Avg: %s, Min: %s, Max: %s",
	        requestLengthStats.getLong(0) / requestLengthStats.getLong(1),
	        requestLengthStats.getLong(2),
	        requestLengthStats.getLong(3)));

	    // Compute Response Code to Count.
	    List<Tuple2<String, Long>> responseCodeToCount = sqlContext
	        .sql("SELECT responseCode, COUNT(*) FROM logs GROUP BY responseCode LIMIT 100")
	        .javaRDD()
	        .mapToPair(new PairFunction<Row, String, Long>() {
	          @Override
	          public Tuple2<String, Long> call(Row row) throws Exception {
	            return new Tuple2<String, Long>(row.getString(0), row.getLong(1));
	          }
	        })
	        .collect();
	    System.out.println(
	        String.format("Response code counts: %s", responseCodeToCount));

	    // Any IPAddress that has accessed the server more than 10 times.
	    List<String> remoteAddresses = sqlContext
	        .sql("SELECT remoteAddr, COUNT(*) AS total FROM logs GROUP BY remoteAddr HAVING total > 10 LIMIT 100")
	        .javaRDD()
	        .map(new Function<Row, String>() {
	          @Override
	          public String call(Row row) throws Exception {
	            return row.getString(0);
	          }
	        })
	        .collect();
	    System.out.println(
	        String.format("remoteAddresses > 10 times: %s", remoteAddresses));

	    // Top Endpoints.
	    List<Tuple2<String, Long>> topEndpoints = sqlContext
	        .sql("SELECT endPoint, COUNT(*) AS total FROM logs GROUP BY endPoint ORDER BY total DESC LIMIT 10")
	        .javaRDD()
	        .map(new Function<Row, Tuple2<String, Long>>() {
	               @Override
	               public Tuple2<String, Long> call(Row row) throws Exception {
	                 return new Tuple2<String, Long>(
	                     row.getString(0), row.getLong(1));
	               }
	             })
	        .collect();
	    System.out.println(String.format("Top Endpoints: %s", topEndpoints));
		sc.stop();
	}

}
