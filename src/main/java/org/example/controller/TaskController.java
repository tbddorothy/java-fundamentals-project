package org.example.controller;

import org.example.exception.EmployeeNotFoundException;
import org.example.exception.TaskNotFoundException;
import org.example.model.dto.EmployeeDto;
import org.example.model.dto.TaskDto;
import org.example.model.entity.Employee;
import org.example.model.entity.Task;
import org.example.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public List<Task> getEmployees() {
        return taskService.getAllTasks();
    }

    @PostMapping("/add")
    public ResponseEntity<?> addTask(@RequestBody TaskDto taskDto) {
        Task savedTask = taskService.addTask(taskDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedTask);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTaskById(@PathVariable Long id) {

        Task task = taskService.findById(id);
        taskService.deleteTaskById(id);
        return ResponseEntity.ok(task);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTaskById(@PathVariable Long id, @RequestBody TaskDto taskDto) {
        Task task = taskService.findById(id);
        taskService.updateTaskById(id, taskDto);
        return ResponseEntity.ok(task);
    }

}
