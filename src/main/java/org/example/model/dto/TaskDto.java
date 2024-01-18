package org.example.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class TaskDto {

    public TaskDto() {
    }

    private String description;

    private String status;

}
