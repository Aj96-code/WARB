package com.example.warb.FXMLControllers;

import com.example.warb.JPAEntities.Attendance;
import com.example.warb.JPAEntities.Student;
import com.example.warb.Repositories.AttendanceRepository;
import com.example.warb.Repositories.StudentRepository;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import org.controlsfx.control.tableview2.TableView2;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Optional;

@Component
public class AttendanceController {

    @Autowired
    private StudentRepository StudentRepo;
    @Autowired
    private AttendanceRepository AttendanceRepo;
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
    private TextField TbId;
    @FXML
    private TextField TbFirstName;
    @FXML
    private TextField TbMiddleName;
    @FXML
    private TextField TbLastName;

    @FXML
    TableView2<Attendance> TV2StudentAttendance;

    private TableColumn<Student, String> ColFirstName =
            new TableColumn<>("First Name");
    private TableColumn<Student, String> ColLastName =
            new TableColumn<>("Last Name");
    private TableColumn<Student, String> ColMiddleName =
            new TableColumn<>("Middle Name");
    private TableColumn<Student, Integer> ColID =
            new TableColumn<>("Student Id");
    @FXML
    private ImageView ProfilePicture;
    ObservableList<Student> SList = FXCollections.observableArrayList();
    ObservableList<Attendance> AList = FXCollections.observableArrayList();
    Alert Dialog;

    @FXML
    public void BtnSave_Click(ActionEvent event){
        if(TbId.getText() !="") {
            SaveAttendanceToDataBase();
        } else {
            Dialog = new Alert(Alert.AlertType.WARNING);
            Dialog.setTitle("Selection Warning");
            Dialog.setHeaderText("Save");
            Dialog.setContentText("Please Select Student from the table");
            Dialog.showAndWait();
        }
    }

    private void SaveAttendanceToDataBase() {
        Attendance NewAttendance = new Attendance();
        int Stud_Id = StudentRepo.findById(Integer.parseInt(TbId.getText())).get().getId();
        System.out.println(Stud_Id);
        boolean IsFound = false;
        ArrayList<Attendance> AttendanceList = (ArrayList<Attendance>) AttendanceRepo.findAll();
        try {
            for (Attendance Item : AttendanceList) {
                if (Item.getIdStu() == Stud_Id) {
                    IsFound = true;
                }
            }
        }catch (Exception EXC){}

        if(IsFound){
            Dialog = new Alert(Alert.AlertType.WARNING);
            Dialog.setTitle("Not Saved");
            Dialog.setHeaderText(null);
            Dialog.setContentText("The Student Attendance Already Exists");
            Dialog.showAndWait();
        }else if(TbGrade1Term1.getText() != "" || TbGrade1Term2.getText() != ""
        ||TbGrade1Term3.getText()  != "" || TbGrade2Term1.getText() != ""
        ||TbGrade2Term2.getText()  != "" || TbGrade2Term3.getText() != ""
        ||TbGrade3Term1.getText()  != "" || TbGrade3Term2.getText() != ""
        ||TbGrade3Term3.getText()  != "" || TbGrade4Term1.getText() != ""
        ||TbGrade4Term2.getText()  != "" || TbGrade4Term3.getText() != ""
        ||TbGrade5Term1.getText()  != "" || TbGrade5Term2.getText() != ""
        ||TbGrade5Term3.getText()  != "" || TbGrade6Term1.getText() != ""
        ||TbGrade6Term2.getText()  != "" || TbGrade6Term3.getText() != "") {

            try {
                NewAttendance.setYear1Term1(Integer.parseInt(TbGrade1Term1.getText()));
                NewAttendance.setYear1Term2(Integer.parseInt(TbGrade1Term2.getText()));
                NewAttendance.setYear1Term3(Integer.parseInt(TbGrade1Term3.getText()));
                NewAttendance.setYear2Term1(Integer.parseInt(TbGrade2Term1.getText()));
                NewAttendance.setYear2Term2(Integer.parseInt(TbGrade2Term2.getText()));
                NewAttendance.setYear2Term3(Integer.parseInt(TbGrade2Term3.getText()));
                NewAttendance.setYear3Term1(Integer.parseInt(TbGrade3Term1.getText()));
                NewAttendance.setYear3Term2(Integer.parseInt(TbGrade3Term2.getText()));
                NewAttendance.setYear3Term3(Integer.parseInt(TbGrade3Term3.getText()));
                NewAttendance.setYear4Term1(Integer.parseInt(TbGrade4Term1.getText()));
                NewAttendance.setYear4Term2(Integer.parseInt(TbGrade4Term2.getText()));
                NewAttendance.setYear4Term3(Integer.parseInt(TbGrade4Term3.getText()));
                NewAttendance.setYear5Term1(Integer.parseInt(TbGrade5Term1.getText()));
                NewAttendance.setYear5Term2(Integer.parseInt(TbGrade5Term2.getText()));
                NewAttendance.setYear5Term3(Integer.parseInt(TbGrade5Term3.getText()));
                NewAttendance.setYear6Term1(Integer.parseInt(TbGrade6Term1.getText()));
                NewAttendance.setYear6Term2(Integer.parseInt(TbGrade6Term2.getText()));
                NewAttendance.setYear6Term3(Integer.parseInt(TbGrade6Term3.getText()));
            } catch (IllegalArgumentException IEX){
                System.out.println("Empty String ");
            }
            if(Stud_Id != 0){
                NewAttendance.setIdStu(Stud_Id);

                AttendanceRepo.saveAndFlush(NewAttendance);
                Dialog = new Alert(Alert.AlertType.INFORMATION);
                Dialog.setTitle("Save Dialog");
                Dialog.setHeaderText(null);
                Dialog.setContentText("Student Attendance Saved");
                Dialog.showAndWait();
                TV2StudentAttendance.getColumns().clear();
                TV2StudentAttendance.getItems().clear();
                LoadAttendanceTable();
                NewAttendance = null;

            } else {
                Dialog = new Alert(Alert.AlertType.ERROR);
                Dialog.setTitle("Not Saved");
                Dialog.setHeaderText(null);
                Dialog.setContentText("The Student Attendance Could not be saved");
                Dialog.showAndWait();
            }

        } else {
            Dialog = new Alert(Alert.AlertType.WARNING);
            Dialog.setTitle("Selection Warning");
            Dialog.setHeaderText(null);
            Dialog.setContentText("Please Enter the Attendance information");
            Dialog.showAndWait();
        }

    }

