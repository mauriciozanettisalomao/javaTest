package com.ef.db.model;

/**
 * 
 * @author zanettma
 *
 * Model to import rows of files as below
 * 2017-01-01 00:00:11.763|192.168.234.82|"GET / HTTP/1.1"|200|"swcd (unknown version) CFNetwork/808.2.16 Darwin/15.6.0"
 *
 */
public class LogFile {
	
	String date;
	String ip;
	String request;
	String status;
	String userAgent;
	String descriptionOfBlock;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUserAgent() {
		return userAgent;
	}
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}
	public String getDescriptionOfBlock() {
		return descriptionOfBlock;
	}
	public void setDescriptionOfBlock(String descriptionOfBlock) {
		this.descriptionOfBlock = descriptionOfBlock;
	}
	
}
