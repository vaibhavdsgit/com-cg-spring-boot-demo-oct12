package com.cg.spring.boot.demo.exception;

public class EmployeeAlreadyExists extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	public EmployeeAlreadyExists() {
		super();
	}
	public EmployeeAlreadyExists(String message) {
		super(message);
	}
}
