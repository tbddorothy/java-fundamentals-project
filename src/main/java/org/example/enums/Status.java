package org.example.enums;

import lombok.Getter;

@Getter
public enum Status {
    NEW("New"),
    ACTIVE("Active"),
    COMPLETE("Complete"),
    OVERDUE("OVERDUE");


    private final String label;

    Status(String label) {
        this.label = label;
    }

    ;;
}
