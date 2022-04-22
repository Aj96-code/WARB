package com.example.warb.SpringConfiuartion;
import com.example.warb.FXMLControllers.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.BeanProperty;
import java.beans.Transient;

@Configuration
@EnableJpaRepositories("com.example.warb.Repositories")
public class SpringConfiguration {
    @Bean
    public LoginController loginController(){
        return new LoginController();
    }
    @Bean
    public MainController mainController(){
        return new MainController();
    }
    @Bean
    public AddStudentController addStudentController (){return new AddStudentController();}
    @Bean
    public AttendanceController attendanceController (){return new AttendanceController();}
    @Bean
    public AssessmentController assessmentController (){return new AssessmentController();}
    @Bean
    public HealthController healthController (){return new HealthController();}
    @Bean
    public SettingsController settingsController (){return  new SettingsController();}

    @Bean
    public HelloController helloController(){
        return new HelloController();
    }
    @Bean
    public DashboardController dashboardController() {return  new DashboardController();}

}
