package org.example.model;

import org.example.enums.Status;
import org.example.model.entity.Employee;
import org.example.model.entity.Task;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TaskUnitTest {

    @Test
    public void TestTaskEntity(){
        Employee employee = new Employee();
        Task task = new Task();
        task.setStatus(Status.NEW);
        task.setDescription("Yes");
        task.setId(1L);
        task.setEmployee(employee);

        Assertions.assertEquals(1L , task.getId());
        Assertions.assertEquals("Yes" , task.getDescription());
        Assertions.assertEquals(Status.NEW , task.getStatus());
        Assertions.assertEquals(employee, task.getEmployee());


    }
    @Test
    public void NoArgsConstructorTest(){
        Employee employee = new Employee();
        Task task = new Task();
        task.setId(1L);
        task.setDescription("Yes");
        task.setStatus(Status.NEW);
        task.setEmployee(employee);

        Assertions.assertEquals(1L , task.getId());
        Assertions.assertEquals("Yes" , task.getDescription());
        Assertions.assertEquals(Status.NEW , task.getStatus());
        Assertions.assertEquals(employee, task.getEmployee());
    }
}
