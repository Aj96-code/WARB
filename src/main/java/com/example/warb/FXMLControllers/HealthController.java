package com.example.warb.FXMLControllers;

import com.example.warb.JPAEntities.Student;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class HealthController {

    @FXML
    private TextField PhysicalDefects;
    @FXML
    private TextField TbHeartProblems;
    @FXML
    private TextField TbAsthmatic;
    @FXML
    private TextField TbUrinaryDisorder;
    @FXML
    private TextField TbEarProblem;
    @FXML
    private TextField TbEyeProblem;
    @FXML
    private TextField TbOther;
    @FXML
    private TableView<Student> StudentTable;
    @FXML
    private TextField TbId, TbFirstName, TbMiddleName, TbLastName;

}