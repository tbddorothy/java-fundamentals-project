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

import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
    public void getAllEmployeeTest(){
        List<Employee> expectedEmployees = Collections.singletonList(
                new Employee(0L, "guy@gmail.com", "Guy", "Fieri", "Developer")
        );

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
    public void findByIdTest(){
        Employee employee = new Employee(0L, "guy@gmail.com", "Guy", "Fieri", "Developer");

        when(employeeRepository.findById(employee.getId())).thenReturn(Optional.of(employee));

        Employee resultEmployee = employeeService.findById(employee.getId());

        Assert.assertEquals(employee, resultEmployee);
    }

    @Test
    public void removeEmployeeTest() {
        Employee employee = new Employee(0L, "guy@gmail.com", "Guy", "Fieri", "Developer");

        employeeRepository.deleteById(employee.getId());

        verify(employeeRepository).deleteById(employee.getId());
    }
}
