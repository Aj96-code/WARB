package com.example.warb.FXMLControllers;

import com.example.warb.JPAEntities.User;
import com.example.warb.Repositories.StudentRepository;
import com.example.warb.Repositories.UserRepository;
import com.example.warb.Services.PassingUserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

@Controller
public class DashboardController implements Initializable {
    public Label LblUserName;
    @Autowired
    private BeanFactory BeanContainer;
    double AmountOfStudent = 0,AmountOfUser = 0;
    @Autowired
    StudentRepository StudentRepo;
    @Autowired
    UserRepository UserRepo;
    @FXML
    Label StudentCount, UserCount;

    @FXML
    private javafx.scene.chart.PieChart PieChart;

    private StackPane ContentArea;
    public DashboardController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        PassingUserService Passing = PassingUserService.getInstance();
        User CurrentUser = Passing.getUser();
        LblUserName.setText(CurrentUser.getUsername());
        AmountOfStudent = StudentRepo.findAll().size();
        AmountOfUser = UserRepo.findAll().size();
        StudentCount.setText(String.valueOf(Integer.valueOf((int) AmountOfStudent)));
        UserCount.setText(String.valueOf(Integer.valueOf((int) AmountOfUser)));
        double TotalAmount = AmountOfUser + AmountOfStudent;
        double PercentageOfStudents = (AmountOfStudent / TotalAmount) * 100;
        double PercentageOfUsers = (AmountOfUser / TotalAmount) * 100;


        PieChart.Data stu = new PieChart.Data("Students", PercentageOfStudents);
        PieChart.Data user = new PieChart.Data("User", PercentageOfUsers);

        PieChart.getData().addAll(stu,user);
    }


}