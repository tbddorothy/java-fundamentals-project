package org.example.enums;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.Assert.assertEquals;

public class StatusUnitTest {
    @Test
    public void testEnumValues() {
        assertEquals("New", Status.NEW.getLabel());
        assertEquals("Active", Status.ACTIVE.getLabel());
        assertEquals("Complete", Status.COMPLETE.getLabel());
    }

    @Test
    public void testEnumLabels() {
        assertEquals(Status.NEW, Status.valueOf("NEW"));
        assertEquals(Status.ACTIVE, Status.valueOf("ACTIVE"));
        assertEquals(Status.COMPLETE, Status.valueOf("COMPLETE"));
    }

    @ParameterizedTest
    @EnumSource(Status.class)
    public void testEnumLabels(Status status){
        assertEquals(status.getLabel().toUpperCase(), status.name());
    }
}
