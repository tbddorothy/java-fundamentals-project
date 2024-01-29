package org.example.model;
import org.example.enums.Status;
import org.example.model.dto.TaskDto;
import org.example.model.entity.Employee;
import org.example.model.entity.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Date;

public class TaskTest {
    @Test
    public void TaskEmptyConstructor (){
        Task task = new Task();
        Assertions.assertNull(task.getDescription());
    }

    @Test
    public void TaskDtoContractorTest(){
        String TestDescription = "Hello World";
        TaskDto taskDto = new TaskDto();
        taskDto.setDescription(TestDescription);
        taskDto.setDate(new Date());
        Task task = new Task(taskDto);
        Assertions.assertEquals(TestDescription,task.getDescription());
    }
    @Test
    public void TaskConstructorTest (){
        String TestDescription = "Hello World";
        Task task = new Task();
        task.setDescription(TestDescription);
        Assertions.assertEquals(TestDescription,task.getDescription());
    }
    @Test
    public void TaskAddEmployeeTest (){
        String TestFirstName = "Tyronne";
        Task task = new Task();
        Employee employee = new Employee();
        task.setStatus(Status.NEW);
        employee.setFirstName(TestFirstName);
        task.setEmployee(employee);
        Assertions.assertEquals(employee,task.getEmployee());
        Assertions.assertEquals(TestFirstName,task.getEmployee().getFirstName());
    }
}
