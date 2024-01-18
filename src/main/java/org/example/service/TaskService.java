package org.example.service;

import org.example.enums.Status;
import org.example.model.dto.TaskDto;
import org.example.model.entity.Task;

import java.util.List;

public interface TaskService {

    List<Task> getAllTasks();

    Task addTask(Task task);

    Task addTask(TaskDto taskDto, Long id);

    void deleteById( Long id);

    List<Task> getTasks(Long employee_id, Status status);

    List<Task> getTasks(Long employee_id);

    List<Task> getTasks();

    Task updateById(TaskDto taskDto, Long id);
}
