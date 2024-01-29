package org.example.model;

import org.example.enums.Status;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class StatusUnitTest {
    @Test
    public void TestEnumValues(){
        assertEquals("New", Status.NEW.getLabel());
        assertEquals("Active", Status.ACTIVE.getLabel());
        assertEquals("Complete", Status.COMPLETE.getLabel());
    }

    @Test
    public void TestEnumLabels(){
        assertEquals(Status.NEW, Status.valueOf("NEW"));
        assertEquals(Status.ACTIVE, Status.valueOf("ACTIVE"));
        assertEquals(Status.COMPLETE, Status.valueOf("COMPLETE"));
    }

    @ParameterizedTest
    @EnumSource(Status.class)
    void  testEnumlabels(Status status){
        assertEquals(status.getLabel().toUpperCase(), status.name());
    }
}
