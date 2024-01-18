package org.example.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.model.dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class BillableEmployee extends Employee{

    @Column
    int level;


    @Override
    public String getPosition(){
        return super.getPosition() + " Level" + level;
    }
}
