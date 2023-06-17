package com.lorenzomiscoli.hibernate_composite_primary_key.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;

public class TaskId implements Serializable {

	@Column(name = "task_number")
	private String taskNumber;

	@Column(name = "task_type")
	private String taskType;

	public TaskId() {
	}

	public TaskId(String taskNumber, String taskType) {
		this.taskNumber = taskNumber;
		this.taskType = taskType;
	}

	public String getTaskNumber() {
		return taskNumber;
	}

	public String getTaskType() {
		return taskType;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof EmployeeId))
			return false;
		TaskId taskId = (TaskId) o;
		return Objects.equals(getTaskNumber(), taskId.getTaskNumber())
				&& Objects.equals(getTaskType(), taskId.getTaskType());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getTaskNumber(), getTaskType());
	}

}
