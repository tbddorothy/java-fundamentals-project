package org.example.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity//annotations
@Getter
@Setter
public class BillableEmployee extends Employee{

    @Column
    int level;

    @Override
    public String getPosition()
    {
        return super.getPosition() + " Level" + level;
    }

}
