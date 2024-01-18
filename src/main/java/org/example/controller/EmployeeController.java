package org.example.controller;

import org.example.exception.EmployeeNotFoundExeption;
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

    @PostMapping("/add")
    public ResponseEntity<?> addEmployee(@RequestBody EmployeeDto employeeDto ) {
        Employee savedEmployee = employeeService.addEmployee(employeeDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
    }
    @PostMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        try{
            Employee employee = employeeService.findById(id);
            return ResponseEntity.ok(employee);
        }catch(EmployeeNotFoundExeption ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    @DeleteMapping ("/remove/{id}")
    public  ResponseEntity<Employee> removeEmployeeById(@PathVariable Long id) {

        employeeService.removeById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateEmployeeById(@RequestBody EmployeeDto employeeDto ,@PathVariable Long id){
        Employee updatedEmployee = employeeService.updateById(employeeDto, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(updatedEmployee);
    }

}
