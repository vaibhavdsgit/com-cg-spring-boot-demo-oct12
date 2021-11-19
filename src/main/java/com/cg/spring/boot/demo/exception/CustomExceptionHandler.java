package com.cg.spring.boot.demo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice 
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{
	
	private static final Logger LOG = LoggerFactory.getLogger(CustomExceptionHandler.class);

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<Object> handleEmployeeNotFoundException() {
		LOG.error("handleEmployeeNotFoundException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This employee is NOT available in the database.");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmployeeAlreadyExists.class)
	public ResponseEntity<Object> handleEmployeeAlreadyExists() {
		LOG.error("handleEmployeeAlreadyExists");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "The Employee already exists in the database");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DepartmentNotFoundException.class)
	public ResponseEntity<Object> handleDepartmentNotFound() {
		LOG.error("handleDepartmentNotFound");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This department dosent't exist");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AppUserAlreadyExistsException.class)
	public ResponseEntity<Object> appUserAlreadyExists() {
		LOG.error("appUserAlreadyExists");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This username already exists");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AppUserNotFoundException.class)
	public ResponseEntity<Object> appUserNotFound() {
		LOG.error("appUserNotFound");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "UserName not found");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}
}
