package org.example.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.enums.Status;
import org.example.model.entity.Employee;

@Getter
@Setter
@NoArgsConstructor
public class TaskDto {
    private Long employee_id;

    private Long id;

    private String description;

    private Status status;
}
