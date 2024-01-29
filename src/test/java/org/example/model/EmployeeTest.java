package org.example.model;
import org.example.model.dto.EmployeeDto;
import org.example.model.entity.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmployeeTest {
    @Test
    public void testEmployeeEntity()
    {
        Employee employee = new Employee(1L, "jon@mail.com", "John", "Doe", "Designer");

        Assertions.assertEquals(1L, employee.getId());
        Assertions.assertEquals("jon@mail.com", employee.getEmail());
        Assertions.assertEquals("John", employee.getFirstName());
        Assertions.assertEquals("Doe", employee.getLastName());
        Assertions.assertEquals("Designer", employee.getPosition());
    }

    @Test
    public void EmployeeDtoConstructorTest()
    {
        EmployeeDto dto = new EmployeeDto();
        dto.setFirstName("John");
        Employee employee = new Employee(dto);

        Assertions.assertEquals(dto.getFirstName(), employee.getFirstName());
    }

    @Test
    public void EmployeeNoArgsConstructorTest()
    {
        Employee newEmployee = new Employee();
        newEmployee.setFirstName("Joe");

        Assertions.assertEquals("Joe", newEmployee.getFirstName());
    }
}
