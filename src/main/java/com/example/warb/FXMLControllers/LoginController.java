package com.example.warb.FXMLControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
public class LoginController {


    @Autowired
    BeanFactory BeanContainer;

    public void DashboardForm() throws MalformedURLException {
        Parent Root;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(new URL(getClass().getResource("/com/example/warb/Main.fxml")
                    .toExternalForm()));
            fxmlLoader.setControllerFactory(BeanContainer::getBean);
            Root = fxmlLoader.load();
            Stage loginStage = new Stage();
            loginStage.getIcons().add(new Image(getClass().getResource("/img/logo2.png").toExternalForm()));
            loginStage.setScene(new Scene(Root, 1100, 680));
            loginStage.setResizable(false);
            loginStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            e.getCause();
        }

    }

    public void loginActionbtn(ActionEvent actionEvent) throws MalformedURLException {
        DashboardForm();
        final Node source = (Node) actionEvent.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
        //Platform.exit();
    }
}

