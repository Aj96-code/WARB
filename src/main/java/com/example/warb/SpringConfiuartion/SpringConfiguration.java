package com.example.warb.SpringConfiuartion;
import com.example.warb.FXMLControllers.HelloController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.example.warb.Repositories")
public class SpringConfiguration {
    @Bean
    public HelloController helloController(){
        return new HelloController();
    }
}
