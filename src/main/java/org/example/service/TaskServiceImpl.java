package org.example.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.enums.Status;
import org.example.exception.EmployeeNotFoundExeption;
import org.example.model.dto.EmployeeDto;
import org.example.model.dto.TaskDto;
import org.example.model.entity.Employee;
import org.example.model.entity.Task;
import org.example.repository.EmployeeRepository;
import org.example.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final EmployeeRepository employeeRepository;

    public TaskServiceImpl(TaskRepository taskRepository, EmployeeRepository employeeRepository) {
        this.taskRepository = taskRepository;
        this.employeeRepository = employeeRepository;
    }


    @Override
    public List<Task> getAllTasks() {
        return null;
    }

    @Override
    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task addTask(TaskDto taskDto, Long id) {
        Task newTask = new Task();
        newTask.setId(taskDto.getId());
        newTask.setDescription(taskDto.getDescription());
        newTask.setStatus(taskDto.getStatus());
        newTask.setEmployee(employeeRepository.findById(id).get());
        return taskRepository.save(newTask);
    }

    @Override
    public void deleteById(Long id) {
       if(taskRepository.findById(id).isPresent()){
           taskRepository.deleteById(id);
       }
    }

    @Override
    public List<Task> getTasks(Long employee_id, Status status) {
        return null;
    }

    @Override
    public List<Task> getTasks(Long employee_id) {
        return null;
    }

    @Override
    public List<Task> getTasks() {
        return null;
    }

    @Override
    public Task updateById(TaskDto taskDto, Long id) {
        if(taskRepository.findById(id).isPresent()) {
            Task newTask = taskRepository.findById(id).get();
            newTask.setDescription(taskDto.getDescription());
            newTask.setStatus(taskDto.getStatus());
            return taskRepository.save(newTask);
        }
        throw new EmployeeNotFoundExeption("TASK not found with id" + id);
    }
}
