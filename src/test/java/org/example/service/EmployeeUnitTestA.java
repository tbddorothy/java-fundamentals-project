package org.example.service;
import org.example.model.entity.Employee;
import org.example.repository.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
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

import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class EmployeeUnitTestA {

    @Mock
    private EmployeeRepository employeeRepository;
    @InjectMocks
    EmployeeServiceImpl employeeService;

    @org.junit.Test
    public void name() {
        Employee EmployeeA = new Employee();
        EmployeeA.setFirstName("Tyronne");
        EmployeeA.setId(0l);
        EmployeeA.setEmail("tyronnegaud0@gmail.com");
        EmployeeA.setLastName("Tyronne");

        List<Employee> OtherList = new ArrayList<>();
        OtherList.add(EmployeeA);
        List<Employee> ExpectedEmployees = Collections.singletonList(
                EmployeeA
        );
        when(this.employeeService.getAllEmployees()).thenReturn(Collections.singletonList(EmployeeA));

        this.employeeRepository.save(EmployeeA);
        List<Employee> ResultEmployees = employeeService.getAllEmployees();

        Assertions.assertEquals(ExpectedEmployees,ResultEmployees);
    }
    @Test
    public void DeleteEmployeeTest(){
        Employee employee = new Employee();
        employee.setId(1L);
        employeeRepository.deleteById(employee.getId());
    }
}
