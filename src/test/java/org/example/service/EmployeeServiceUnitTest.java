package org.example.service;

import org.example.model.entity.Employee;
import org.example.repository.EmployeeRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class EmployeeServiceUnitTest {
    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Test
    public void getAllEmployeesTest() {
        List<Employee> expectedEmployees = Collections.singletonList(new Employee(1L, "myboy@yeahyeah.com", "My", "Boy", "Son"));

        Employee employee = new Employee();

        List<Employee> otherList = new ArrayList<>();
        otherList.add(employee);

        when(employeeRepository.findAll()).thenReturn(expectedEmployees);

        List<Employee> resultingEmployees = employeeService.getAllEmployees();
        Assert.assertEquals(expectedEmployees, resultingEmployees);
    }
    @Test
    public void addEmployeeTest() {

        Employee warren = new Employee(1L, "w@b.com", "warren", "buffett", "investor");

        when(employeeRepository.save(warren)).thenReturn(warren);

        Employee resultingEmployees = employeeService.addEmployee(warren);

        Assert.assertEquals(warren, resultingEmployees);
    }

    @Test
    public void removeEmployeeTest() {
        Employee warren = new Employee(1L, "w@b.com", "warren", "buffett", "investor");

        employeeRepository.deleteById(warren.getId());

        verify(employeeRepository, times(1)).deleteById(warren.getId());
    }


}
