package org.example.enums;

public enum Status {
    NEW("New"),
    ACTIVE("Active"),
    COMPLETE("Complete"),
    OVERDUE("Overdue");

    private final String label;

    Status(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
