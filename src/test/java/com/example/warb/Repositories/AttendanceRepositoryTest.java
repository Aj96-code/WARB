package com.example.warb.Repositories;

import com.example.warb.Main;
import com.example.warb.SpringConfiuartion.SpringConfiguration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(classes = Main.class)
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@ContextConfiguration(classes =  SpringConfiguration.class)
public class AttendanceRepositoryTest {
    @Autowired
    AttendanceRepository Test;
    @Test
    void selectAttendanceExists() {
        Test.findAll();

    }
}