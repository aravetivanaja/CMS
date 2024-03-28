package com.example.CMS.User.Utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.CMS.User.Exception.UserAlreadyExistByEmailException;

import lombok.AllArgsConstructor;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	
	private ErrorStructure<String> Structure;
	
	
	
	public ApplicationExceptionHandler(ErrorStructure<String> structure) {
		super();
		Structure = structure;
	}

	private ResponseEntity<ErrorStructure<String>> errorResponse(
		HttpStatus status,String message,String rootCause)
	{
		return new ResponseEntity<ErrorStructure<String>>(Structure
				.setStatus(status.value())
				.setMessage(message)
				.setRootCause(rootCause),status);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> handleUserAlreadyExistByEmail(
			UserAlreadyExistByEmailException ex)
	{
		return errorResponse(HttpStatus.BAD_REQUEST, ex.getMessage(),
				"user already exists with the given email");
	}
	


}
