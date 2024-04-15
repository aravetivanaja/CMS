package com.example.CMS.User.Exception;

public class InvalidPanelIdException extends RuntimeException{
	
	private String message;

	public InvalidPanelIdException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	

}
