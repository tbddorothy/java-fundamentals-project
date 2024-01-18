package org.example.service;

import net.bytebuddy.implementation.bytecode.Throw;
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
    public Employee findById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
    }

    @Override
    public void removeEmployee(Long id){
        if(employeeRepository.findById(id).isPresent()){
            employeeRepository.deleteById(id);
        }else{
            throw new EmployeeNotFoundException("Employee not found with id: " + id);
        }
    }

    @Override
    public Employee updateEmployee(EmployeeDto employeeDto, Long id){
        if(employeeRepository.findById(id).isPresent()){
            Employee employee = new Employee();
            employee.setEmail(employeeDto.getEmail());
            employee.setFirstName(employeeDto.getFirstName());
            employee.setLastName(employeeDto.getLastName());
            employee.setPosition(employeeDto.getPosition());

            return employeeRepository.save(employee);
        }else{
            throw new EmployeeNotFoundException("Employee not found with id: " + id);
        }
    }
}
