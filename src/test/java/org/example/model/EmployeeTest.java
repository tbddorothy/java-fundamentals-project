package org.example.model;

import org.example.model.dto.EmployeeDto;
import org.example.model.entity.Employee;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class EmployeeTest {
    @Test
    public void testEmployee() {
        Employee employee = new Employee(1L, "jon@gmail.com", "John", "Doe", "Designer");

        Assertions.assertEquals(1L, employee.getId());
        Assertions.assertEquals("jon@gmail.com", employee.getEmail());
        Assertions.assertEquals("John", employee.getFirstName());
        Assertions.assertEquals("Doe", employee.getLastName());
        Assertions.assertEquals("Designer", employee.getPosition());
    }

    @Test
    public void EmployeeDtoConstructorTest() {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setFirstName("John");
        Employee employee = new Employee(employeeDto);

        Assertions.assertEquals(employeeDto.getFirstName(), employee.getFirstName());
    }

    @Test
    public void testEmployeeNoArgs() {
        Employee employee = new Employee();
        employee.setFirstName("John");
        employee.setLastName("Doe");
        employee.setEmail("john@gmail.com");
        //Employee employee = new Employee(employeeDto);

        Assertions.assertEquals(employee.getFirstName(), employee.getFirstName());
        Assertions.assertEquals(employee.getLastName(), employee.getLastName());
        Assertions.assertEquals(employee.getEmail(), employee.getEmail());
    }
}
