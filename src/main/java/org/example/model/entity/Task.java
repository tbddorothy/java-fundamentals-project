package org.example.model.entity;

import lombok.Getter;
import org.example.enums.Status;
import jakarta.persistence.*;

@Getter
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column
    private String description;

    @Column
    private Status status;
}
