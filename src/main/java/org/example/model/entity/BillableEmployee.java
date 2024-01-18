package org.example.model.entity;

public class BillableEmployee extends Employee {
    int level;

    @Override
    public String getPosition() {
        return super.getPosition() + " Level " + level;
    }
}
