package com.employeeservice.service;

import java.util.List;
import java.util.Optional;

import com.employeeservice.model.Employee;

public interface IEmployeeService{
	
	public List<Employee> getEmployees();
	
	public void save(Employee e);
	
	public void deleteEmployee(Long id);
	
	public void update(Employee e);
	
	public Optional<Employee> findById(long id);

}
