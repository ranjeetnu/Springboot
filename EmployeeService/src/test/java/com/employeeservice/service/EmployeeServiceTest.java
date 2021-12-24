package com.employeeservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.employeeservice.model.Employee;
import com.employeeservice.repository.EmployeeRepository;

@SpringBootTest
public class EmployeeServiceTest {

	@MockBean
	EmployeeRepository employeeRepository;

	@Autowired
	private IEmployeeService employeeService;

	@Test
	public void testGetEmployees() {
		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee(101l, "Sam", "London", "Security"));
		when(employeeRepository.findAll()).thenReturn(list);
		List<Employee> lists = employeeService.getEmployees();
		assertEquals(1, lists.size());
	}
}
