package com.employeeservice.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.employeeservice.model.Employee;
import com.employeeservice.service.IEmployeeService;

@Configuration
public class EmployeeUtil {
	
	@Autowired
	IEmployeeService employeeService;
	
	@Bean
	public CommandLineRunner createContext() {
		return (args)->{
			employeeService.save(new Employee(1l, "Ranjeet", "Pune","IT"));
			employeeService.save(new Employee(2l, "Samir", "Nashik","HR"));
		};
	}

}
