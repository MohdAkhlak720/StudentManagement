package com.wecode.main.exceptionhandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomizedExceptionHandling extends ResponseEntityExceptionHandler {

	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<Object> handleUserNotFoundExceptions(DataNotFoundException exception, WebRequest webRequest) {
		ExceptionResponse response = new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage("Data not found for the given details.");
		ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		return entity;
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleExceptions(Exception exception, WebRequest webRequest) {
		ExceptionResponse response = new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage("Internal server error. Please try again.");
		ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		return entity;
	}
}