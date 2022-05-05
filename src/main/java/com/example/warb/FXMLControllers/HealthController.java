package com.example.warb.FXMLControllers;


import com.example.warb.JPAEntities.Health;
import com.example.warb.JPAEntities.Student;
import com.example.warb.Repositories.HealthRepository;
import com.example.warb.Repositories.StudentRepository;
import com.example.warb.Repositories.UserRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;



public class HealthController {

    @Autowired
    private StudentRepository StudentRepo;
    @Autowired
    private HealthRepository HealthRepo;
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
    private TextField TbPhysicalDefects;
    @FXML
    public Button Save;
    @FXML
    public Button Update;
    @FXML
    public Button Delete;


    @Autowired
    private UserRepository UserRepo;

@Autowired
    Health health1;



    @FXML
    private TextField TFId, TFFirstName, TFMiddleName, TFLastName;

    private final TableColumn<Health, String> ColAsthmatic =
            new TableColumn<>("Asthmatic");

    private final TableColumn<Health, String>  ColUrinaryDisorder=
            new TableColumn<>("Urinary Disorder");

    private final TableColumn<Health, String>  ColEarProblem=
            new TableColumn<>("Ear Problem");

    private final TableColumn<Health, String>  ColEyeProblem=
            new TableColumn<>("Eye Problem");

    private final TableColumn<Health, String>  ColHeartProblems=
            new TableColumn<>("Heart Problem");

    private final TableColumn<Health, String>  ColOther=
            new TableColumn<>("Other");

    private final TableColumn<Health, String>  ColPhysicalDefects=
            new TableColumn<>("Physical Defects");
















    @FXML
    private TableView<Student> StudentTable;
    @FXML
    private TableView<Health> HealthTable;

    private TextField[] HealthTextFields = new TextField[18];
    private final TableColumn<Student, Integer> ColID =
            new TableColumn<>("Student Id");
    private final TableColumn<Student, String> ColFirstName =
            new TableColumn<>("First Name");
    private final TableColumn<Student, String> ColMiddleName =
            new TableColumn<>("Middle Name");
    private final TableColumn<Student, String> ColLastName =
            new TableColumn<>("Last Name");

    @FXML
    private ImageView ProfilePicture;
    ObservableList<Student> StudentList = FXCollections.observableArrayList();
    ObservableList<Health> HealthList = FXCollections.observableArrayList();
    Alert Dialog;

    private ObservableList<Student> getListOfStudents() {
        return StudentList = FXCollections.observableArrayList(StudentRepo.findAll());
    }

    private ObservableList<Health> getListOfHealth() {
        return HealthList = FXCollections.observableArrayList(HealthRepo.findAll());
    }



    @FXML
    private void initialize(){
        LoadStudentInfo();
        LoadHealthTable();
        StudentTable.setOnMouseClicked(e -> {
            if (e.getClickCount() > 0) {

                loadselectediteminfields();
            }

        });
    }






