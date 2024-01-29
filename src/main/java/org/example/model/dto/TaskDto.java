package org.example.model.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.enums.Status;
import org.example.model.entity.Employee;

@Setter
@Getter
@AllArgsConstructor
public class TaskDto {

    public TaskDto() {
    }
    private Long id;

    private String description;

    private Long employeeId;

    private Status status;
}
