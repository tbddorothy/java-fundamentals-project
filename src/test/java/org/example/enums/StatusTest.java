package org.example.enums;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class StatusTest {
    @Test
    void TestEnumValues()
    {
        Assertions.assertEquals("New",Status.NEW.getLabel());
        Assertions.assertEquals("Active",Status.ACTIVE.getLabel());
        Assertions.assertEquals("Complete",Status.COMPLETE.getLabel());
    }

    @Test
    void TestEnumLabels()
    {
        Assertions.assertEquals(Status.NEW,Status.valueOf("NEW"));
        Assertions.assertEquals(Status.ACTIVE,Status.valueOf("ACTIVE"));
        Assertions.assertEquals(Status.COMPLETE,Status.valueOf("COMPLETE"));
    }

    @ParameterizedTest
    @EnumSource(Status.class)
    void testEnumLabels(Status status)
    {
        Assertions.assertEquals(status.getLabel().toUpperCase(),status.name());
    }
}
