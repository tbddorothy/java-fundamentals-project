package org.example.service;

import org.example.enums.Status;
import org.example.exception.EmployeeNotFoundException;
import org.example.exception.TaskNotFoundException;
import org.example.model.dto.TaskDto;
import org.example.model.entity.Employee;
import org.example.model.entity.Task;
import org.example.repository.EmployeeRepository;
import org.example.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.repository.TaskRepository;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task addTask(TaskDto taskDto) {
        Employee employee = employeeService.findById(taskDto.getEmployeeId());

        Task task = new Task();
        task.setDescription(taskDto.getDescription());
        task.setEmployee(employee);
        task.setStatus(taskDto.getStatus());

        return taskRepository.save(task);
    }

    @Override
    public List<Task> getTasks(Status status) {
        return taskRepository.getTasksByStatus(status);
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
    public void removeTask(Long id) {
        if(taskRepository.findById(id).isPresent()){
            taskRepository.deleteById(id);
        }else{
            throw new TaskNotFoundException("Task not found with id: " + id);
        }
    }

    @Override
    public Task updateTask(TaskDto taskDto, Long id) {
        if(taskRepository.findById(id).isPresent()){
            Employee employee = new Employee();

            Task task = new Task();
            task.setDescription(taskDto.getDescription());
            taskDto.setEmployeeId(task.getEmployee().getId());
            task.setStatus(taskDto.getStatus());

            return taskRepository.save(task);
        }else{
            throw new TaskNotFoundException("Task not found with id: " + id);
        }
    }
}
