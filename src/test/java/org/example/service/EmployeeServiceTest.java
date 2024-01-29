package org.example.service;

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
import org.springframework.context.annotation.ComponentScan;
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
    public void getAllEmployeesTest()
    {
        List<Employee> expectedEmployees = Collections.singletonList(new Employee(1L, "jon@mail.com", "John", "Doe", "Designer"));
                when (employeeRepository.findAll()).thenReturn(expectedEmployees);

        List<Employee> resultEmployees = employeeService.getAllEmployees();

        Assert.assertEquals(expectedEmployees,resultEmployees);
    }

    @Test
    public void addEmployeeTest()
    {
        Employee expectedEmployee = new Employee(2L, "jon@mail.com", "John", "Doe", "Designer");
            when(employeeRepository.save(expectedEmployee)).thenReturn(expectedEmployee);

        Employee newEmployee = employeeService.addEmployee(expectedEmployee);
        employeeRepository.save(newEmployee);

        Assert.assertEquals(expectedEmployee, newEmployee);
    }

    @Test
    public void findByIdTest()
    {
        Employee expectedEmployee = new Employee(3L, "jon@mail.com", "John", "Doe", "Designer");
            when(employeeRepository.findById(expectedEmployee.getId())).thenReturn(Optional.of(expectedEmployee));

        Employee newEmployee = employeeService.findById(expectedEmployee.getId());

        Assert.assertEquals(expectedEmployee, newEmployee);
    }

    @Test
    public void deleteEmployeeTest()
    {
        Employee employee = new Employee(3L, "jon@mail.com", "John", "Doe", "Designer");

        employeeRepository.deleteById(employee.getId());

        verify(employeeRepository).deleteById(employee.getId());
    }

    /*
    @Test
    public void updateEmployeeTest()
    {
        Employee employee = new Employee(3L, "jon@mail.com", "John", "Doe", "Designer");
    }

     */
}
