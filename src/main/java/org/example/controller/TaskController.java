package org.example.controller;

import org.example.Exception.EmployeeNotFoundException;
import org.example.enums.Status;
import org.example.model.dto.TaskDto;
import org.example.model.entity.Employee;
import org.example.model.entity.Task;
import org.example.service.EmployeeService;
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
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/getTask")
    public List<Task> getTask() {
        return taskService.getAllTasks();
    }

    @PostMapping("/addTask")
    public ResponseEntity<?> addTask(@RequestBody TaskDto taskdto) {
        try {
            Employee employee = employeeService.findById(taskdto.getEmployeeId());
            Task task = new Task();
            if (employee != null) {
                task.setStatus(taskdto.getStatus());
                task.setDescription(taskdto.getDescription());
                task.setEmployee(employee);
                taskService.addTask(task);
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(task);

        } catch (EmployeeNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("deleteTask/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) {
        try {
            Task task = taskService.findById(id);
            taskService.deleteTask(id);
            return ResponseEntity.ok(task);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("updateTask/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody TaskDto taskDto) {
        try {
            Task task = taskService.findById(id);
            if (task != null) {
                task.setDescription(taskDto.getDescription());
                taskService.updateTask(task);
            }
            return ResponseEntity.ok(task);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("getByStatus/")
    public List<Task> getTaskByStatus(Status status) {
        return taskService.findAllByStatus(status);
    }
}
