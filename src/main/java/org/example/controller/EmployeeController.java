package org.example.controller;

import org.example.exception.EmployeeNotFoundException;
import org.example.model.dto.EmployeeDto;
import org.example.model.entity.Employee;
import org.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/add")
    public ResponseEntity<?> addEmployee(@RequestBody EmployeeDto employeeDto) {
        Employee savedEmployee = employeeService.addEmployee(employeeDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable Long id) {

        try {
            Employee employee = employeeService.findById(id);
            employeeService.deleteEmployeeById(id);
            return ResponseEntity.ok(employee);
        } catch(EmployeeNotFoundException ex){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEmployeeById(@PathVariable Long id, @RequestBody EmployeeDto employeeDto) {
        try {
            Employee employee = employeeService.findById(id);
            employeeService.updateEmployeeById(id, employeeDto);
            return ResponseEntity.ok(employee);
        } catch(EmployeeNotFoundException ex){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<Employee> GetEmployeeById(@PathVariable Long id){
        try {
            Employee employee = employeeService.findById(id);
            return ResponseEntity.ok(employee);
        } catch(EmployeeNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
