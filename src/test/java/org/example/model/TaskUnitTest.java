package org.example.model;

import org.example.model.dto.TaskDto;
import org.example.model.entity.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskUnitTest {

    @Test
    public void TaskEntityTest() {
        TaskDto taskDto = new TaskDto();

        taskDto.setDescription("Work hard play hard");
        Task task = new Task(taskDto);


        Assertions.assertEquals(task.getDescription(), taskDto.getDescription());
    }
}
