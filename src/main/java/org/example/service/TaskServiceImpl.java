package org.example.service;

import org.example.enums.Status;
import org.example.model.dto.TaskDto;
import org.example.model.entity.Task;
import org.example.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task addTask(TaskDto taskDto) {
        return taskRepository.save(new Task(taskDto));
    }

    @Override
    public List<Task> getTasks(Long employeeId, Status status) {
        return null;
    }

    @Override
    public List<Task> getTasks(Status status) {
        return null;
    }

    @Override
    public List<Task> getTasks(Long employeeId) {
        return null;
    }

    @Override
    public List<Task> getCompleteTasks(Status status) {
        return null;
    }

    @Override
    public List<Task> getTasks() {
        return null;
    }

    @Override
    public Task findById(Long id) {
        return null;
    }

    @Override
    public void deleteTaskById(Long id) {

    }

    @Override
    public void updateTaskById(Long id, TaskDto taskDto) {

    }

}
