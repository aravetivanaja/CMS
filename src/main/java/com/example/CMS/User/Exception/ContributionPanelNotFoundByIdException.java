package com.example.CMS.User.Exception;

public class ContributionPanelNotFoundByIdException extends RuntimeException{

	private String message;

	public ContributionPanelNotFoundByIdException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	
}
