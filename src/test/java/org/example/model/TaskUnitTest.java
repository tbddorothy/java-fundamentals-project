package org.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.example.enums.Status;
import org.example.model.entity.Employee;
import org.example.model.entity.Task;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskUnitTest {
    @Test
    public void TestEnumValues(){
        Employee employee = new Employee();
        Task task = new Task();

        task.setId(1L);
        task.setDescription("Le Test");
        task.setEmployee(employee);
        task.setStatus(Status.ACTIVE);

        Assertions.assertEquals(1L, task.getId());
        Assertions.assertEquals("Le Test", task.getDescription());
        assertEquals(employee, task.getEmployee());
        assertEquals(Status.ACTIVE, task.getStatus());
    }
}

