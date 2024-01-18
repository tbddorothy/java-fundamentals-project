package org.example.model.entity;

import lombok.Getter;

@Getter
public class BillableEmployee extends Employee {
    int level;

    @Override
    public String getPosition() {
        return super.getPosition() + " Level " + level;
    }
}
