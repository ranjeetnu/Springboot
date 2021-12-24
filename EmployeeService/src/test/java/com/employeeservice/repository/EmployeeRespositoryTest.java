package com.employeeservice.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.employeeservice.model.Employee;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class EmployeeRespositoryTest {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Test
	public void testEmployeeSave() {
		Employee e = new Employee(10,"Ranjeet","Pune","IT");
		employeeRepository.save(e);
		assertEquals("IT", employeeRepository.findById(10l).get().getDepartment());
		
	}

}
