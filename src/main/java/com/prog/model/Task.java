package com.prog.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Represents a task entity in the Task Management System.
 */
@Entity
@Table(name= "task")
public class Task {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long taskId;
	private String taskName;
	private String taskDescription;
	private LocalDate taskDueDate;
	private String taskStatus;
	
	/**
	 * Default constructor for the Task class.
	 */
	public Task() {
		super();
	}

	/**
	 * Gets the ID of the task.
	 *
	 * @return The task ID.
	 */
	public Long getTaskId() {
		return taskId;
	}

	/**
	 * Sets the ID of the task.
	 *
	 * @param taskId The task ID to set.
	 */
	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	/**
	 * Gets the name of the task.
	 *
	 * @return The task name.
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * Sets the name of the task.
	 *
	 * @param taskName The task name to set.
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/**
	 * Gets the description of the task.
	 *
	 * @return The task description.
	 */
	public String getTaskDescription() {
		return taskDescription;
	}

	/**
	 * Sets the description of the task.
	 *
	 * @param taskDescription The task description to set.
	 */
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	/**
	 * Gets the due date of the task.
	 *
	 * @return The task due date.
	 */
	public LocalDate getTaskDueDate() {
		return taskDueDate;
	}

	/**
	 * Sets the due date of the task.
	 *
	 * @param taskDueDate The task due date to set.
	 */
	public void setTaskDueDate(LocalDate taskDueDate) {
		this.taskDueDate = taskDueDate;
	}

	/**
	 * Gets the status of the task.
	 *
	 * @return The task status.
	 */
	public String getTaskStatus() {
		return taskStatus;
	}

	/**
	 * Sets the status of the task.
	 *
	 * @param taskStatus The task status to set.
	 */
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	/**
	 * Returns a string representation of the Task object.
	 *
	 * @return A string representation of the Task object.
	 */
	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", taskName=" + taskName + ", "
				+ "taskDescription=" + taskDescription + ", "
				+ "taskDueDate=" + taskDueDate + ", taskStatus=" + taskStatus + "]";
	}
}
