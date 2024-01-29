package org.example.enums;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.Assert.assertEquals;

public class StatusUnitTest {

    @Test
    public void testEnumValue(){
        assertEquals("New", Status.NEW.getLabel());
        assertEquals("Active", Status.ACTIVE.getLabel());
        assertEquals("Complete", Status.COMPLETE.getLabel());
    }

    @ParameterizedTest
    @EnumSource( Status.class)
    public void testEnumLabels(Status status) {
        assertEquals(status.getLabel().toUpperCase(), status.name());
    }
}
