package com.employeeservice.validation;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ValidationHelper {

	public void handle(List<Validator> validators) {
		for (Validator v : validators) {
			v.validate();
		}
	}
}
