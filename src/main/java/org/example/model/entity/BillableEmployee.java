package org.example.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class BillableEmployee extends Employee {
    @Column
    int level;

    @Override
    public String getPosition() {
        return super.getPosition() + " Level" + level;
    }
}
