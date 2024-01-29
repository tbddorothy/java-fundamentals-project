package org.example.service;

import org.example.enums.Status;
import org.example.exception.TaskNotFoundException;
import org.example.model.dto.TaskDto;
import org.example.model.entity.Task;
import org.example.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task addTask(TaskDto taskDto) {
        return taskRepository.save(new Task(taskDto));
    }

    @Override
    public List<Task> getTasks(Long employeeId, Status status) {
        return taskRepository.findAllTasksByStatusAndEmployeeId(employeeId, status);
    }

    @Override
    public List<Task> getTasks(Long employeeId) {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task findById(Long id) {
        return taskRepository.findById(id).orElseThrow(() ->
                new TaskNotFoundException("Task not found with id: " + id));
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }
}
