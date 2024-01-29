package org.example.model;
import org.example.model.dto.EmployeeDto;
import org.junit.jupiter.api.Assertions;

import org.example.model.entity.Employee;
import org.junit.jupiter.api.Test;

public class EmployeeTest {

    @Test
    public void EmployeeEntityTest() {
        Employee employee = new Employee(1L, "rorisang@a.com", "Rorisang", "Serapelo", "Founder");

        Assertions.assertEquals(1L, employee.getId());
        Assertions.assertEquals("rorisang@a.com", employee.getEmail());
        Assertions.assertEquals("Rorisang", employee.getFirstName());
        Assertions.assertEquals("Serapelo", employee.getLastName());
        Assertions.assertEquals("Founder", employee.getPosition());
    }

    @Test
    public void EmployeeDtoConstructorTest() {
        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setFirstName("Warren");
        Employee employee = new Employee(employeeDto);

        Assertions.assertEquals(employee.getFirstName(), employeeDto.getFirstName());

    }

    @Test
    public void EmployeeDtoConstructorNoArgsTest() {
        Employee employee = new Employee();
        employee.setFirstName("Charles");
        employee.setLastName("Munger");
        employee.setPosition("Investor");

        Assertions.assertEquals("Charles", employee.getFirstName());
    }


}
