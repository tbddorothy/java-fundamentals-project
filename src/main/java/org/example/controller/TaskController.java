package org.example.controller;

import org.example.model.dto.EmployeeDto;
import org.example.model.dto.TaskDto;
import org.example.model.entity.Employee;
import org.example.model.entity.Task;
import org.example.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/tasks")
public class TaskController {


    @Autowired
    private TaskService taskService;

    @PostMapping("/add")
    public ResponseEntity<?> addTask(@RequestBody TaskDto taskDto, Long id) {
        Task savedTask = taskService.addTask(taskDto, id);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedTask);
    }

    @DeleteMapping("remove/{id}")
    public  ResponseEntity<Task> deleteTaskById(@PathVariable Long id) {

        taskService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateTaskById(@RequestBody TaskDto taskDto ,@PathVariable Long id){
        Task updatedTask = taskService.updateById(taskDto, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(updatedTask);
    }
}
