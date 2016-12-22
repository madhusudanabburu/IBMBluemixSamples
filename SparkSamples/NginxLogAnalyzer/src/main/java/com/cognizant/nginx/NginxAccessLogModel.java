package com.cognizant.nginx;

import java.io.Serializable;
import java.lang.String;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class represents an Nginx access log line.
 * 
 */

public class NginxAccessLogModel implements Serializable {
	private static final Logger logger = Logger.getLogger("Access");
	
	private String remoteAddr;
	private String remoteUser;
	private String localTime;
	private String request;
	private String endPoint;
	private String responseCode;
	private long bodyBytesSent;
	private String httpReferer;
	private String httpUserAgent;
	private String httpXForwardedFor;
	private double requestTime;
	private double upstreamResponseTime;
	private String httpTruID;
	private long requestLength;
	private String httpUserID;
	private String httpClientTransactionID;
	
	public NginxAccessLogModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public NginxAccessLogModel(String remoteAddr, String remoteUser, String localTime, String request, String endPoint, String responseCode,
			long bodyBytesSent, String httpReferer, String httpUserAgent, String httpXForwardedFor, double requestTime,
			double upstreamResponseTime, String httpTruID, long requestLength, String httpUserID,
			String httpClientTransactionID) {
		super();
		this.remoteAddr = remoteAddr;
		this.remoteUser = remoteUser;
		this.localTime = localTime;
		this.request = request;
		this.endPoint = endPoint;
		this.responseCode = responseCode;
		this.bodyBytesSent = bodyBytesSent;
		this.httpReferer = httpReferer;
		this.httpUserAgent = httpUserAgent;
		this.httpXForwardedFor = httpXForwardedFor;
		this.requestTime = requestTime;
		this.upstreamResponseTime = upstreamResponseTime;
		this.httpTruID = httpTruID;
		this.requestLength = requestLength;
		this.httpUserID = httpUserID;
		this.httpClientTransactionID = httpClientTransactionID;
	}


