package org.example.service;

import org.example.exception.EmployeeNotFound;
import org.example.service.TaskService;
import org.example.enums.Status;
import org.example.model.entity.Task;
import org.example.repository.EmployeeRepository;
import org.example.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository _taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this._taskRepository = taskRepository;
    }

    @Override
    public List<Task> getAllTasks() {
        return _taskRepository.findAll();
    }

    @Override
    public Task addTask(Task task) {
        return _taskRepository.save(task);
    }

    @Override
    public List<Task> getTasks(Long employeeId, Status status) {
        return null;
    }

    @Override
    public List<Task> getTasks(Long employeeId) {
        return null;
    }

    @Override
    public List<Task> getTasks() {
        return null;
    }

    @Override
    public Task findById(Long id) {
        return _taskRepository.findById(id).orElseThrow(() -> new EmployeeNotFound("Employee not found with id: " + id));
    }

    public void deleteTask(Long id) {
        _taskRepository.deleteById(id);
    }

    public Task upateTask(Task task) {
        return _taskRepository.save(task);
    }

    public List<Task> getTasksByStatus(Status status) {
        return _taskRepository.findAllTasksByStatus(status);
    }
}
