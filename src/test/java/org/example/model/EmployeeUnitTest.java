package org.example.model;

import org.example.model.dto.EmployeeDto;
import org.example.model.entity.Employee;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class EmployeeUnitTest {
    @Test
    public void testEmployeeEntity(){
        Employee employee = new Employee(1L, "John", "Doe", "jon@email.com", "Developer");

        Assertions.assertEquals(1L, employee.getId());
        Assertions.assertEquals("John", employee.getFirstName());
        Assertions.assertEquals("Doe", employee.getLastName());
        Assertions.assertEquals("jon@email.com", employee.getEmail());
        Assertions.assertEquals("Developer", employee.getPosition());
    }

    @Test
    public void EmployeeConstructorTest(){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setFirstName("John");

        Employee employee = new Employee(employeeDto);

        Assertions.assertEquals(employeeDto.getFirstName(), employee.getFirstName());
    }

    @Test
    public void NoArgsConstructure(){
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setFirstName("John");
        employee.setLastName("Doe");
        employee.setEmail("jon@email.com");
        employee.setPosition("Developer");

        Assertions.assertEquals(1L, employee.getId());
        Assertions.assertEquals("John", employee.getFirstName());
        Assertions.assertEquals("Doe", employee.getLastName());
        Assertions.assertEquals("jon@email.com", employee.getEmail());
        Assertions.assertEquals("Developer", employee.getPosition());
    }
}
