package org.example.service;

import org.example.model.dto.EmployeeDto;
import org.example.model.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee addEmployee(Employee employee);

    Employee addEmployee(EmployeeDto employeeDto);

    public Employee upateEmployee(Employee employeeDto);

    void deleteEmployee(Long id);

    Employee findById(Long id);
}
