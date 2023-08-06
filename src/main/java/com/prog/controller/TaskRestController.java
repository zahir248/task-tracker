package com.prog.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.prog.service.TaskService;
import com.prog.model.Task;

/**
 * RESTful Controller class responsible for handling API requests related to tasks in the Task Management System.
 */
@RestController
@RequestMapping("/api/task")
public class TaskRestController {
	
	private final TaskService taskService;

    /**
     * Constructs a new TaskRestController with the specified TaskService.
     *
     * @param taskService The TaskService used to interact with tasks in the system.
     */
    public TaskRestController(TaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * Handles the GET request to retrieve all tasks.
     *
     * @return The list of all tasks in the system.
     */
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }
    
    /**
     * Handles the GET request to retrieve a task by its ID.
     *
     * @param taskId The ID of the task to retrieve.
     * @return The Task object with the specified ID, or null if the task is not found.
     */
    @GetMapping("/{taskId}")
    public Task getTaskById(@PathVariable Long taskId) {
        return taskService.getTaskById(taskId);
    }
    
    /**
     * Handles the POST request to create a new task.
     *
     * @param task The Task object containing the details of the task to be created.
     * @return The created Task object with its generated ID.
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }
    
    /**
     * Handles the PUT request to update an existing task.
     *
     * @param taskId      The ID of the task to be updated.
     * @param updatedTask The Task object containing the updated details of the task.
     * @return The updated Task object.
     */
    @PutMapping("/{taskId}")
    @ResponseStatus(HttpStatus.OK)
    public Task updateTask(@PathVariable Long taskId, @RequestBody Task updatedTask) {
        return taskService.updateTask(taskId, updatedTask);
    }
    
    /**
     * Handles the DELETE request to delete a task by its ID.
     *
     * @param taskId The ID of the task to be deleted.
     */
    @DeleteMapping("/{taskId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
    }
}
