package com.jsp.whs.exception;

public class WarehouseNotFoundByIdException extends RuntimeException{
	private String message;

	public WarehouseNotFoundByIdException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

//	public void setMessage(String message) {
//		this.message = message;
//	}
	
	
}
