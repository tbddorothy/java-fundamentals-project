package org.example.service;

import org.example.model.dto.EmployeeDto;
import org.example.model.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee addEmployee(Employee employee);

    Employee addEmployee(EmployeeDto employeeDto);

    public Employee findById(Long id);

    public void removeEmployee(Long id);

    public Employee updateEmployee(EmployeeDto employeeDto, Long id);
}
