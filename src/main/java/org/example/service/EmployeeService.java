package org.example.service;

import org.example.model.dto.EmployeeDto;
import org.example.model.entity.Employee;
import org.example.model.entity.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee addEmployee(Employee employee);

    Employee addEmployee(EmployeeDto employeeDto);
    Employee updateEmployee(Employee employee);
    void removeEmployee(Long id);
    Employee findById(Long id);

    //List<Task> getTasksByEmployeeId(Long employee_id);

}
