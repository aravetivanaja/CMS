package com.example.CMS.User.Exception;

public class BlogAlreadyExistsByTitleException extends RuntimeException{
	
	private String message;

	public String getMessage() {
		return message;
	}

	public BlogAlreadyExistsByTitleException(String message) {

		this.message = message;
	}
	
	

}
