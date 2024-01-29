package org.example.service;

import org.example.enums.Status;
import org.example.model.dto.TaskDto;
import org.example.model.entity.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();

    Task addTask(Task task);

    Task addTask(TaskDto taskDto);

    List<Task> getTasks(Long employeeId, Status status);

    List<Task> getTasks(Long employeeId);

    List<Task> getTasks();

    Task findById(Long id);

    void deleteTask(Long id);

    Task updateTask (Task task);

}
