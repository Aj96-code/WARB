package com.example.warb;

import com.example.warb.FXMLControllers.HelloController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;

@SpringBootApplication
@ComponentScan
@EnableJpaRepositories("com.example.warb.Repositories")
public class Main extends Application {
    private ConfigurableApplicationContext SpringContext;
    private Parent Root;
    double x,y;
    @Override
    public void init() throws IOException {
        SpringContext = SpringApplication.run(Main.class);
        SpringContext.getClass().getClassLoader();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
        fxmlLoader.setControllerFactory(SpringContext::getBean);
        Root = fxmlLoader.load();
    }

    @Override
    public void stop() {
        SpringContext.close();
        Platform.exit();
    }

    @Override
    public void start(Stage stage) throws IOException, URISyntaxException {
        Root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });

        Root.setOnMouseDragged(event ->{
            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);
        });
        stage.getIcons().add(new Image(getClass().getResource("/img/logo2.png").toExternalForm()));
        Scene scene = new Scene(Root, 640, 400);
        stage.setTitle("Welcome");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}