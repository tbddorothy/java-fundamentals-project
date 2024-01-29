package org.example.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.model.dto.EmployeeDto;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employee {
    public Employee(EmployeeDto employeeDto) {
        this.firstName = employeeDto.getFirstName();
        this.lastName = employeeDto.getLastName();
        this.position = employeeDto.getPosition();
        this.email = employeeDto.getEmail();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String email;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String position;

    public Employee(Long id, String email, String firstName, String lastName, String position) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
    }
    public void SetDefault (){
        this.id = 1L;
        this.email = "email@mail.com";
        this.firstName = "firstName";
        this.lastName = "lastName";
        this.position = "position";
    }
}
