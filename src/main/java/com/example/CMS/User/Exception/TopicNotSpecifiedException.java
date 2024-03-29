package com.example.CMS.User.Exception;

public class TopicNotSpecifiedException extends RuntimeException {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public TopicNotSpecifiedException(String message) {
		super();
		this.message = message;
	}
	
	

}
