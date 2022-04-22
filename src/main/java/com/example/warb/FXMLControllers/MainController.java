package com.example.warb.FXMLControllers;

import com.example.warb.Main;
import com.example.warb.SpringConfiuartion.SpringConfiguration;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.util.Callback;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
public class MainController implements Initializable{
    private ConfigurableApplicationContext SpringContext;
    @Autowired
    private BeanFactory BeanContainer;

    @FXML
    private StackPane contentArea;
    @Override
     public void initialize(URL location, ResourceBundle resources) {


        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/warb/dashboard.fxml"));
            fxmlLoader.setControllerFactory(BeanContainer::getBean);
            Parent fxml = fxmlLoader.load();
            contentArea.getChildren().removeAll();
            contentArea.getChildren().setAll(fxml);
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void dashboard(javafx.event.ActionEvent actionEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/warb/dashboard.fxml"));
        fxmlLoader.setControllerFactory(BeanContainer::getBean);
        Parent fxml = fxmlLoader.load();
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    public void addstudent(javafx.event.ActionEvent actionEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/warb/addstudent.fxml"));
        fxmlLoader.setControllerFactory(BeanContainer::getBean);
        Parent fxml = fxmlLoader.load();
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    public void assessment(javafx.event.ActionEvent actionEvent) throws IOException {


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/warb/assessment.fxml"));
        fxmlLoader.setControllerFactory(BeanContainer::getBean);
        Parent fxml = fxmlLoader.load();
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    public void attendance(javafx.event.ActionEvent actionEvent) throws IOException, ClassNotFoundException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/warb/attendance.fxml"));
        fxmlLoader.setControllerFactory(BeanContainer::getBean);
        Parent fxml = fxmlLoader.load();
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    public void health(javafx.event.ActionEvent actionEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/warb/health.fxml"));
        fxmlLoader.setControllerFactory(BeanContainer::getBean);
        Parent fxml = fxmlLoader.load();
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    public void settings(javafx.event.ActionEvent actionEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/warb/settings.fxml"));
        fxmlLoader.setControllerFactory(BeanContainer::getBean);
        Parent fxml = fxmlLoader.load();
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }



}
