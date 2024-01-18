package org.example.service;

import org.example.enums.Status;
import org.example.model.dto.TaskDto;
import org.example.model.entity.Task;

import java.util.*;

public interface TaskService {
    List<Task> getAllTasks();

    Task addTask(Task task);

    Task addTask(TaskDto taskDto);

    List<Task> getTasks(Status status);

    List<Task> getTasks(Long employeeId);

    List<Task> getTasks();

    public void removeTask(Long id);

    public Task updateTask(TaskDto taskDto, Long id);
}
