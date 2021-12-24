package com.employeeservice.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.employeeservice.exception.EmployeeNotFound;
import com.employeeservice.model.Employee;
import com.employeeservice.service.IEmployeeService;
import com.employeeservice.validation.EmployeeValidation;
import com.employeeservice.validation.ValidationHelper;
import com.employeeservice.validation.Validator;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private IEmployeeService employeeService;
	
	@Autowired
	ValidationHelper validationHelper;

	@Operation(summary = "Add Employee")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Employed added.")})
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void addEmployee(@Validated @RequestBody Employee employee) {
		EmployeeValidation empValidation = new EmployeeValidation();
		empValidation.setDepartment(employee.getDepartment());
		List<Validator> validators = new ArrayList<Validator>();
		validators.add(empValidation);
		validationHelper.handle(validators);
		employeeService.save(employee);
	}

	@Operation(summary = "Get Employees")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Success.")})
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<Employee> getEmployees() {
		return employeeService.getEmployees();
	}

	@Operation(summary = "Update Employee")
	@ApiResponses(value = { @ApiResponse(responseCode = "202", description = "Success.")})
	@PutMapping
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void updateEmployee(@Validated @RequestBody Employee employee) {
		if(employeeService.findById(employee.getId()).isPresent()) {
			employeeService.save(employee);
		}
		throw new EmployeeNotFound("Employee with this id not found :"+employee.getId());
	}

	@Operation(summary = "Delete Employee")
	@ApiResponses(value = { @ApiResponse(responseCode = "202", description = "Employee Deleted.")})
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void deleteEmployee(@PathVariable @Min(value = 1) long id) {
		employeeService.deleteEmployee(id);
	}

}