    private void SetColumnProperties() {
        ColID.setCellValueFactory(new PropertyValueFactory<>("Id"));
        ColLastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        ColMiddleName.setCellValueFactory(new PropertyValueFactory<>("MiddleName"));
        ColFirstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));

    }
    private void SetHealthTableColumnProperties() {
        ColID.setCellValueFactory(new PropertyValueFactory<>("PhysicalDefects"));
        ColAsthmatic.setCellValueFactory(new PropertyValueFactory<>("Asthmatic"));
        ColUrinaryDisorder.setCellValueFactory(new PropertyValueFactory<>("UrinaryDisoder"));
        ColEarProblem.setCellValueFactory(new PropertyValueFactory<>("EarProblem"));
        ColEyeProblem.setCellValueFactory(new PropertyValueFactory<>("EyeProblem"));
        ColHeartProblems.setCellValueFactory(new PropertyValueFactory<>("HeartProblems"));
        ColOther.setCellValueFactory(new PropertyValueFactory<>("Other"));
        ColPhysicalDefects.setCellValueFactory(new PropertyValueFactory<>("PhysicalDefects"));
    }


    @FXML
    private void LoadHealthTable() {
        ArrayList<Student> Students = (ArrayList<Student>) StudentRepo.findAll();
        SetColumnProperties();
        HealthTable.getColumns().clear();
        HealthTable.getItems().clear();
        HealthTable.getColumns().addAll(ColAsthmatic,ColEarProblem,ColEyeProblem,ColHeartProblems,ColPhysicalDefects,ColUrinaryDisorder,ColOther);
        HealthTable.getItems();
        HealthList.addAll(HealthRepo.findAll());
        HealthTable.setItems(HealthList);
    }

    @FXML
    private void AddHealthRecord (){

        if(!TFId.getText().isEmpty()){
            health1.setIdStu(Integer.parseInt(TFId.getText()));
            health1.setAsthmatic(TbAsthmatic.getText());
            health1.setEarProblem(TbEarProblem.getText());
            health1.setEyeProblem(TbEyeProblem.getText());
            health1.setUrinaryDisoder(TbUrinaryDisorder.getText());
            health1.setPhysicalDefects(TbPhysicalDefects.getText());
            health1.setHeartProblem(TbHeartProblems.getText());
            health1.setOther(TbOther.getText());
            HealthRepo.saveAndFlush(health1);
            HealthTable.getColumns().clear();
            HealthTable.getItems().clear();
            LoadHealthTable();

        }


    }


    @FXML
    private void DeleteHealthRecord() {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        alert.setTitle("Delete Record Confirmation");
        alert.setContentText("Are you sure you want to Delete this record?");

        Optional<ButtonType> option = alert.showAndWait();

        if (option.get() == null || option.get() == ButtonType.CANCEL) {

        } else if (option.get() == ButtonType.OK) {
            if (!HealthTable.getSelectionModel().isEmpty()) {
                HealthRepo.deleteById(HealthTable.getSelectionModel().getSelectedItem().getId());
                ClearFields();
                LoadHealthTable();
            } else {
                Dialog = new Alert(Alert.AlertType.WARNING);
                Dialog.setTitle("Selection Warning");
                Dialog.setHeaderText("Delete Health Record");
                Dialog.setContentText("Please Select A Record from the table to delete!");
                Dialog.showAndWait();
            }

        }
    }

    @FXML

    private void UpdateHealthRecord() {
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            //alert.setTitle("Confirmation");

            alert.setTitle("Update Record Confirmation");
            alert.setContentText("Are you sure you want to update this record?");

            Optional<ButtonType> option = alert.showAndWait();

            if (option.get() == null || option.get() == ButtonType.CANCEL) {

            } else if (option.get() == ButtonType.OK) {
                if (!HealthTable.getSelectionModel().isEmpty()) {
                    HealthTable.getSelectionModel().getSelectedItem().setHeartProblem(TbHeartProblems.getText());
                    HealthTable.getSelectionModel().getSelectedItem().setPhysicalDefects(TbAsthmatic.getText());
                    HealthTable.getSelectionModel().getSelectedItem().setUrinaryDisoder(TbUrinaryDisorder.getText());
                    HealthTable.getSelectionModel().getSelectedItem().setEyeProblem(TbEyeProblem.getText());
                    HealthTable.getSelectionModel().getSelectedItem().setEarProblem(TbEarProblem.getText());
                    HealthTable.getSelectionModel().getSelectedItem().setHeartProblem(TbPhysicalDefects.getText());
                    HealthTable.getSelectionModel().getSelectedItem().setOther(TbOther.getText());

                    HealthRepo.save(HealthTable.getSelectionModel().getSelectedItem());
                    ClearFields();
                    LoadHealthTable();
                }
            }
        }
            catch(Exception e){

            e.printStackTrace();

            }


    }
    @FXML
    public void ClearFields(){
        TbHeartProblems.setText("");
        TbOther.setText("");
        TbUrinaryDisorder.setText("");
        TbEyeProblem.setText("");
        TbAsthmatic.setText("");
        TbEarProblem.setText("");
        TbPhysicalDefects.setText("");

    }



    @FXML

    private void LoadStudentInfo() {
        ArrayList<Student> Students = (ArrayList<Student>) StudentRepo.findAll();
        SetColumnProperties();
        StudentTable.getColumns().clear();
        StudentTable.getItems().clear();
        StudentTable.getColumns().addAll(ColID,ColFirstName, ColMiddleName, ColLastName);
        StudentTable.getItems();
        StudentList.addAll(StudentRepo.findAll());
        StudentTable.setItems(StudentList);


    }
    @FXML
    private void loadselectediteminfields() {

        try {

            TFId.setText(StudentTable.getSelectionModel().getSelectedItem().getId().toString());
            TFFirstName.setText(StudentTable.getSelectionModel().getSelectedItem().getFirstName());
            TFMiddleName.setText(StudentTable.getSelectionModel().getSelectedItem().getMiddleName());
            TFLastName.setText(StudentTable.getSelectionModel().getSelectedItem().getLastName());
            System.out.println(StudentTable.getSelectionModel().getSelectedItem().getLastName());


        } catch (Exception e) {

        }
    }

    private TableColumn setHealthProperties() {
        TableColumn<Health, Integer> ColStuId = new TableColumn<>("Student Id");
        ColStuId.setCellValueFactory(new PropertyValueFactory<>("idStu"));
        return ColStuId;
    }


    private TextField[] getHealthTextField() {
        TextField[] tbArray = new TextField[24];
        tbArray[0] = PhysicalDefects;
        tbArray[1] = TbHeartProblems;
        tbArray[2] = TbAsthmatic;
        tbArray[3] = TbUrinaryDisorder;
        tbArray[4] = TbEarProblem;
        tbArray[5] = TbEyeProblem;
        tbArray[6] = TbOther;
        return tbArray;
    }


    @FXML
    private void LoadStudentTable(){

        try {

            StudentTable.getColumns().clear();
            StudentTable.getItems().clear();

            ArrayList<Student> Students = (ArrayList<Student>) StudentRepo.findAll();

            StudentTable.getColumns().addAll(ColID, ColFirstName, ColMiddleName, ColLastName);

            if (!getListOfStudents().isEmpty()) {
                StudentTable.setItems(getListOfStudents());
            }

        } catch (Exception e) {
            e.printStackTrace();
            Dialog = new Alert(Alert.AlertType.WARNING);
            Dialog.setTitle("Error Message");
            Dialog.setHeaderText("Error");
            Dialog.setContentText("An error occurred please try again");
            Dialog.showAndWait();

        }


    }





                }