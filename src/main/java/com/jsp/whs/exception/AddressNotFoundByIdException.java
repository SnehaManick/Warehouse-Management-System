package com.jsp.whs.exception;

public class AddressNotFoundByIdException extends RuntimeException{
	private String message;

	public String getMessage() {
		return message;
	}

	public AddressNotFoundByIdException(String message) {
		super();
		this.message = message;
	}

}
