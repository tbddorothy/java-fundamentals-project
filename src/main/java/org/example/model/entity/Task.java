package org.example.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.enums.Status;
import org.example.model.dto.EmployeeDto;
import org.example.model.dto.TaskDto;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task{

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

    @Column
    private Status status;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
