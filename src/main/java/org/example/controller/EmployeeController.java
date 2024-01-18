package org.example.controller;

import org.example.exception.EmployeeNotFoundException;
import org.example.model.dto.EmployeeDto;
import org.example.model.entity.Employee;
import org.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.*;

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
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
        try{
            Employee employee = employeeService.findById(id);
            return ResponseEntity.ok(employee);
        }catch(EmployeeNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<?> removeEmployee(@PathVariable long id){
        try{
            employeeService.removeEmployee(id);
            return ResponseEntity.ok("Employee Deleted");
        }catch(Exception ex){
            return ResponseEntity.ok(ex);
        }

    }

    @PostMapping("/updateEmployee/{id}")
    public ResponseEntity<?> updateEmployee(@RequestBody EmployeeDto employeeDto, @PathVariable Long id){
        try{
            employeeService.updateEmployee(employeeDto, id);
            return ResponseEntity.ok("Employee updated");
        }catch(Exception ex) {
            return ResponseEntity.ok(ex);
        }
    }
}
