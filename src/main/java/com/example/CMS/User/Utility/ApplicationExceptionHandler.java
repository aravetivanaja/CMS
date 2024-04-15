package com.example.CMS.User.Utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.CMS.User.Exception.BlogAlreadyExistsByTitleException;
import com.example.CMS.User.Exception.BlogNotFoundByIdException;
import com.example.CMS.User.Exception.BlogPostNotFoundByIdException;
import com.example.CMS.User.Exception.ContributionPanelNotFoundByIdException;
import com.example.CMS.User.Exception.TitleNotAvailableException;
import com.example.CMS.User.Exception.UserAlreadyExistByEmailException;
import com.example.CMS.User.Exception.UserNotFoundByIdException;

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

	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> handleBlogAlreadyExistsByTitle(
			BlogAlreadyExistsByTitleException ex)
	{
		return errorResponse(HttpStatus.BAD_REQUEST, ex.getMessage(),
				"blog already exists with the given title");
	}

	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> handleUserNotFoundById(
			UserNotFoundByIdException ex)
	{
		return errorResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), "user not found by id");
	}

	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> handleTitleNotAvailableException(
			TitleNotAvailableException ex)
	{
		return errorResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), "Title not available");
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> handleContributionPanelNotFoundById(
			ContributionPanelNotFoundByIdException ex)
	{
		return errorResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), "panel not found");
	}

	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> handleBlogNotFoundById(
			BlogNotFoundByIdException ex)
	{
		return errorResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), "blog not found by id");
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> handleBlogPostNotFoundById(
			BlogPostNotFoundByIdException ex)
	{
		return errorResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), "blogpost not found by id");
	}

}
