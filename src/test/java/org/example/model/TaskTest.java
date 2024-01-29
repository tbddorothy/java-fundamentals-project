package org.example.model;

import org.example.enums.Status;
import org.example.model.entity.Employee;
import org.example.model.entity.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {
    @Test
    public void testTaskEntity() {
        Employee employee = new Employee(1L, "jon@mail.com", "John", "Doe", "design");
        Task task = new Task(1L,"description",employee, Status.NEW);

        Assertions.assertEquals(1L, task.getId());
        Assertions.assertEquals("description", task.getDescription());
        Assertions.assertEquals(employee,task.getEmployee());
        Assertions.assertEquals(Status.NEW,task.getStatus());
    }
    @Test
    public void TaskNoArgsConstructorTest() {
        Task task = new Task();
        task.setDescription("hello desc");
        Assertions.assertEquals("hello desc", task.getDescription());
    }
}
