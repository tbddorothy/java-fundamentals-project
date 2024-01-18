package org.example.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import org.example.model.dto.EmployeeDto;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_id")
    private String emailId;

    public Employee(EmployeeDto employeeDto) {
        this.firstName=employeeDto.getFirstName();
        this.emailId=employeeDto.getEmail();
        this.lastName=employeeDto.getLastName();
    }

    protected String getPosition() {
        return null;
    }

    public void setPosition(String position) {
    }
}