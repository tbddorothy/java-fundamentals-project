package org.example.enums;

import org.example.model.entity.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class EnumTest {
    @ParameterizedTest
    @EnumSource(Status.class)
    public void testEnumLabels(Status status) {
        Assertions.assertEquals(status.getLabel().toUpperCase(),status.name());
    }
}
