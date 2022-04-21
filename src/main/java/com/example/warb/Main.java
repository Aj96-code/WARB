package com.example.warb;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
@SpringBootApplication

public class Main extends Application {
    private ConfigurableApplicationContext SpringContext;
    private Parent Root;

    @Override
    public void init() throws IOException {
        SpringContext = SpringApplication.run(Main.class);
        SpringContext.getClass().getClassLoader();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        fxmlLoader.setControllerFactory(SpringContext::getBean);
        Root = fxmlLoader.load();

    }

    @Override
    public void stop() {
        SpringContext.close();
        Platform.exit();
    }

    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(Root, 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}