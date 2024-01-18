package org.example.service;

import org.example.model.dto.EmployeeDto;
import org.example.model.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee updateEmployee(Employee employee);

    void deleteEmployee(Long id);

    Employee addEmployee(Employee employee);

    Employee addEmployee(EmployeeDto employeeDto);

    Employee findById(Long id);

}
