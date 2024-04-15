package com.example.CMS.User.Exception;

public class BlogPostNotFoundBYIdByPostTypeException extends RuntimeException{
	
	private String message;

	public String getMessage() {
		return message;
	}

	public BlogPostNotFoundBYIdByPostTypeException(String message) {
		super();
		this.message = message;
	}
	
	

}
