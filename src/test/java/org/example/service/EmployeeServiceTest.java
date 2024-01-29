package org.example.service;


import jakarta.annotation.security.RunAs;
import org.example.model.entity.Employee;
import org.example.repository.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class EmployeeServiceTest {
    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Test
    public void getAllEmployeesTest(){
        List<Employee> expectedEmployees = Collections.singletonList(new Employee(1L, "jon@mail.com", "John", "Doe", "design"));
        when(employeeRepository.findAll()).thenReturn(expectedEmployees);

        List<Employee> resultEmployee = employeeService.getAllEmployees();
        Assertions.assertEquals(expectedEmployees,resultEmployee);
    }
    @Test
    public void addEmployeesTest() {
        Employee expectedEmployees = new Employee(1L, "jon@mail.com", "John", "Doe", "design");
        when(employeeRepository.save(expectedEmployees)).thenReturn(expectedEmployees);

        Employee resultEmployee = employeeService.addEmployee(expectedEmployees);
        Assertions.assertEquals(expectedEmployees, resultEmployee);
    }

    @Test
    public void delEmployeesTest() {

        Employee expectedemployee = new Employee();
        expectedemployee.setId(1L);
        employeeRepository.deleteById(expectedemployee.getId());

        verify(employeeRepository).deleteById(expectedemployee.getId());
    }
    @Test
    public void findEmployeesTest() {

        Employee expectedemployee = new Employee(1L, "jon@mail.com", "John", "Doe", "design");
        when(employeeRepository.findById(expectedemployee.getId())).thenReturn(Optional.of(expectedemployee));

        Employee resultEmployee = employeeService.findById(expectedemployee.getId());
        Assertions.assertEquals(expectedemployee, resultEmployee);
    }
//    @Test
//    public void updateEmployeeTest(){
//        Employee expectedemployee = new Employee(1L, "jon@mail.com", "John", "Doe", "design");
//
//        when(employeeRepository.findById());
//    }
}
