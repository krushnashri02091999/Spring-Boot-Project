package com.CRUD.GlobalExceptionHandling;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class ErrorResponse {

	private int status;
	private HttpStatus error;
	private String msg;
	private Date date;
	private String path;
	
	

	public ErrorResponse() {
	}

	public ErrorResponse(int status, HttpStatus error, String msg, Date date, String path) {
		super();
		this.status = status;
		this.error = error;
		this.msg = msg;
		this.date = date;
		this.path = path;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public HttpStatus getError() {
		return error;
	}

	public void setError(HttpStatus error) {
		this.error = error;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}