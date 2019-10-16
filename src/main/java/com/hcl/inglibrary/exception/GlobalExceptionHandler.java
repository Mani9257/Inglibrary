package com.hcl.inglibrary.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CommonException.class)
	public ResponseEntity<ResponseError> commonException(Exception e) {
		ResponseError error = new ResponseError(e.getMessage(), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(error, HttpStatus.OK);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ResponseError> globalExceptionHandler(UserNotFoundException exception) {

		ResponseError errorResponse = new ResponseError();
		errorResponse.setMessage(exception.getMessage());
		errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

	}

}