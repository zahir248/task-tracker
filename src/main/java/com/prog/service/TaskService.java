package com.prog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prog.model.Task;
import com.prog.repository.TaskRepository;

/**
 * Service class for managing tasks in the Task Management System.
 */
@Service
public class TaskService {

    private final TaskRepository taskRepository;

    /**
     * Constructs a new TaskService with the specified TaskRepository.
     *
     * @param taskRepository The TaskRepository used for interacting with the database.
     */
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    /**
     * Retrieves all tasks from the database.
     *
     * @return A list of all tasks in the system.
     */
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    /**
     * Retrieves a task by its ID from the database.
     *
     * @param taskId The ID of the task to retrieve.
     * @return The Task object with the specified ID, or null if the task is not found.
     */
    public Task getTaskById(Long taskId) {
        return taskRepository.findById(taskId).orElse(null);
    }

    /**
     * Creates a new task in the database.
     * If taskStatus is not provided, it sets the default status to "To Do".
     *
     * @param task The Task object containing the details of the task to be created.
     * @return The created Task object with its generated ID.
     */
    public Task createTask(Task task) {
        if (task.getTaskStatus() == null) {
            task.setTaskStatus("To Do");
        }
        return taskRepository.save(task);
    }

    /**
     * Updates an existing task in the database with the provided details.
     *
     * @param taskId      The ID of the task to be updated.
     * @param updatedTask The Task object containing the updated details of the task.
     * @return The updated Task object, or null if the task with the given ID is not found.
     */
    public Task updateTask(Long taskId, Task updatedTask) {
        Task existingTask = taskRepository.findById(taskId).orElse(null);
        if (existingTask != null) {
            existingTask.setTaskName(updatedTask.getTaskName());
            existingTask.setTaskDescription(updatedTask.getTaskDescription());
            existingTask.setTaskDueDate(updatedTask.getTaskDueDate());
            existingTask.setTaskStatus(updatedTask.getTaskStatus());
            return taskRepository.save(existingTask);
        }
        return null;
    }

    /**
     * Deletes a task from the database based on its ID.
     *
     * @param taskId The ID of the task to be deleted.
     */
    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }
}