    @FXML
    public void BtnUpdate_Click(ActionEvent event){

        boolean IsFound = false;
        ArrayList<Attendance> AttendanceList = (ArrayList<Attendance>) AttendanceRepo.findAll();
        for(Attendance Item : AttendanceList){
            if(Item.getIdStu() == TV2StudentAttendance.getSelectionModel().getSelectedItem().getIdStu()){
                IsFound = true;
            }
        }
        if(!IsFound){
            Dialog = new Alert(Alert.AlertType.WARNING);
            Dialog.setTitle("No Record Dialog");
            Dialog.setHeaderText("Update");
            Dialog.setContentText("No Record Found");
            Dialog.showAndWait();
        }
        else {
            try {
                TV2StudentAttendance.getSelectionModel().getSelectedItem().setYear1Term1(Integer.parseInt(TbGrade1Term1.getText()));
                TV2StudentAttendance.getSelectionModel().getSelectedItem().setYear1Term2(Integer.parseInt(TbGrade1Term2.getText()));
                TV2StudentAttendance.getSelectionModel().getSelectedItem().setYear1Term3(Integer.parseInt(TbGrade1Term3.getText()));
                TV2StudentAttendance.getSelectionModel().getSelectedItem().setYear2Term1(Integer.parseInt(TbGrade2Term1.getText()));
                TV2StudentAttendance.getSelectionModel().getSelectedItem().setYear2Term2(Integer.parseInt(TbGrade2Term2.getText()));
                TV2StudentAttendance.getSelectionModel().getSelectedItem().setYear2Term3(Integer.parseInt(TbGrade2Term3.getText()));
                TV2StudentAttendance.getSelectionModel().getSelectedItem().setYear3Term1(Integer.parseInt(TbGrade3Term1.getText()));
                TV2StudentAttendance.getSelectionModel().getSelectedItem().setYear3Term2(Integer.parseInt(TbGrade3Term2.getText()));
                TV2StudentAttendance.getSelectionModel().getSelectedItem().setYear3Term3(Integer.parseInt(TbGrade3Term3.getText()));
                TV2StudentAttendance.getSelectionModel().getSelectedItem().setYear4Term1(Integer.parseInt(TbGrade4Term1.getText()));
                TV2StudentAttendance.getSelectionModel().getSelectedItem().setYear4Term2(Integer.parseInt(TbGrade4Term2.getText()));
                TV2StudentAttendance.getSelectionModel().getSelectedItem().setYear4Term3(Integer.parseInt(TbGrade4Term3.getText()));
                TV2StudentAttendance.getSelectionModel().getSelectedItem().setYear5Term1(Integer.parseInt(TbGrade5Term1.getText()));
                TV2StudentAttendance.getSelectionModel().getSelectedItem().setYear5Term2(Integer.parseInt(TbGrade5Term2.getText()));
                TV2StudentAttendance.getSelectionModel().getSelectedItem().setYear5Term3(Integer.parseInt(TbGrade5Term3.getText()));
                TV2StudentAttendance.getSelectionModel().getSelectedItem().setYear6Term1(Integer.parseInt(TbGrade6Term1.getText()));
                TV2StudentAttendance.getSelectionModel().getSelectedItem().setYear6Term2(Integer.parseInt(TbGrade6Term2.getText()));
                TV2StudentAttendance.getSelectionModel().getSelectedItem().setYear6Term3(Integer.parseInt(TbGrade6Term3.getText()));
            } catch (IllegalArgumentException IEX){
                System.out.println("Empty String ");
            }
            AttendanceRepo.save(TV2StudentAttendance.getSelectionModel().getSelectedItem());
            Dialog = new Alert(Alert.AlertType.INFORMATION);
            Dialog.setTitle("Update Dialog");
            Dialog.setHeaderText("Update");
            Dialog.setContentText("Student Attendance Update");
            Dialog.showAndWait();
            TV2StudentAttendance.getColumns().clear();
            TV2StudentAttendance.getItems().clear();
            LoadAttendanceTable();
        }

    }
    @FXML
    public void BtnDelete_Click(ActionEvent event){
        boolean IsFound = false;
        ArrayList<Attendance> AttendanceList = (ArrayList<Attendance>) AttendanceRepo.findAll();
        for(Attendance Item : AttendanceList){
            if(Item.getIdStu() == TV2StudentAttendance.getSelectionModel().getSelectedItem().getIdStu() ){
                IsFound = true;
            }
        }
        if(IsFound){
            Dialog = new Alert(Alert.AlertType.CONFIRMATION);
            Dialog.setTitle("Delete Dialog");
            Dialog.setHeaderText("Delete");
            Dialog.setContentText("Are Sure you want to Delete?");
            Optional<ButtonType> Result = Dialog.showAndWait();
             if(Result.get() == ButtonType.OK){
                 AttendanceRepo.delete(TV2StudentAttendance.getSelectionModel().getSelectedItem());
                 AttendanceRepo.flush();
                 Dialog.close();
                 TV2StudentAttendance.getColumns().clear();
                 TV2StudentAttendance.getItems().clear();
                 LoadAttendanceTable();
             } else if(Result.get() == ButtonType.CANCEL){
                 Dialog.close();
             }


        }

    }

