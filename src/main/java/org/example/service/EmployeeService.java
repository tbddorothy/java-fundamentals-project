package org.example.service;

import org.example.model.dto.EmployeeDto;
import org.example.model.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee addEmployee(Employee employee);

    Employee addEmployee(EmployeeDto employeeDto);

    Employee findById(long id);
    Boolean deleteById(long id);

    Employee updateEmployee(long id, Employee employee);
}
