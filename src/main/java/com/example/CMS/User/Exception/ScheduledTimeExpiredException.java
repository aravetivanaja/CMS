package com.example.CMS.User.Exception;

public class ScheduledTimeExpiredException extends RuntimeException {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public ScheduledTimeExpiredException(String message) {
		super();
		this.message = message;
	}

	
	

}
