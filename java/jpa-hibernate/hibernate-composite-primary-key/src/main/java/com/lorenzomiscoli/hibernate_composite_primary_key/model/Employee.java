package com.lorenzomiscoli.hibernate_composite_primary_key.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@EmbeddedId
	private EmployeeId employeeId;

	public Employee() {

	}

	public Employee(EmployeeId employeeId) {
		this.employeeId = employeeId;
	}

	public EmployeeId getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(EmployeeId employeeId) {
		this.employeeId = employeeId;
	}

}
