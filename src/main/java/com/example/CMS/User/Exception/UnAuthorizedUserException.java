package com.example.CMS.User.Exception;

public class UnAuthorizedUserException extends RuntimeException{
	
	public UnAuthorizedUserException(String message) {
		super(message);
	}

}
