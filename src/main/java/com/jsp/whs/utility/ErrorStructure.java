package com.jsp.whs.utility;

public class ErrorStructure<T>{
	private int status ;
	private String messsage;
	private T routcase;
	public int getStatus() {
		return status;
	}
	public String getMesssage() {
		return messsage;
	}
	public T getRoutcase() {
		return routcase;
	}
	public ErrorStructure<T> setStatus(int status) {
		this.status = status;
		return this;
	}
	public ErrorStructure<T> setMesssage(String messsage) {
		this.messsage = messsage;
		return  this;
	}
	public ErrorStructure<T> setRoutcase(T routcase) {
		this.routcase = routcase;
		return this;
	}
	

}
