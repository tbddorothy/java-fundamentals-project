package org.example.controller;

import org.example.enums.Status;
import org.example.exception.EmployeeNotFound;
import org.example.model.dto.EmployeeDto;
import org.example.model.dto.TaskDto;
import org.example.model.entity.Employee;
import org.example.model.entity.Task;
import org.example.service.EmployeeService;
import org.example.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/getTasksByStatus")
    public List<Task> getTasksByStatus(Status status) {
        return taskService.getTasksByStatus(status);
    }

    @PostMapping("/addTask")
    public ResponseEntity<?> addTask(@RequestBody TaskDto taskdto) {
        Employee employee = employeeService.findById(taskdto.getEmployeeId());
        Task task = new Task();
        if (employee != null) {
            task.setDescription(taskdto.getDescription());
            task.setEmployee(employee);
            task.setStatus(taskdto.getStatus());
            task.setCompletion(taskdto.getCompletion());
            taskService.addTask(task);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }

    @DeleteMapping("/deleteTask/{id}")
    public ResponseEntity<Task> deleteTaskById(@PathVariable Long id) {
        try {
            Task task = taskService.findById(id);
            if (task != null) {
                taskService.deleteTask(id);
            }
            return ResponseEntity.ok(task);
        } catch (EmployeeNotFound ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/updateTask/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody TaskDto taskdto) {
        try {
            Task task = taskService.findById(id);
            if (task != null) {
                Employee employee = employeeService.findById(taskdto.getEmployeeId());
                Date date = new Date();
                if (employee != null) {
                    task.setDescription(taskdto.getDescription());
                    task.setEmployee(employee);
                    task.setStatus(taskdto.getStatus());
                    taskService.upateTask(task);
                }
            }
            return ResponseEntity.ok(task);
        } catch (EmployeeNotFound ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
