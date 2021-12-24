package com.employeeservice.exception;

public class DepartmentIsNotValid extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DepartmentIsNotValid(String message) {
		super(message);
	}

}
