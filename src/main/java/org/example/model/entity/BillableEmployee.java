package org.example.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class BillableEmployee extends Employee{
    @Column
    int level;

    @Override
    public String getPosition(){
        return super.getPosition() + " Level" + level;
    }
}
