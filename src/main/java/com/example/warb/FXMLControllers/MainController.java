package com.example.warb.FXMLControllers;
import com.example.warb.JPAEntities.User;
import com.example.warb.Main;
import com.example.warb.Services.PassingUserService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
@Controller
public class MainController implements Initializable {
    User TypeUser = new User();
    @FXML
    public Button btnSetting;
    @Autowired
    private BeanFactory BeanContainer;
    @FXML
    private StackPane contentArea;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        PassingUserService Passing = PassingUserService.getInstance();
        TypeUser = Passing.getUser();
        System.out.println(TypeUser.getUsername());
        if(!TypeUser.equals(null)){
            if(!TypeUser.getRole().equals("Admin"))
                btnSetting.setVisible(false);
        }
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
    public void addStudent(javafx.event.ActionEvent actionEvent) throws IOException {
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

    public void setUser(User CurrentUser) {
        TypeUser = CurrentUser;
    }
}
