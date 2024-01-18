package org.example.service;

import org.example.enums.Status;
import org.example.model.dto.TaskDto;
import org.example.model.entity.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();
    Task addTask(TaskDto taskDto);
    List<Task> getTasks(Long employeeId, Status status);
    List<Task> getTasks(Long employeeId);
    List<Task> getTasks();
    Void removeTask(Long id);
    Task updateTask(Long id);

    List<Task> getTasksByEmployee_Id(Long employeeId);

}
