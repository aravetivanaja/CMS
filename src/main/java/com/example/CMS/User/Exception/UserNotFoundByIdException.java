package com.example.CMS.User.Exception;

public class UserNotFoundByIdException extends RuntimeException{
	
	private String message;

	public UserNotFoundByIdException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	

}
