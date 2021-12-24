package com.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeeservice.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
