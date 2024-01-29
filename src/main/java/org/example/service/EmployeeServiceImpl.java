package org.example.service;

import org.example.exception.EmployeeNotFoundException;
import org.example.model.dto.EmployeeDto;
import org.example.model.entity.Employee;
import org.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }


    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee addEmployee(EmployeeDto employeeDto) {
        return employeeRepository.save(new Employee(employeeDto));
    }

    @Override
    public Employee findById(long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id :" + id));
    }

    @Override
    public Boolean deleteById(long id) {
        try {
            this.employeeRepository.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    @Override
    public Employee updateEmployee(long id, Employee employee) {
        try {
            Employee employeeFound = this.findById(id);
            employeeFound = employee;
            this.employeeRepository.save(employeeFound);
            return employee;
        }
        catch (EmployeeNotFoundException ex){
            return null;
        }
    }
}
