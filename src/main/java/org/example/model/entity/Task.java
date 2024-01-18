package org.example.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.enums.Status;

@Setter
@Getter
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

}
