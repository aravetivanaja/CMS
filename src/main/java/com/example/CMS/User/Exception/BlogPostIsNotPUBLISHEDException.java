package com.example.CMS.User.Exception;

public class BlogPostIsNotPUBLISHEDException extends RuntimeException {
	
	private String message;

	public BlogPostIsNotPUBLISHEDException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	

}
