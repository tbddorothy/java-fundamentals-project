package org.example.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.enums.Status;
import org.example.model.dto.EmployeeDto;
import org.example.model.dto.TaskDto;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Task {

    @Column
    @Id
    private long id;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column
    private Status status;
}
