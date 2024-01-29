package org.example.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.enums.Status;
import org.example.model.entity.Employee;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class TaskDto {

    private Employee employee;

    private String description;

    private Status status;

    private Date date;

    public TaskDto(Employee employee, TaskDtoWithoutEmployee taskDtoWithoutEmployee) {
        this.employee = employee;
        this.description = taskDtoWithoutEmployee.getDescription();
        this.status = taskDtoWithoutEmployee.getStatus();
        this.date = taskDtoWithoutEmployee.getDate();
    }
}
