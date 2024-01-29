package org.example.controller;

import org.example.exception.TaskNotFoundException;
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
    public List<Task> getTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping("")
    public ResponseEntity<Task> addTask(@RequestBody TaskDto taskDto) {
        Task savedTask = taskService.addTask(taskDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTask);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Task> getTaskById(@PathVariable Long id){
//        try {
//            Task task = taskService.findById(id);
//            return ResponseEntity.ok(task);
//        }
//        catch(TaskNotFoundException ex) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        }
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) {
        try {
            taskService.deleteTask(id);
            return ResponseEntity.ok("Successfully deleted");
        }
        catch(TaskNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@RequestBody Task task) {
        try {
            Task updateTask = taskService.updateTask(task);
            return ResponseEntity.ok(task);
        }
        catch(TaskNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}