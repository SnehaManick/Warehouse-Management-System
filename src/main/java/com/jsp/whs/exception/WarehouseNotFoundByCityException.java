package com.jsp.whs.exception;

public class WarehouseNotFoundByCityException extends RuntimeException {
    private String message;

	public WarehouseNotFoundByCityException(String message) {
		super();
		this.message = message;
	}
    
	public String getMessage() {
		return message;
	}
}