	public String getEndPoint() {
		return endPoint;
	}


	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}


	/**
	 * @return the remoteAddr
	 */
	public String getRemoteAddr() {
		return remoteAddr;
	}
	/**
	 * @param remoteAddr the remoteAddr to set
	 */
	public void setRemoteAddr(String remoteAddr) {
		this.remoteAddr = remoteAddr;
	}
	/**
	 * @return the remoteUser
	 */
	public String getRemoteUser() {
		return remoteUser;
	}
	/**
	 * @param remoteUser the remoteUser to set
	 */
	public void setRemoteUser(String remoteUser) {
		this.remoteUser = remoteUser;
	}
	/**
	 * @return the localTime
	 */
	public String getLocalTime() {
		return localTime;
	}
	/**
	 * @param localTime the localTime to set
	 */
	public void setLocalTime(String localTime) {
		this.localTime = localTime;
	}
	/**
	 * @return the request
	 */
	public String getRequest() {
		return request;
	}
	/**
	 * @param request the request to set
	 */
	public void setRequest(String request) {
		this.request = request;
	}
	/**
	 * @return the status
	 */
	public String getResponseCode() {
		return responseCode;
	}
	/**
	 * @param status the status to set
	 */
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	/**
	 * @return the bodyBytesSent
	 */
	public long getBodyBytesSent() {
		return bodyBytesSent;
	}
	/**
	 * @param bodyBytesSent the bodyBytesSent to set
	 */
	public void setBodyBytesSent(long bodyBytesSent) {
		this.bodyBytesSent = bodyBytesSent;
	}
	/**
	 * @return the httpReferer
	 */
	public String getHttpReferer() {
		return httpReferer;
	}
	/**
	 * @param httpReferer the httpReferer to set
	 */
	public void setHttpReferer(String httpReferer) {
		this.httpReferer = httpReferer;
	}
	/**
	 * @return the httpUserAgent
	 */
	public String getHttpUserAgent() {
		return httpUserAgent;
	}
	/**
	 * @param httpUserAgent the httpUserAgent to set
	 */
	public void setHttpUserAgent(String httpUserAgent) {
		this.httpUserAgent = httpUserAgent;
	}
	
	/**
	 * @return the httpXForwardedFor
	 */
	public String getHttpXForwardedFor() {
		return httpXForwardedFor;
	}

	/**
	 * @param httpXForwardedFor the httpXForwardedFor to set
	 */
	public void setHttpXForwardedFor(String httpXForwardedFor) {
		this.httpXForwardedFor = httpXForwardedFor;
	}

	/**
	 * @return the requestTime
	 */
	public double getRequestTime() {
		return requestTime;
	}

	/**
	 * @param requestTime the requestTime to set
	 */
	public void setRequestTime(double requestTime) {
		this.requestTime = requestTime;
	}

	/**
	 * @return the upstreamResponseTime
	 */
	public double getUpstreamResponseTime() {
		return upstreamResponseTime;
	}

	/**
	 * @param upstreamResponseTime the upstreamResponseTime to set
	 */
	public void setUpstreamResponseTime(double upstreamResponseTime) {
		this.upstreamResponseTime = upstreamResponseTime;
	}

	/**
	 * @return the httpTruID
	 */
	public String getHttpTruID() {
		return httpTruID;
	}

	/**
	 * @param httpTruID the httpTruID to set
	 */
	public void setHttpTruID(String httpTruID) {
		this.httpTruID = httpTruID;
	}

	/**
	 * @return the requestLength
	 */
	public long getRequestLength() {
		return requestLength;
	}

	/**
	 * @param requestLength the requestLength to set
	 */
	public void setRequestLength(long requestLength) {
		this.requestLength = requestLength;
	}

	/**
	 * @return the httpUserID
	 */
	public String getHttpUserID() {
		return httpUserID;
	}

	/**
	 * @param httpUserID the httpUserID to set
	 */
	public void setHttpUserID(String httpUserID) {
		this.httpUserID = httpUserID;
	}

	/**
	 * @return the httpClientTransactionID
	 */
	public String getHttpClientTransactionID() {
		return httpClientTransactionID;
	}

	/**
	 * @param httpClientTransactionID the httpClientTransactionID to set
	 */
	public void setHttpClientTransactionID(String httpClientTransactionID) {
		this.httpClientTransactionID = httpClientTransactionID;
	}

	// Example Apache log line:
	//   54.251.97.71 - - [2015-12-28T13:28:56+00:00] "GET /CTS/v1/storage/Demo_APP_BUCKET/Registration?queryString={} HTTP/1.1" 200 50 "-" "-" "-" 0.295 0.295 "568139177184191e1daf2199" 231 - "-"
	
    private static final String LOG_ENTRY_PATTERN =
      // 1:remoteAddr  2:user 3:date time                   4:req 5:status   6:bodybytessent 7:httpreferer 8.userAgent 9.httpxforwarded 10.requestTime 11.upstreamResponseTime 12.truID, 13.requestLength 14.userID 15.clientTransactionID
      "^(\\S+)\\s+(\\S+)\\s+(\\S+)\\s+\\[(.*\\S.*)\\]\\s+\\\"(\\S+)\\s+(\\S+)\\s+(\\S+)\\\"\\s+(\\d{3})\\s+(\\d+)\\s+\\\"(\\S+)\\\"\\s+\\\"(.*\\S.*)\\\"\\s+\\\"(\\S+)\\\"\\s+(.*\\S+)\\s+(.*\\S.*)\\s+\\\"(\\S+)\\\"\\s+(\\d+)\\s+(\\S*)\\s+\\\"(.*\\S.*)\\\"";
    private static final Pattern PATTERN = Pattern.compile(LOG_ENTRY_PATTERN);

    public static NginxAccessLogModel parseFromLogLine(String logline) {
    	Matcher m = PATTERN.matcher(logline);
   
    	if (!m.find()) {
    		logger.log(Level.ALL, "Cannot parse logline" + logline);
    		throw new RuntimeException("Error parsing logline");
    	}
    	/*String remoteAddr, String remoteUser, String localTime, String request, String status,
			long bodyBytesSent, String httpReferer, String httpUserAgent, String httpXForwardedFor, long requestTime,
			long upstreamResponseTime, String httpTruID, long requestLength, String httpUserID,
			String httpClientTransactionID*/
    	long bodyBytesSent = 0, requestLength = 0;
    	double requestTime = 0, upstreamResponseTime = 0;
    	if ((m.group(9) != null) && (!m.group(9).equalsIgnoreCase("-"))) {
    		bodyBytesSent = Long.parseLong(m.group(9));
    	}
    	if ((m.group(13) != null) && (!m.group(13).equalsIgnoreCase("-"))) {
    		if(m.group(13).contains(",")) {
    			requestTime = Double.parseDouble(m.group(13).substring(0, 4));
    		} else {
    			requestTime = Double.parseDouble(m.group(13));
    		}
    	}
    	if ((m.group(14) != null) && (!m.group(14).equalsIgnoreCase("-"))) {
    		if(m.group(14).contains(",")) {
    			upstreamResponseTime = Double.parseDouble(m.group(14).substring(0, 4));
    		} else {
    			upstreamResponseTime = Double.parseDouble(m.group(14));
    		}
    		
    	}
    	if ((m.group(16) != null) && (!m.group(16).equalsIgnoreCase("-"))) {
    		requestLength = Long.parseLong(m.group(16));
    	}
    	return new NginxAccessLogModel(m.group(1), m.group(3), m.group(4), m.group(5), m.group(6), m.group(8), bodyBytesSent, 
    			m.group(10), m.group(11), m.group(12), requestTime, upstreamResponseTime, m.group(15), requestLength, m.group(17), m.group(18));
    }	
	
	
	
	@Override
	public String toString() {
		return "NginxAccessLogModel [remoteAddr=" + remoteAddr + ", remoteUser=" + remoteUser + ", localTime="
				+ localTime + ", request=" + request + ", responseCode=" + responseCode + ", bodyBytesSent=" + bodyBytesSent
				+ ", httpReferer=" + httpReferer + ", httpUserAgent=" + httpUserAgent + ", httpXForwardedFor="
				+ httpXForwardedFor + ", requestTime=" + requestTime + ", upstreamResponseTime=" + upstreamResponseTime
				+ ", httpTruID=" + httpTruID + ", requestLength=" + requestLength + ", httpUserID=" + httpUserID
				+ ", httpClientTransactionID=" + httpClientTransactionID + "]";
	}


	public static void main(String args[]) {
		String line1 = "54.251.97.71 - - [2015-12-28T13:28:56+00:00] \"GET /CTS/v1/storage/Demo_APP_BUCKET/Registration?queryString={} HTTP/1.1\" 200 50 \"-\" \"-\" \"-\" 0.295 0.295 \"568139177184191e1daf2199\" 231 - \"-\"";
		String line2 = "203.99.198.240 - - [2015-12-28T13:28:56+00:00] \"GET /CTS/v1/Demo/logout?logout|queryString={%22userId%22:%222%22,%22username%22:%22anu%22} HTTP/1.1\" 200 159 \"-\" \"Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36\" \"-\" 0.588 0.588 \"-\" 630 anup \"-\"";

		NginxAccessLogModel model = new NginxAccessLogModel();
		System.out.println(model.parseFromLogLine(line1).toString());
		System.out.println(model.parseFromLogLine(line2).toString());
	}
	

}
