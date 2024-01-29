package org.example.model.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeDto {

    private String email;

    private String firstName;

    private String lastName;

    private String position;
}
