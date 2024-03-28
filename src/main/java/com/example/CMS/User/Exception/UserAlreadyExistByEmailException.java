package com.example.CMS.User.Exception;



@SuppressWarnings("serial")


public class UserAlreadyExistByEmailException extends RuntimeException{
	
	private String message;
	
	public String getMessage() {
		return message;
	}
	
	public UserAlreadyExistByEmailException(String message) {
		super();
		this.message = message;
	}

}


	
	
	
	


	
	


