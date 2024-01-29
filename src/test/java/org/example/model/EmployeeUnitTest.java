package org.example.model;

import org.example.model.dto.EmployeeDto;
import org.example.model.entity.Employee;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class EmployeeUnitTest {

    @Test
    public void TestEmployeeEntity(){
        Employee employee = new Employee(1L, "jon@mail.com", "john", "Doe","ceo");

           Assertions.assertEquals(1L , employee.getId());
           Assertions.assertEquals("jon@mail.com" , employee.getEmail());
           Assertions.assertEquals("john" , employee.getFirstName());
           Assertions.assertEquals("Doe" , employee.getLastName());
           Assertions.assertEquals("ceo" , employee.getPosition());

    }
    @Test
    public void EmployeeDtoConstructorTest(){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setFirstName("John");
        employeeDto.setEmail("jon@mail.com");
        employeeDto.setPosition("ceo");
        employeeDto.setLastName("Doe");
        Employee employee = new Employee(employeeDto);

        Assertions.assertEquals(employeeDto.getFirstName(),employee.getFirstName());
        Assertions.assertEquals(employeeDto.getLastName(),employee.getLastName());
        Assertions.assertEquals(employeeDto.getPosition(),employee.getPosition());
        Assertions.assertEquals(employeeDto.getEmail(),employee.getEmail());
    }

    @Test
    public void NoArgsConstructorTest(){
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setFirstName("john");
        employee.setLastName("Doe");
        employee.setPosition("ceo");
        employee.setEmail("jon@mail.com");

        Assertions.assertEquals(1L , employee.getId());
        Assertions.assertEquals("jon@mail.com" , employee.getEmail());
        Assertions.assertEquals("john" , employee.getFirstName());
        Assertions.assertEquals("Doe" , employee.getLastName());
        Assertions.assertEquals("ceo" , employee.getPosition());

    }
}
