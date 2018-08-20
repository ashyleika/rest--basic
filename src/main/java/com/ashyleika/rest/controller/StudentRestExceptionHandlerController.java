package com.ashyleika.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ashyleika.rest.exception.StudentErrorResponse;
import com.ashyleika.rest.exception.StudentNotFoundException;

@ControllerAdvice
public class StudentRestExceptionHandlerController {

	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
		
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleExeption(Exception exc) {
		
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage("BAD REQUEST");
		error.setTimeStamp(System.currentTimeMillis());
		
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
}
