package org.example.model;

import org.example.enums.Status;
import org.example.model.dto.TaskDto;
import org.example.model.entity.Employee;
import org.example.model.entity.Task;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TaskTest {
    @Test
    public void testTask() {
        Employee employee = new Employee(1L, "jon@gmail.com", "John", "Doe", "Designer");
        Task task = new Task(1L, "Reply emails", Status.NEW, employee);
        Assertions.assertEquals(1L, task.getId());
        Assertions.assertEquals("Reply emails", task.getDescription());
        Assertions.assertEquals("NEW", task.getStatus());
        Assertions.assertEquals(1L, employee.getId());
    }

    @Test
    public void TaskDtoConstructorTest() {
        TaskDto taskDto = new TaskDto();
        taskDto.setDescription("Reply emails");
        Task task = new Task(taskDto);

        Assertions.assertEquals(taskDto.getDescription(), task.getDescription());
    }
}
