package org.example.model;

import org.example.model.dto.EmployeeDto;
import org.example.model.entity.Employee;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class EmployeeTest {

    @Test
    public void testEmployeeEntity(){
        Employee employee = new Employee(1L,"jon@email.com", "John","Doe","Designer");

        Assertions.assertEquals(1L, employee.getId());
        Assertions.assertEquals("jon@email.com", employee.getEmail());
        Assertions.assertEquals("John", employee.getFirstName());
        Assertions.assertEquals("Doe", employee.getLastName());
        Assertions.assertEquals("Designer", employee.getPosition());
    }

    @Test
    public void employeeDtoConstructorTest(){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setFirstName("John");
        Employee employee = new Employee(employeeDto);

        Assertions.assertEquals(employeeDto.getFirstName(), employee.getFirstName());
    }

    @Test
    public void noArgsConstructorTest(){
        Employee employee = new Employee();
        employee.setEmail("email@here");
        employee.setFirstName("John");
        employee.setLastName("Doe");
        employee.setPosition("Developer");

        Assertions.assertEquals("email@here", employee.getEmail());
        Assertions.assertEquals("John", employee.getFirstName());
        Assertions.assertEquals("Doe", employee.getLastName());
        Assertions.assertEquals("Developer", employee.getPosition());

    }

}