    @FXML
    public void initialize(){
        LoadStudentTable();
        LoadAttendanceTable();

        TVStudentList.setOnMouseClicked(e -> {
            if(e.getClickCount() > 0){
               LoadSelectedContentInForm();
            }
        });
        TV2StudentAttendance.setOnMouseClicked(e -> {
            if(e.getClickCount() > 0){
                LoadSelectedContentInFormAttendance();
            }
        });


    }

    private void LoadSelectedContentInFormAttendance() {
        TbId.setText(String.valueOf(TV2StudentAttendance.getSelectionModel().getSelectedItem().getIdStu()));
        TbFirstName.setText(StudentRepo.findById(TV2StudentAttendance.getSelectionModel().getSelectedItem().getIdStu())
                .get().getFirstName());
        TbMiddleName.setText(StudentRepo.findById(TV2StudentAttendance.getSelectionModel().getSelectedItem().getIdStu())
                .get().getMiddleName());
        TbLastName.setText(StudentRepo.findById(TV2StudentAttendance.getSelectionModel().getSelectedItem().getIdStu())
                .get().getLastName());

        TbGrade1Term1.setText(String.valueOf(TV2StudentAttendance.getSelectionModel().getSelectedItem().getYear1Term1())
                == "null" ? "0" : String.valueOf(TV2StudentAttendance.getSelectionModel().getSelectedItem().getYear1Term1()));
        TbGrade1Term2.setText(String.valueOf(TV2StudentAttendance.getSelectionModel().getSelectedItem().getYear1Term2())
                == "null" ? "0" : String.valueOf(TV2StudentAttendance.getSelectionModel().getSelectedItem().getYear1Term2()));
        TbGrade1Term3.setText(String.valueOf(TV2StudentAttendance.getSelectionModel().getSelectedItem().getYear1Term3())
                == "null" ? "0" : String.valueOf(TV2StudentAttendance.getSelectionModel().getSelectedItem().getYear1Term3()));
        TbGrade2Term1.setText(String.valueOf(TV2StudentAttendance.getSelectionModel().getSelectedItem().getYear2Term1())
                == "null" ? "0" : String.valueOf(TV2StudentAttendance.getSelectionModel().getSelectedItem().getYear2Term1()));
        TbGrade2Term2.setText(String.valueOf(TV2StudentAttendance.getSelectionModel().getSelectedItem().getYear2Term2())
                == "null" ? "0" : String.valueOf(TV2StudentAttendance.getSelectionModel().getSelectedItem().getYear2Term2()));
        TbGrade2Term3.setText(String.valueOf(TV2StudentAttendance.getSelectionModel().getSelectedItem().getYear2Term3())
                == "null" ? "0" : String.valueOf(TV2StudentAttendance.getSelectionModel().getSelectedItem().getYear2Term3()));
        TbGrade3Term1.setText(String.valueOf(TV2StudentAttendance.getSelectionModel().getSelectedItem().getYear3Term1())
                == "null" ? "0" : String.valueOf(TV2StudentAttendance.getSelectionModel().getSelectedItem().getYear3Term1()));
        TbGrade3Term2.setText(String.valueOf(TV2StudentAttendance.getSelectionModel().getSelectedItem().getYear3Term2())
                == "null" ? "0" : String.valueOf(TV2StudentAttendance.getSelectionModel().getSelectedItem().getYear3Term2()));
        TbGrade3Term3.setText(String.valueOf(TV2StudentAttendance.getSelectionModel().getSelectedItem().getYear3Term3())
                == "null" ? "0" : String.valueOf(TV2StudentAttendance.getSelectionModel().getSelectedItem().getYear3Term3()));
        TbGrade4Term1.setText(String.valueOf(TV2StudentAttendance.getSelectionModel().getSelectedItem().getYear4Term1())
                == "null" ? "0" : String.valueOf(TV2StudentAttendance.getSelectionModel().getSelectedItem().getYear4Term1()));
        TbGrade4Term2.setText(String.valueOf(TV2StudentAttendance.getSelectionModel().getSelectedItem().getYear4Term2())
                == "null" ? "0" : String.valueOf(TV2StudentAttendance.getSelectionModel().getSelectedItem().getYear4Term2()));
        TbGrade4Term3.setText(String.valueOf(TV2StudentAttendance.getSelectionModel().getSelectedItem().getYear4Term3())
                == "null" ? "0" : String.valueOf(TV2StudentAttendance.getSelectionModel().getSelectedItem().getYear4Term3()));
        TbGrade5Term1.setText(String.valueOf(TV2StudentAttendance.getSelectionModel().getSelectedItem().getYear5Term1())
                == "null" ? "0" : String.valueOf(TV2StudentAttendance.getSelectionModel().getSelectedItem().getYear5Term1()));
        TbGrade5Term2.setText(String.valueOf(TV2StudentAttendance.getSelectionModel().getSelectedItem().getYear5Term2())
                == "null" ? "0" : String.valueOf(TV2StudentAttendance.getSelectionModel().getSelectedItem().getYear5Term2()));
        TbGrade5Term3.setText(String.valueOf(TV2StudentAttendance.getSelectionModel().getSelectedItem().getYear5Term3())
                == "null" ? "0" : String.valueOf(TV2StudentAttendance.getSelectionModel().getSelectedItem().getYear5Term3()));
        TbGrade6Term1.setText(String.valueOf(TV2StudentAttendance.getSelectionModel().getSelectedItem().getYear6Term1())
                == "null" ? "0" : String.valueOf(TV2StudentAttendance.getSelectionModel().getSelectedItem().getYear6Term1()));
        TbGrade6Term2.setText(String.valueOf(TV2StudentAttendance.getSelectionModel().getSelectedItem().getYear6Term2())
                == "null" ? "0" : String.valueOf(TV2StudentAttendance.getSelectionModel().getSelectedItem().getYear6Term2()));
        TbGrade6Term3.setText(String.valueOf(TV2StudentAttendance.getSelectionModel().getSelectedItem().getYear6Term3())
                == "null" ? "0" : String.valueOf(TV2StudentAttendance.getSelectionModel().getSelectedItem().getYear6Term3()));
        LoadAttendanceProfileImage();
    }

