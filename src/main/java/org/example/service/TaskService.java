package org.example.service;

import org.example.enums.Status;
import org.example.model.entity.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();

    void deleteTask(Long id);

    Task addTask(Task task);


    Task updateTask(Task task);

    List<Task> getTask(Long employeeId, Status status);

    List<Task> getTask(Long employeeID);

    List<Task> findAllByStatus(Status status);

    Task findById(Long id);
}
