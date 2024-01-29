package org.example.controller;

import org.example.exception.EmployeeNotFoundException;
import org.example.exception.TaskNotFoundException;
import org.example.model.dto.EmployeeDto;
import org.example.model.entity.Employee;
import org.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("")
    public ResponseEntity<?> addEmployee(@RequestBody EmployeeDto employeeDto) {
        Employee savedEmployee = employeeService.addEmployee(employeeDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        try {
            Employee employee = employeeService.findById(id);
            return ResponseEntity.ok(employee);
        }
        catch(EmployeeNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
        try {
            employeeService.deleteEmployee(id);
            return ResponseEntity.ok("Successfully deleted");
        }
        catch(TaskNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        try {
            Employee updateEmployee = employeeService.updateEmployee(employee);
            return ResponseEntity.ok(employee);

        }
        catch(EmployeeNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
