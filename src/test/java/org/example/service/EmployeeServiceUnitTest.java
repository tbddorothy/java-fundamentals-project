package org.example.service;

import org.example.model.dto.EmployeeDto;
import org.example.model.entity.Employee;
import org.example.repository.EmployeeRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class EmployeeServiceUnitTest {
    @Mock
    private EmployeeRepository employeeRepository;
    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Test
    public void getAllEmployeesTest(){
        List<Employee>expectedEmployees = Collections.singletonList(new Employee(0L, "guy@mail.com", "Guy", "Guy", "ceo"));
        Employee employee= new Employee();
        List<Employee> otherList = new ArrayList<>();
        otherList.add(employee);

        when(employeeRepository.findAll()).thenReturn(expectedEmployees);

        List<Employee> resultEmployees = employeeService.getAllEmployees();

        Assert.assertEquals(expectedEmployees, resultEmployees);
    }
    @Test
    public void addEmployeeTest(){
        Employee employee = new Employee(0L, "guy@mail.com", "Guy", "Guy", "ceo");

        when(employeeRepository.save(employee)).thenReturn(employee);

        Employee newEmployee = employeeService.addEmployee(employee);
        Assert.assertEquals(employee, newEmployee);
    }
    @Test
    public void deleteEmployeeTest(){
        Employee employee = new Employee();
        employee.setId(0L);

        employeeRepository.deleteById(employee.getId());

        verify(employeeRepository).deleteById(employee.getId());
    }
}
