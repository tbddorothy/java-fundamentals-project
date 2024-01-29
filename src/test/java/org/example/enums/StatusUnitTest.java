package org.example.enums;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatusUnitTest {
    @Test
    public void EnumLabelTest(){
        assertEquals("New", Status.NEW.getLabel());
        assertEquals("Active", Status.ACTIVE.getLabel());
        assertEquals("Complete", Status.COMPLETE.getLabel());
    }

    /*@Test
    public void EnumValueTest(){
        assertEquals(Status.NEW, Status.valueOf("New"));
        assertEquals(Status.ACTIVE, Status.valueOf("Active"));
        assertEquals(Status.COMPLETE, Status.valueOf("Complete"));
    }*/

    @ParameterizedTest
    @EnumSource(Status.class)
    public void TestEnumLabels(Status status){
        assertEquals(status.getLabel().toUpperCase(), status.name());
    }
}
