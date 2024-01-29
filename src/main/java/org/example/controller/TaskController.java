package org.example.controller;

import org.example.enums.Status;
import org.example.exception.EmployeeNotFoundException;
import org.example.exception.TaskNotFoundException;
import org.example.model.dto.TaskDto;
import org.example.model.dto.TaskDtoWithoutEmployee;
import org.example.model.entity.Employee;
import org.example.model.entity.Task;
import org.example.service.EmployeeService;
import org.example.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/{id}")
    public ResponseEntity<Task> addTask(@PathVariable long id, TaskDtoWithoutEmployee taskDtoWithoutEmployee) {
        try {
            Employee employeeFound = this.employeeService.findById(id);
            TaskDto taskDto = new TaskDto(employeeFound, taskDtoWithoutEmployee);
            Task task = new Task(taskDto);
            this.taskService.addTask(task);
            return ResponseEntity.ok(task);
        } catch (EmployeeNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable long id, TaskDtoWithoutEmployee taskDtoWithoutEmployee) {
        try {
            Task taskFound = this.taskService.getTasksOrThrowException(id);
            TaskDto taskDto = new TaskDto(taskFound.getEmployee(), taskDtoWithoutEmployee);
            taskFound = new Task(taskDto);
            return ResponseEntity.ok(taskFound);
        } catch (TaskNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteTask(@PathVariable long id) {
        try {
            Task taskFound = this.taskService.getTasksOrThrowException(id);
            this.taskService.deleteTask(id);
            return ResponseEntity.ok(true);
        }
        catch (TaskNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    @GetMapping("completed/{status}")
    public ResponseEntity<List<Task>> getCompletedTasks(Status status) {
        try {
           return ResponseEntity.ok(this.taskService.findAllByStatus(status));
        }
        catch (TaskNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
