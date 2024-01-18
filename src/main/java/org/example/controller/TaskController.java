package org.example.controller;

import org.example.exceptions.EmployeeNotFoundException;
import org.example.model.dto.TaskDto;
import org.example.model.entity.Task;
import org.example.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/task")
    public List<Task> getTask() {
        return taskService.getAllTasks();
    }

    @PostMapping("")
    public ResponseEntity<Task> addTask(@RequestBody TaskDto taskDto) {
        Task savedTask = taskService.addTask(taskDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTask);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id)
    {
        try {
            taskService.deleteTask(id);
            return ResponseEntity.ok("Task Removed");
        } catch (EmployeeNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@RequestBody Task task)
    {
        try {
            Task updatedTask = taskService.updateTask(task);
            return ResponseEntity.ok(task);
        }catch (EmployeeNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
