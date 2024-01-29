package org.example.model.dto;

import org.example.enums.Status;

import java.util.Date;

public class TaskUpdateDto {
    public TaskUpdateDto() {
    }

    private Long employeeId;

    public String getDescription() {
        return description;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    private Status status;

}
