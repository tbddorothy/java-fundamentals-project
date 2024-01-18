package org.example.service;

import org.example.enums.Status;
import org.example.model.dto.TaskDto;
import org.example.model.entity.Task;
import org.example.repository.EmployeeRepository;
import org.example.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;
    private final EmployeeRepository employeeRepository;

    public TaskServiceImpl(TaskRepository taskRepository, EmployeeRepository employeeRepository) {
        this.taskRepository = taskRepository;
        this.employeeRepository = employeeRepository;
    }

    public List<Task> findAllByEmployeeId(Long employeeId) {
        return null;
    }
    @Override
    public List<Task> getAllTasks() {
        return null;
    }


    public List<Task> getTasksByEmployee_Id(Long employeeId) {
        return null;
    }

    public Task addTask(TaskDto taskDto) {
        Task newTask = new Task();
        newTask.setDescription(taskDto.getDescription());
        newTask.setStatus(taskDto.getStatus());
        newTask.setEmployee(employeeRepository.findById(taskDto.getEmployeeId()).get());
        taskRepository.save(newTask);
        return newTask;
    }

    @Override
    public List<Task> getTasks(Long employeeId, Status status) {
        return null;
    }

    @Override
    public List<Task> getTasks(Long employeeId) {
        return null;
    }

    @Override
    public List<Task> getTasks() {
        return null;
    }

    @Override
    public List<Task> getTasksByStatus(Status status) {
        List<Task> tasks = null;
        taskRepository.getTasksByStatus(status);
        return tasks;
    }

    @Override
    public Void removeTask(Long id) {
        return null;
    }

    @Override
    public Task updateTask(Long id) {
        return null;
    }
}
