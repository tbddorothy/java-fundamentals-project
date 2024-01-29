package org.example.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.enums.Status;

@Getter
@Setter
@NoArgsConstructor
public class TaskDto {
    private Long id;

    private String description;

    private Status status;

    private Long employeeId;
}
