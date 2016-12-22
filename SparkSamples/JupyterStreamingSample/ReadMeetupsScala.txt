
%AddJar http://dl.bintray.com/spark-packages/maven/cloudant-labs/spark-cloudant/2.0.0-s_2.11/spark-cloudant-2.0.0-s_2.11.jar

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, SQLContext}
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.{Time, Seconds, StreamingContext}
import org.apache.spark.{SparkConf, SparkContext}

val conf = sc.getConf
conf.set("cloudant.host","83a4d5b3-b0cd-4206-a1dd-b8ede559ef88-bluemix.cloudant.com")
conf.set("cloudant.username", "83a4d5b3-b0cd-4206-a1dd-b8ede559ef88-bluemix")
conf.set("cloudant.password","004f4adfb5a46442c3a5e37f6d62eec477c9f3d96781d45f612bfba6afd4b013")

conf.setJars(ClassLoader.getSystemClassLoader.asInstanceOf[java.net.URLClassLoader].getURLs.map(_.toString).toSet.toSeq ++ kernel.interpreter.classLoader.asInstanceOf[java.net.URLClassLoader].getURLs.map(_.toString).toSeq)
conf.set("spark.driver.allowMultipleContexts", "true")
conf.set("spark.master","local[*]")
val scCloudant = new SparkContext(conf)
scCloudant.getConf.getAll.foreach(println)


def readFromDatabase(sqlContext: SQLContext, databaseName: String) = {
    val df = sqlContext.read.format("com.cloudant.spark").load(databaseName)
    df
}

val sqlContext = new SQLContext(scCloudant)
import sqlContext.implicits._
val df = readFromDatabase(sqlContext, "meetup_group")
df.show(5)
df.filter(df("group_city")==="Austin").show(5)



