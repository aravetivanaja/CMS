package com.example.CMS.User.Exception;

public class ScheduleNotFoundException extends RuntimeException{
	
	private String message;

	public String getMessage() {
		return message;
	}

	public ScheduleNotFoundException(String message) {
		super();
		this.message = message;
	}
	
	
	
	

}
