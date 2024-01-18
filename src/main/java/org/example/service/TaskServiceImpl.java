package org.example.service;

import org.example.Exception.EmployeeNotFoundException;
import org.example.enums.Status;
import org.example.model.entity.Task;
import org.example.repository.Taskrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final Taskrepository taskrepository;

    @Autowired
    public TaskServiceImpl(Taskrepository taskrepository) {
        this.taskrepository = taskrepository;
    }

    @Override
    public List<Task> getAllTasks() {
        return taskrepository.findAll();
    }

    @Override
    public void deleteTask(Long id) {
        taskrepository.deleteById(id);
    }

    @Override
    public Task addTask(Task task) {
        return taskrepository.save(task);
    }

    @Override
    public Task updateTask(Task task) {
        return taskrepository.save(task);
    }

    @Override
    public List<Task> getTask(Long employeeId, Status status) {
        return null;
    }

    @Override
    public List<Task> getTask(Long employeeID) {
        return null;
    }

    @Override
    public List<Task> findAllByStatus(Status status) {
        return taskrepository.findAllByStatus(status);
    }

    @Override
    public Task findById(Long id) {
        return null;
    }
}
