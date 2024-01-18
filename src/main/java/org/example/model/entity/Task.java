package org.example.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.enums.Status;
import org.example.model.dto.TaskDto;


@Getter
@Setter
@Entity
public class Task {

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

    public Task(TaskDto taskDto) {
        this.status= Status.valueOf(taskDto.getStatus());
        this.description = taskDto.getDescription();
    }
}
