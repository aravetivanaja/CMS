package com.example.CMS.User.Exception;

public class BlogPostNotFoundByIdException extends RuntimeException{
	
	private String message;
	

	public String getMessage() {
		return message;
	}


	public BlogPostNotFoundByIdException(String message) {
		super();
		this.message = message;
	}
	

}
