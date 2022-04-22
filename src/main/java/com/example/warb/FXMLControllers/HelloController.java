package com.example.warb.FXMLControllers;

import com.example.warb.JPAEntities.Student;
import com.example.warb.Repositories.StudentRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

      @Autowired
      public StudentRepository StudentRepo;
      @FXML
      TableView<Student> TVStudents;
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



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<Student> Students = (ArrayList<Student>) StudentRepo.findAll();

        ColID.setCellValueFactory(new PropertyValueFactory<>("Id"));
        ColFirstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        ColMiddleName.setCellValueFactory(new PropertyValueFactory<>("MiddleName"));
        ColLastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        SList.addAll(Students);

        TVStudents.getColumns().addAll(ColID,ColFirstName,ColMiddleName,ColLastName);
        TVStudents.setItems(SList);
    }
}