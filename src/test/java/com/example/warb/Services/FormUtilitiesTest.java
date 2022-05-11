package com.example.warb.Services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FormUtilitiesTest {

    FormUtilities TestObject = new FormUtilities();
    @Test
    void validateAttendanceFormTestWithTrueCondition() {
        assertTrue(TestObject.validateAttendanceForm("","","",
                "","", "", "","1","","","","",
                "", "","","","",""));
    }
    @Test
    void validateAttendanceFormTestWithFalseCondition(){
        assertFalse(TestObject.validateAttendanceForm("","","",
                "","", "", "","","","","","",
                "", "","","","",""));
    }
}