package org.example.service;

import org.example.model.entity.Employee;
import org.example.repository.EmployeeRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Collections;
import java.util.List;

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
    public void getAllEmployeesTest() {
        List<Employee> exceptedEmployees = Collections.singletonList(new Employee(0L, "jon@gmail.com","John", "Doe", "Designer"));

        when(employeeRepository.findAll()).thenReturn(exceptedEmployees);

        List<Employee> resultEmployees = employeeService.getAllEmployees();
        Assertions.assertEquals(exceptedEmployees, resultEmployees);

    }

    @Test
    public void addEmployeeTest() {
        Employee employee = new Employee();
        when(employeeRepository.save(employee)).thenReturn(employee);
        Employee newEmployee = employeeService.addEmployee(employee);
        Assertions.assertEquals(employee, newEmployee);
    }

    @Test
    public void deleteEmployeeTest() {
        Employee employee = new Employee();
        employee.setId(1L);

        employeeRepository.deleteById(employee.getId());

        verify(employeeRepository).deleteById(employee.getId());
    }

//    @Test
//    public void updateEmployeeTest() {
//        Employee employee = new Employee();
//        when(employeeRepository.save(employee)).thenReturn(employee);
//        Employee newEmployee = employeeService.addEmployee(employee);
//        Assertions.assertEquals(employee, newEmployee);
//    }
}
