package com.masaischool.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<MyErrorDetails> customerExceptionHandler(CustomerException ex, WebRequest req){
		//Create an object of MyErrorDetails
		MyErrorDetails myErrorDetails = new MyErrorDetails(LocalDateTime.now(), ex.getMessage(), req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(myErrorDetails, HttpStatus.BAD_REQUEST);
	}
		
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> otherExceptionHandler(Exception ex, WebRequest req){
		MyErrorDetails err= new MyErrorDetails(LocalDateTime.now(), ex.getMessage(), req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.INTERNAL_SERVER_ERROR);	
	}
}