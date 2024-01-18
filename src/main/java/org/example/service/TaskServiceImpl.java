package org.example.service;

import org.example.enums.Status;
import org.example.exception.TaskNotFoundException;
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
        return this.taskRepository.findAll();
    }

    @Override
    public Task addTask(Task task) {
        return this.taskRepository.save(task);
    }

    @Override
    public List<Task> getTasks(long EmployeeId, Status status) {
        return this.taskRepository.findAll();
    }

    @Override
    public List<Task> getTasks(long EmployeeId) {
        return null;
    }

    @Override
    public Task getTasksOrThrowException(long id) {
        return this.taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task not found!"));
    }

    @Override
    public void deleteTask(long id) {
        this.taskRepository.deleteById(id);
    }

    public List<Task> findAllByStatus(Status status) {
        return this.taskRepository.findAllByStatus(status);
    }

    public Task setTaskToOverdue (Task task){
        task.setStatus(Status.OVERDUE);
        return task;
    }

}
