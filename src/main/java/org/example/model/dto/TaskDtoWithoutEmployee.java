package org.example.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.enums.Status;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class TaskDtoWithoutEmployee {
    private String description;
    private Date date;
    private Status status;

}
