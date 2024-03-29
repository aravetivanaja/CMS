package com.example.CMS.User.Exception;

public class BlogNotFoundByIdException extends RuntimeException{
	
	private String message;

	public String getMessage() {
		return message;
	}

	public BlogNotFoundByIdException(String message) {
		super();
		this.message = message;
	}
	
	

}
