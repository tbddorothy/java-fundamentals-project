package org.example.model;

import jakarta.validation.constraints.NotNull;
import org.example.model.dto.EmployeeDto;
import org.example.model.entity.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmployeeTest {
    @Test
    public void testEmployeeEntity() {
        Employee employee = new Employee(1L, "jon@mail.com", "John", "Doe", "design");

        Assertions.assertEquals(1L, employee.getId());
        Assertions.assertEquals("jon@mail.com", employee.getEmail());
        Assertions.assertEquals("John", employee.getFirstName());
        Assertions.assertEquals("Doe", employee.getLastName());
        Assertions.assertEquals("design", employee.getPosition());
    }
    @Test
    public void EmployeeDtoConstructorTest(){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setFirstName("John");

        Employee employee = new Employee(employeeDto);
        Assertions.assertEquals(employeeDto.getFirstName(),employee.getFirstName());
    }
    @Test
    public void EmployeeNoArgsConstructorTest(){
        Employee employee = new Employee();
        employee.setFirstName("John");
        Assertions.assertEquals("John", employee.getFirstName());
    }

}
