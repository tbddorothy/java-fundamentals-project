package org.example.service;

import org.example.enums.Status;
import org.example.model.dto.TaskDto;
import org.example.model.entity.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();

    Task addTask(TaskDto taskDto);

    List<Task> getTasks(Long employeeId, Status status);

    List<Task> getTasks(Status status);

    List<Task> getTasks(Long employeeId);

    List<Task> getCompleteTasks(Status status);

    List<Task> getTasks();

    Task findById(Long id);

    void deleteTaskById(Long id);

    void updateTaskById(Long id, TaskDto taskDto);
}