    private void LoadAttendanceProfileImage() {
        byte[] imageBytes=Base64.getDecoder().decode(
                StudentRepo.findById(TV2StudentAttendance.getSelectionModel().getSelectedItem().getIdStu())
                        .get().getPhoto()
                        .replace("data:image/png;base64,","")
        );
        ByteArrayInputStream ByteImage = new ByteArrayInputStream(imageBytes);
        ProfilePicture.setImage(new Image(ByteImage));
    }

    private void LoadStudentTable(){
        ArrayList<Student> Students = (ArrayList<Student>) StudentRepo.findAll();
        ColID.setCellValueFactory(new PropertyValueFactory<>("Id"));
        ColFirstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        ColMiddleName.setCellValueFactory(new PropertyValueFactory<>("MiddleName"));
        ColLastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        if(SList.isEmpty())
            SList.addAll(Students);
        TVStudentList.getColumns().addAll(ColID,ColFirstName,ColMiddleName,ColLastName);
        TVStudentList.setItems(SList);
    }

    private void LoadAttendanceTable(){
        TableColumn<Attendance, Integer> ColStudId = new TableColumn<>("Student Id");
        ColStudId.setCellValueFactory(new PropertyValueFactory<>("idStu"));

        ArrayList<Attendance> Attendances = (ArrayList<Attendance>) AttendanceRepo.findAll();
        TV2StudentAttendance.getColumns().add(ColStudId);
        if(!Attendances.isEmpty()) {
            if(AList.isEmpty())
                AList.addAll(Attendances);
            TV2StudentAttendance.setItems( AList);
        }
    }

