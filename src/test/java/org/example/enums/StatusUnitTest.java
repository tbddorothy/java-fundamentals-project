package org.example.enums;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class StatusUnitTest {
    @Test
    public void StatusTest() {
        Assertions.assertEquals("New", Status.NEW.getLabel());
        Assertions.assertEquals("Active", Status.ACTIVE.getLabel());
        Assertions.assertEquals("Complete", Status.COMPLETE.getLabel());
    }

    @ParameterizedTest
    @EnumSource(Status.class)
    public void testEnumLabel(Status status) {
        Assertions.assertEquals(status.getLabel().toUpperCase(), status.name());
    }
}
