package com.matheus.todo.resources.exceptions;

import java.io.Serializable;

public class StandarError implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long timetamp;
	private Integer status;
	private String message;
	public StandarError() {
		super();
	}
	public StandarError(Long timetamp, Integer status, String message) {
		super();
		this.timetamp = timetamp;
		this.status = status;
		this.message = message;
	}
	public Long getTimetamp() {
		return timetamp;
	}
	public void setTimetamp(Long timetamp) {
		this.timetamp = timetamp;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
