package com.example.warb.SpringConfiuartion;

import com.example.warb.FXMLControllers.*;
import com.example.warb.Repositories.StudentRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.example.warb.Repositories")
@ComponentScan(basePackages = { "com.example.warb.*" })
@EntityScan("com.example.warb.*")
public class SpringConfiguration {
    @Bean
    @Primary
    public LoginController loginController() {
        return new LoginController();
    }
    @Bean
    public MainController mainController() {
        return new MainController();
    }


    @Bean
    public AddStudentController addStudentController() {
        return new AddStudentController();
    }

    @Bean
    public AttendanceController attendanceController() {
        return new AttendanceController();
    }

    @Bean
    public AssessmentController assessmentController() {
        return new AssessmentController();
    }

    @Bean
    public HealthController healthController() {
        return new HealthController();
    }

    @Bean
    public SettingsController settingsController() {
        return new SettingsController();
    }

    @Bean
    public DashboardController dashboardController() {
        return new DashboardController();
    }

}
