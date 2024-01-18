package org.example.controller;

import org.example.enums.Status;
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


    @GetMapping("/tasks")
    public List<Task> getTasks(Status status){
        return taskService.getTasks(status);
    }

    @PostMapping("")
    public ResponseEntity<?> addTask(@RequestBody TaskDto taskDto){
        Task savedTask = taskService.addTask(taskDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTask);
    }

    @DeleteMapping("/deleteTask/{id}")
    public ResponseEntity<?> removeTask(@PathVariable Long id) {
        try{
            taskService.removeTask(id);
            return ResponseEntity.ok("Task Deleted");
        }catch (Exception ex){
            return ResponseEntity.ok(ex);
        }
    }

    @PostMapping("/updateTask/{id}")
    public ResponseEntity<?> updateTask(@RequestBody TaskDto taskDto, @PathVariable Long id){
        try{
            taskService.updateTask(taskDto, id);
            return ResponseEntity.ok("Updated Task");
        }catch (Exception ex){
            return ResponseEntity.ok(ex);
        }
    }
}
