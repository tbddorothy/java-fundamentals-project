package org.example.service;

import jakarta.persistence.Entity;
import org.example.enums.Status;
import org.example.model.entity.Employee;
import org.example.repository.EmployeeRepository;
import org.hibernate.annotations.Source;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collection;
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
        List<Employee> expectedEmployees = Collections.singletonList(new Employee(0L, "guy@mail.com", "Guy", "Guy", "ceo"));
        Employee employee = new Employee();
        List<Employee> otherList = new ArrayList<>();
        otherList.add(employee);

        when(employeeRepository.findAll()).thenReturn(expectedEmployees);

        List<Employee> resultEmployees = employeeService.getAllEmployees();
        Assert.assertEquals(expectedEmployees, resultEmployees);
    }

    @Test
    public void addEmployeeTest(){
        Employee employee = new Employee(0L, "guy@gmail.com", "Guy", "Fieri", "Developer");
        when(employeeRepository.save(employee)).thenReturn(employee);

        Employee savedEmployee = employeeService.addEmployee(employee);
        Assert.assertEquals(employee, savedEmployee);
    }

    @Test
    public void deleteEmployeeTest(){
        Employee employee = new Employee();
        employee.setId(1L);
        employeeRepository.deleteById(employee.getId());
        verify(employeeRepository).deleteById(employee.getId());
    }

    @Test
    public void findByIdEmployeeTest(){
        Employee employee = new Employee(0L, "guy@gmail.com", "Guy", "Fieri", "Developer");
    }


}
