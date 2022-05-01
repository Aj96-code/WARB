package com.example.warb.FXMLControllers;

import com.example.warb.Main;
import javafx.scene.control.TextField;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AttendanceControllerTest {
    Main Test ;
    AttendanceController ControllerTest;
    @BeforeEach
    void setUp() {
        Test = new Main();
        ControllerTest = new AttendanceController();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void validateForm() {
        assertEquals(false, ControllerTest.validateForm());
    }


}