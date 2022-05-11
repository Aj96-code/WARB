package com.example.warb.FXMLControllers;

import com.example.warb.JPAEntities.User;
import com.example.warb.Repositories.UserRepository;
import com.example.warb.Services.PassingUserService;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;

public class LoginController {


    @FXML
    public TextField TbUserName;
    @FXML
    public PasswordField TbPassword;
    public Label ErrorMessage;
    public Button BtnCancel;
    @Autowired
    public BeanFactory BeanContainer;
    @Autowired
    public UserRepository UserRepo;

    ArrayList<User> Users = new ArrayList<User>();

    public void DashboardForm(User CurrentUser) throws MalformedURLException {
        PassingUserService Passing = PassingUserService.getInstance();
        Passing.setUser(CurrentUser);
        Parent Root;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(new URL(Objects.requireNonNull(getClass().getResource("/com/example/warb/Main.fxml"))
                    .toExternalForm()));
            fxmlLoader.setControllerFactory(BeanContainer::getBean);
            Root = fxmlLoader.load();
            Stage loginStage = new Stage();
            loginStage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResource("/img/logo2.png")).toExternalForm()));
            loginStage.setScene(new Scene(Root, 1100, 680));
            loginStage.setResizable(false);
            loginStage.setUserData(CurrentUser);
            loginStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            e.getCause();
        }
    }
    public void loginActionBtn(ActionEvent actionEvent) throws MalformedURLException {
        final Node source = (Node) actionEvent.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        Users = (ArrayList<User>) UserRepo.findAll();
        User CurrentUser = new User();
        boolean isFound = false;
        for(User _User : Users){
            if(_User.getUsername().equals(TbUserName.getText())){
                isFound = true;
                CurrentUser = _User;
                break;
            }
        }
        if(isFound && TbPassword.getText().equals(CurrentUser.getPassword())) {
            DashboardForm(CurrentUser);
            stage.close();
        }
        else if(!TbPassword.getText().isEmpty() && !TbPassword.getText().isEmpty())
            ErrorMessage.setText("Wrong User Name or Password");
        else
            ErrorMessage.setText("Please Enter User information");
    }
    public void BtnCancel_Click(ActionEvent event) {
        Platform.exit();
    }
}

