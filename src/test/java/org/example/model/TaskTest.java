package org.example.model;

import lombok.var;
import org.example.enums.Status;
import org.example.model.dto.EmployeeDto;
import org.example.model.dto.TaskDto;
import org.example.model.entity.Employee;
import org.example.model.entity.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class TaskTest {
    @Test
    public void testTaskEntity()
    {
        Employee employee = new Employee(1L, "jon@mail.com", "John", "Doe", "Designer");
        var date = new Date();

        Task newTask = new Task(1L,"Philosophy",date,employee, Status.NEW);

        Assertions.assertEquals(1L, newTask.getId());
        Assertions.assertEquals("Philosophy", newTask.getDescription());
        Assertions.assertEquals(date, newTask.getCompletion());
        Assertions.assertEquals(employee, newTask.getEmployee());
        Assertions.assertEquals(Status.NEW, newTask.getStatus());
    }

    @Test
    public void TaskNoArgsConstructorTest()
    {
        Task newTask = new Task();
        newTask.setDescription("History");

        Assertions.assertEquals("History", newTask.getDescription());
    }

    /*
    @Test
    public  void TaskDtoConstructerTest()
    {
        TaskDto dto = new TaskDto();
        dto.setDescription("History");
        Task newTask = new Task(dto);
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
    */
}
