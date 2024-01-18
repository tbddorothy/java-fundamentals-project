package org.example.controller;

import org.example.Exception.EmployeeNotFoundException;
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

    @GetMapping("/getEmployee")
    public List<Employee> getEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        try {
            Employee employee= employeeService.findById(id);
            return  ResponseEntity.ok(employee);
        }catch (EmployeeNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    @PostMapping("/addEmployee")
    public ResponseEntity<?> addEmployee(@RequestBody EmployeeDto employeeDto) {
        Employee savedEmployee = employeeService.addEmployee(employeeDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
    }

    @DeleteMapping("deleteEmployee/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
        try {
            Employee employee= employeeService.findById(id);
            employeeService.deleteEmployee(id);
            return  ResponseEntity.ok(employee);
        } catch (Exception ex)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    @PutMapping("updateEmployee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id ,@RequestBody EmployeeDto employeeDto) {
        try {
            Employee employee = employeeService.findById(id);
            if(employee!= null)
            {
                employee.setFirstName(employeeDto.getFirstName());
                employee.setLastName(employeeDto.getLastName());
                employee.setLastName(employeeDto.getEmail());
                employee.setPosition(employeeDto.getPosition());
                employeeService.updateEmployee(employee);
            }
            return ResponseEntity.ok(employee);
            } catch (Exception ex) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
    }
}
