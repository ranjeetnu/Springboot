package com.employeeservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.*;

@Slf4j
@ControllerAdvice
public class ExceptionsHandler {

	@ExceptionHandler(EmployeeNotFound.class)
	public ResponseEntity<Object> employeeNotFoundException(Exception e){
		log.error(e.getMessage());
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(DepartmentIsNotValid.class)
	public ResponseEntity<Object> departmentIsNotValid(Exception e){
		log.error(e.getMessage());
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
