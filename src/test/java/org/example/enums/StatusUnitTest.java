package org.example.enums;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class StatusUnitTest {
    @Test
    public void StatusUnitTest1() {
    Status status = Status.NEW;
        Assertions.assertEquals(Status.NEW, status);
        Assertions.assertEquals("New", status.getLabel());
        Assertions.assertEquals("Active", Status.ACTIVE.getLabel());
    }
    @Test
    public  void StatusEmpytyConstructor (){
        Status status = null;
        Assertions.assertNull(status);
    }
    @ParameterizedTest
    @EnumSource(Status.class)
    public  void StatusIterateTest (Status status){
        Assertions.assertEquals(
                status.getLabel().toUpperCase(),
                status.name().toUpperCase()
        );
    }
}
