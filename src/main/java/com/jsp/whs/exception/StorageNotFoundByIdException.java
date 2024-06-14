package com.jsp.whs.exception;

public class StorageNotFoundByIdException extends RuntimeException{

	private String message;

	public StorageNotFoundByIdException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	
}
