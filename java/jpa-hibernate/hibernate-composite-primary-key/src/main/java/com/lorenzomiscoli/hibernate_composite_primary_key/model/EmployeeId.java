package com.lorenzomiscoli.hibernate_composite_primary_key.model;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class EmployeeId implements Serializable {

	@Column(name = "employee_id")
	private Long employeeId;

	@Column(name = "department_id")
	private Long departmentId;

	public EmployeeId() {
	}

	public EmployeeId(Long employeeId, Long departmentId) {
		this.employeeId = employeeId;
		this.departmentId = departmentId;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof EmployeeId))
			return false;
		EmployeeId employeeId = (EmployeeId) o;
		return Objects.equals(getEmployeeId(), employeeId.getEmployeeId())
				&& Objects.equals(getDepartmentId(), employeeId.getDepartmentId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getEmployeeId(), getDepartmentId());
	}
	
}
