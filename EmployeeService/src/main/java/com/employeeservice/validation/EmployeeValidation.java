package com.employeeservice.validation;

import org.springframework.stereotype.Component;

import com.employeeservice.exception.DepartmentIsNotValid;

import ch.qos.logback.classic.Logger;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Component
@Setter
@Slf4j
public class EmployeeValidation implements Validator {

	private String department;

	@Override
	public void validate() {
		if (!isValidDepartment()) {
			log.info("Department name validation failed");
			throw new DepartmentIsNotValid("Department name validation failed");
		}
	}

	private boolean isValidDepartment() {
		return (!department.isEmpty() && !department.equalsIgnoreCase("Art"));
	}

}