    private void LoadSelectedContentInForm(){
        TbId.setText(String.valueOf(TVStudentList.getSelectionModel().getSelectedItem().getId()));
        TbFirstName.setText(TVStudentList.getSelectionModel().getSelectedItem().getFirstName());
        TbMiddleName.setText(TVStudentList.getSelectionModel().getSelectedItem().getMiddleName());
        TbLastName.setText(TVStudentList.getSelectionModel().getSelectedItem().getLastName());

        TbGrade1Term1.setText("");
        TbGrade1Term2.setText("");
        TbGrade1Term3.setText("");
        TbGrade2Term1.setText("");
        TbGrade2Term2.setText("");
        TbGrade2Term3.setText("");
        TbGrade3Term1.setText("");
        TbGrade3Term2.setText("");
        TbGrade3Term3.setText("");
        TbGrade4Term1.setText("");
        TbGrade4Term2.setText("");
        TbGrade4Term3.setText("");
        TbGrade5Term1.setText("");
        TbGrade5Term2.setText("");
        TbGrade5Term3.setText("");
        TbGrade6Term1.setText("");
        TbGrade6Term2.setText("");
        TbGrade6Term3.setText("");
        LoadProfileImage();

    }


    private void LoadProfileImage() throws IllegalArgumentException{
        byte[] imageBytes=Base64.getDecoder().decode(
                TVStudentList.getSelectionModel().getSelectedItem().getPhoto()
                        .replace("data:image/png;base64,","")
        );
        ByteArrayInputStream ByteImage = new ByteArrayInputStream(imageBytes);
        ProfilePicture.setImage(new Image(ByteImage));
    }



}
