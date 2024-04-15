package com.example.CMS.User.Exception;

public class UnAuthorizedUserException extends RuntimeException{
	
	private String message;

	public UnAuthorizedUserException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	

}
