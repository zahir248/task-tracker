package com.prog.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.prog.model.Task;
import com.prog.service.TaskService;

/**
 * Controller class responsible for handling frontend requests related to tasks in the Task Management System.
 */
@Controller
public class TaskFrontendController {

    private final TaskService taskService;

    /**
     * Constructs a new TaskFrontendController with the specified TaskService.
     *
     * @param taskService The TaskService used to interact with tasks in the system.
     */
    public TaskFrontendController(TaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * Handles the request for the home page.
     *
     * @param model The Model object to add attributes for rendering the view.
     * @return The logical view name of the home page template (HomePage.html).
     */
    @GetMapping("/")
    public String homePage(Model model) {
    	List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("task", tasks);
        return "HomePage";
    }

    /**
     * Handles the request for the add task form page.
     *
     * @param model The Model object to add attributes for rendering the view.
     * @return The logical view name of the add task form page template (AddTaskPage.html).
     */
    @GetMapping("/addtask")
    public String addTaskForm(Model model) {
        return "AddTaskPage";
    }

    /**
     * Handles the request for the edit task form page.
     *
     * @param taskId The ID of the task to be edited.
     * @param model  The Model object to add attributes for rendering the view.
     * @return The logical view name of the edit task form page template (EditTaskPage.html).
     */
    @GetMapping("/edittask/{taskId}")
    public String editTaskForm(@PathVariable Long taskId, Model model) {
        Task task = taskService.getTaskById(taskId);
        model.addAttribute("task", task);
        return "EditTaskPage";
    }

    /**
     * Handles the request for the about system page.
     *
     * @param model The Model object to add attributes for rendering the view.
     * @return The logical view name of the about system page template (AboutSystemPage.html).
     */
    @GetMapping("/aboutsystem")
    public String aboutSystemPage(Model model) {
        return "AboutSystemPage";
    }
}