package com.testeweb.course.resources.exceptions;

import java.io.Serializable;
import java.time.Instant;

public class StandardError implements Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Instant timestamp;
	private Integer status;
	private String name;
	private String message;
	private String path;
	
	
	public StandardError()
	{
		
	}


	public StandardError(Instant timestamp, Integer status, String name, String message, String path) {
		this.timestamp = timestamp;
		this.status = status;
		this.name = name;
		this.message = message;
		this.path = path;
	}


	public Instant getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}
	
	
	
}
