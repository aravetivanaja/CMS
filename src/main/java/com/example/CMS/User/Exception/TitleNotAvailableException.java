package com.example.CMS.User.Exception;

public class TitleNotAvailableException extends RuntimeException{
	
	private String message;

	public TitleNotAvailableException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	

}
