package org.example.model.entity;

import jakarta.persistence.Column;

public class BillableEmployee extends Employee {
    @Column
    int level;

    @Override
    public String getPosition(){
        return super.getPosition() + "level" + level;
    }
}
