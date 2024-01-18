package org.example.service;

import org.example.enums.Status;
import org.example.model.dto.TaskDto;
import org.example.model.entity.Employee;
import org.example.model.entity.Task;

import java.util.*;

public interface TaskService {

    List<Task> getAllTasks();

    Task addTask(TaskDto taskDto);

    List<Task> getTasks(Long employeeId, Status status);

    List<Task> getTasks(Long employeeId);

    List<Task> getTasks();

    void deleteTask(Long id);

    Task updateTask(Task task);

}
