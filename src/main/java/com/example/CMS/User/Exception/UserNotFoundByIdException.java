package com.example.CMS.User.Exception;

public class UserNotFoundByIdException extends RuntimeException{
	
	public UserNotFoundByIdException(String message) {
		super(message);
	}

}
