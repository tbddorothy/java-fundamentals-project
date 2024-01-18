package org.example.controller;

import org.example.exception.EmployeeNotFoundException;
import org.example.model.dto.EmployeeDto;
import org.example.model.entity.Employee;
import org.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.support.NullValue;
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

    @DeleteMapping("delete/{id}")
    public  ResponseEntity<Boolean> deleteEmployeeById(@PathVariable long id){
        try {
            this.employeeService.findById(id);
        }
        catch (EmployeeNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(this.employeeService.deleteById(id));
    }

    @PostMapping("update/{id}")
    public  ResponseEntity<Employee> updateEmployeeById(@PathVariable long id, EmployeeDto employeeDto){
        try {
            return ResponseEntity.ok(this.employeeService.updateEmployee(id,new Employee(employeeDto)));
        }
        catch (EmployeeNotFoundException x){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
        try {
            Employee employee = this.employeeService.findById(id);
            return ResponseEntity.ok(employee);
        } catch (EmployeeNotFoundException exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
