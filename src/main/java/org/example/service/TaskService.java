package org.example.service;

import org.example.enums.Status;
import org.example.model.entity.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();
    Task addTask(Task task);
    List<Task> getTasks(long EmployeeId, Status status);
    List<Task> getTasks(long EmployeeId);
    Task getTasksOrThrowException(long id);
    void deleteTask (long id);

    List<Task> findAllByStatus (Status status);
}
