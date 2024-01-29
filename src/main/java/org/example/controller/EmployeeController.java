package org.example.controller;

import org.example.exception.EmployeeNotFound;
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

    @PostMapping("/addEmployee")
    public ResponseEntity<?> addEmployee(@RequestBody EmployeeDto employeeDto) {
        Employee savedEmployee = employeeService.addEmployee(employeeDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        try {
            Employee employee = employeeService.findById(id);
            return ResponseEntity.ok(employee);
        } catch (EmployeeNotFound ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<Employee> deleteEmployeeById(@PathVariable Long id) {
        try {
            Employee employee = employeeService.findById(id);
            if (employee != null) {
                employeeService.deleteEmployee(id);
            }
            return ResponseEntity.ok(employee);
        } catch (EmployeeNotFound ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeedto) {
        try {
            Employee employee = employeeService.findById(id);
            if (employee != null) {
                employee.setFirstName(employeedto.getFirstName());
                employee.setLastName(employeedto.getLastName());
                employee.setEmail(employeedto.getEmail());
                employee.setPosition(employeedto.getPosition());
                employeeService.upateEmployee(employee);
            }
            return ResponseEntity.ok(employee);
        } catch (EmployeeNotFound ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
