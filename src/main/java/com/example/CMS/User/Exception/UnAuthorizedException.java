package com.example.CMS.User.Exception;

public class UnAuthorizedException extends RuntimeException{
	
	private String message;

	public String getMessage() {
		return message;
	}

	public UnAuthorizedException(String message) {
		super();
		this.message = message;
	}
	
	public UnAuthorizedException()
	{
		
	}

}
