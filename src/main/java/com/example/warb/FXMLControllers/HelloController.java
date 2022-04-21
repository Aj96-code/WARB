package com.example.warb.FXMLControllers;

import com.example.warb.JPAEntities.Student;
import com.example.warb.Repositories.StudentRepository;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import org.hibernate.annotations.common.util.impl.Log;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;


public class HelloController  {

      @Autowired
      public StudentRepository StudentRepo;
      @FXML
      TableView TVStudents;

      @FXML
      public void initialize() {
       ArrayList<Student> Students = (ArrayList<Student>) StudentRepo.findAll();
       for(Student S : Students){
           System.out.println(S.getFirstName());
       }


      }
}