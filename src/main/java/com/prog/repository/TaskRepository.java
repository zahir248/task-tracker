package com.prog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prog.model.Task;

/**
 * Repository interface for managing Task entities in the Task Management System.
 */
public interface TaskRepository extends JpaRepository<Task, Long> {
	
}
