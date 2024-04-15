package com.example.CMS.User.Exception;

public class IllegalAccessRequestException extends RuntimeException {
	
	private String message;

	public IllegalAccessRequestException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	

}
