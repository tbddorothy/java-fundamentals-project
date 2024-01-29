package org.example.model;

import org.example.enums.Status;
import org.example.model.entity.Employee;
import org.example.model.entity.Task;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class TaskTest {

    @Test
    public void testTaskEntity(){
        Employee employee = new Employee();
        Task task = new Task();
        task.setId(1L);
        task.setDescription("Description");
        task.setEmployee(employee);
        task.setStatus(Status.NEW);

        Assertions.assertEquals(1L, task.getId());
        Assertions.assertEquals("Description", task.getDescription());
        Assertions.assertEquals(employee, task.getEmployee());
        Assertions.assertEquals(Status.NEW, task.getStatus());
    }

}
