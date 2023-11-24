package com.WebServices.BOSWeb.ExceptionHandler;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class ErrorDetials {
	
	private Date timestamp;
    private String message;
    private String errorDetails;
    private HttpStatus httpstatus;
    
	public ErrorDetials(Date timestamp, String message, String errorDetails, HttpStatus httpstatus) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.errorDetails = errorDetails;
		this.httpstatus = httpstatus;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getErrorDetails() {
		return errorDetails;
	}
	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}
	public HttpStatus getHttpstatus() {
		return httpstatus;
	}
	public void setHttpstatus(HttpStatus httpstatus) {
		this.httpstatus = httpstatus;
	}
    
    
    
}
