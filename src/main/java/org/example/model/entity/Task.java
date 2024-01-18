package org.example.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.enums.Status;
import org.example.model.dto.TaskDto;


@Entity //annotation
@Getter
@Setter
@NoArgsConstructor
public class Task {

    public Task(TaskDto taskDto) {
        this.id = taskDto.getId();
        this.description = taskDto.getDescription();
        this.status = taskDto.getStatus();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column
    private Status status;
}
