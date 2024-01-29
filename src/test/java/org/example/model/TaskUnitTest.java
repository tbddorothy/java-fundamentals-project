package org.example.model;

import org.example.enums.Status;
import org.example.model.entity.Employee;
import org.example.model.entity.Task;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TaskUnitTest {

    @Test
    public void testTaskModel(){
        Employee employee = new Employee(1L, "jon@gmail.com", "John", "Doe", "CEO");
        Task task = new Task(2L, "Test Description", employee, Status.NEW);

        assertEquals(2L, task.getId());
        assertEquals("Test Description", task.getDescription());
        assertEquals(employee, task.getEmployee());
        assertEquals("NEW", task.getStatus().getLabel().toUpperCase());
    }
}
