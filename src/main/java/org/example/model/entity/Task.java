package org.example.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.enums.Status;
import jakarta.persistence.*;
import org.example.model.dto.EmployeeDto;
import org.example.model.dto.TaskDto;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Task {
    public Task(TaskDto taskDto) {
        this.employee = taskDto.getEmployee();
        this.description = taskDto.getDescription();
        this.status = taskDto.getStatus();
        this.date = taskDto.getDate();
        if (new java.util.Date().after(this.date)) {
            this.setStatusOverDue();
        }
    }

    public void setStatusOverDue() {
        this.status = Status.OVERDUE;
    }

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

    @Column
    private Date date;
}
