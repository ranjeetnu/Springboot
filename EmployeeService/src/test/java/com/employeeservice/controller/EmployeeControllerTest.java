package com.employeeservice.controller;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.employeeservice.model.Employee;
import com.employeeservice.service.EmployeeService;
import com.employeeservice.validation.ValidationHelper;

@WebMvcTest
public class EmployeeControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	EmployeeService employeeService;
	
	@MockBean
	ValidationHelper validationHelper;

	@Test
	public void testAddEmployee() throws Exception {
		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee(101l, "Sam", "London", "Security"));
		when(employeeService.getEmployees()).thenReturn(list);
		mockMvc.perform(MockMvcRequestBuilders.get("/employees")).andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].city", is("London")));

	}
}
