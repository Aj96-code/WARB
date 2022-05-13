package com.example.warb.Services;

import com.example.warb.JPAEntities.Assessment;
import com.example.warb.JPAEntities.Attendance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FormUtilitiesTest {
    ArrayList<Attendance> ListOfAttendance = new ArrayList<>();
    ArrayList<Assessment> ListOfAssessment = new ArrayList<>();
    @BeforeEach
    void setUp() {
        Attendance A = new Attendance();
        Assessment Assem = new Assessment();
        Assem.setIdStu(4);
        A.setIdStu(1);
        ListOfAssessment.add(Assem);
        ListOfAttendance.add(A);
    }

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
    @Test
    void FindObjectInAttendanceListTestWithTrueCondition(){
        assertTrue(TestObject.FindObjectInAttendanceList(ListOfAttendance,1));
    }

    @Test
    void FindObjectInAttendanceListTestWithFalseCondition(){
        assertFalse(TestObject.FindObjectInAttendanceList(ListOfAttendance,9));
    }
    @Test
    void FindObjectInAssessmentListTestWithTrueCondition(){
        assertTrue(TestObject.FindObjectInAssessmentList(ListOfAssessment,4));
    }

    @Test
    void FindObjectInAssessmentListTestWithFalseCondition(){
        assertFalse(TestObject.FindObjectInAssessmentList(ListOfAssessment, 5));
    }
}