package com.employeeservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Employee {
	
	@Min(value = 1)
	private @Id long id;
	
	@NotBlank
	private String empName;
	
	@NotBlank
	private String city;
	
	@NotBlank
	private String department;

}
