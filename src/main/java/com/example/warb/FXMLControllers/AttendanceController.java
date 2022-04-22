package com.example.warb.FXMLControllers;

import com.example.warb.JPAEntities.Student;
import com.example.warb.Repositories.StudentRepository;
import com.sun.jna.platform.win32.WinGDI;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.swing.text.html.ImageView;
import java.awt.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;

@Component
public class AttendanceController {

    @Autowired
    public StudentRepository StudentRepo;
    @FXML
    public TextField TbGrade1Term1;
    @FXML
    public TextField TbGrade1Term2;
    @FXML
    public TextField TbGrade1Term3;
    @FXML
    public TextField TbGrade2Term1;
    @FXML
    public TextField TbGrade2Term2;
    @FXML
    public TextField TbGrade2Term3;
    @FXML
    public TextField TbGrade3Term1;
    @FXML
    public TextField TbGrade3Term2;
    @FXML
    public TextField TbGrade3Term3;
    @FXML
    public TextField TbGrade4Term1;
    @FXML
    public TextField TbGrade4Term2;
    @FXML
    public TextField TbGrade4Term3;
    @FXML
    public TextField TbGrade5Term1;
    @FXML
    public TextField TbGrade5Term2;
    @FXML
    public TextField TbGrade5Term3;
    @FXML
    public TextField TbGrade6Term1;
    @FXML
    public TextField TbGrade6Term2;
    @FXML
    public TextField TbGrade6Term3;
    @FXML
    public TableView<Student> TVStudentList;
    @FXML
    private TextField TbId = new TextField();
    @FXML
    private TextField TbFirstName;
    @FXML
    private TextField TbMiddleName;
    @FXML
    private TextField TbLastName;
    @FXML
    private TableColumn<Student, String> ColFirstName =
            new TableColumn<>("First Name");
    @FXML
    private TableColumn<Student, String> ColLastName =
            new TableColumn<>("Last Name");
    @FXML
    private TableColumn<Student, String> ColMiddleName =
            new TableColumn<>("Middle Name");
    @FXML
    private TableColumn<Student, Integer> ColID =
            new TableColumn<>("Student Id");
    ObservableList<Student> SList = FXCollections.observableArrayList();


    @FXML
    public void BtnSave_Click(ActionEvent event){
        System.out.println(TbId.getText()+ " "+
                TbFirstName.getText()+ " "+
                TbMiddleName.getText()+ " " +
                TbLastName.getText() );
    }

    @FXML
    public void initialize(){
        ArrayList<Student> Students = (ArrayList<Student>) StudentRepo.findAll();

        ColID.setCellValueFactory(new PropertyValueFactory<>("Id"));
        ColFirstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        ColMiddleName.setCellValueFactory(new PropertyValueFactory<>("MiddleName"));
        ColLastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        SList.addAll(Students);

        TVStudentList.getColumns().addAll(ColID,ColFirstName,ColMiddleName,ColLastName);
        TVStudentList.setItems(SList);


    }

    private void SetupTable() {

    }


}
