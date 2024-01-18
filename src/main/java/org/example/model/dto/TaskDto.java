package org.example.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.enums.Status;
import org.example.model.entity.Employee;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TaskDto {
    private String description;

    private Long employeeId;

    private Status status;
}
