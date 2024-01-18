package org.example.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.model.dto.EmployeeDto;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
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


}
