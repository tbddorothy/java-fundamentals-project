package org.example.model;
import org.example.model.dto.EmployeeDto;
import org.example.model.entity.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class EmployeeUnitTest {
    @Test
    public void testEmployeeEntity(){
        Employee employee = new Employee(1L,"jon@mail.com","John","Doe","Designer");
        Assertions.assertEquals(1L, employee.getId());
        Assertions.assertEquals("jon@mail.com", employee.getEmail());
        Assertions.assertEquals("John", employee.getFirstName());
        Assertions.assertEquals("Doe", employee.getLastName());
        Assertions.assertEquals("Designer", employee.getPosition());
    }
    @Test
    public void testEmployeeDtoConstructorTest(){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("test@gmail.com");
        Employee employee = new Employee(employeeDto);
        Assertions.assertEquals(employeeDto.getEmail(), employee.getEmail());
    }
    @Test
    public void testEmployeeNoConstructorTest(){
        String TestName = "Tyronne";
        Employee employee = new Employee();
        employee.setFirstName((TestName));
        Assertions.assertEquals(TestName, employee.getFirstName());
        Assertions.assertNull(employee.getPosition());
    }
}

