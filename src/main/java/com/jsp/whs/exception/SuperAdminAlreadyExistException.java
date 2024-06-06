package com.jsp.whs.exception;

@SuppressWarnings("serial")
public class SuperAdminAlreadyExistException extends RuntimeException{
	@SuppressWarnings("unused")
	private String message;

	public SuperAdminAlreadyExistException(String message) {
	
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	 
}
