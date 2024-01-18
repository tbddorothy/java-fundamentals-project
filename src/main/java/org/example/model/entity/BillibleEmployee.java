package org.example.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
@Entity
public class BillibleEmployee extends Employee {

    @Column
    int level;

    @Override
    public String getPosition(){
        return super.getPosition() + " Level" + level;
    }
}
