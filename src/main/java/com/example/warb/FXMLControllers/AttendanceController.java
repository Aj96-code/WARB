package com.example.warb.FXMLControllers;

import com.example.warb.JPAEntities.Attendance;
import com.example.warb.JPAEntities.Student;
import com.example.warb.Repositories.AttendanceRepository;
import com.example.warb.Repositories.StudentRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private AttendanceRepository AttendaceRepo;
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
    @FXML TableView<Attendance> TVStudentAttendance;

    @FXML TableColumn<Attendance,Integer> Yr1_Term1;
    @FXML TableColumn<Attendance,Integer>  Yr1_Term2;
    @FXML TableColumn<Attendance,Integer>  Yr1_Term3;
    @FXML TableColumn<Attendance,Integer>  Yr2_Term1;
    @FXML TableColumn<Attendance,Integer>  Yr2_Term2;
    @FXML TableColumn<Attendance,Integer>  Yr2_Term3;
    @FXML TableColumn<Attendance,Integer>  Yr3_Term1;
    @FXML TableColumn<Attendance,Integer>  Yr3_Term2;
    @FXML TableColumn<Attendance,Integer>  Yr3_Term3;
    @FXML TableColumn<Attendance,Integer> Yr4_Term1;
    @FXML TableColumn<Attendance,Integer>  Yr4_Term2;
    @FXML TableColumn<Attendance,Integer>  Yr4_Term3;
    @FXML TableColumn<Attendance,Integer>  Yr5_Term1;
    @FXML TableColumn<Attendance,Integer>  Yr5_Term2;
    @FXML TableColumn<Attendance,Integer>  Yr5_Term3;
    @FXML TableColumn<Attendance,Integer>  Yr6_Term1;
    @FXML TableColumn<Attendance,Integer>  Yr6_Term2;
    @FXML TableColumn<Attendance,Integer>  Yr6_Term3;
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
    Alert Dialog;

    @FXML
    public void BtnSave_Click(ActionEvent event){
       //TODO: Make Save Functions
        if(TbId.getText() !="") {
            SaveAttendanceToDataBase();

        } else {
            Dialog = new Alert(Alert.AlertType.WARNING);
            Dialog.setTitle("Selection Warning");
            Dialog.setHeaderText(null);
            Dialog.setContentText("Please Select Student from the table");
            Dialog.showAndWait();
        }

    }

    private void SaveAttendanceToDataBase() {
        if(TbGrade1Term1.getText() != ""|| TbGrade1Term2.getText() != ""
        ||TbGrade1Term3.getText() != "" || TbGrade2Term1.getText() != ""
        ||TbGrade2Term2.getText() != "" || TbGrade2Term3.getText() != ""
        ||TbGrade3Term1.getText() != "" || TbGrade3Term2.getText() != ""
        ||TbGrade3Term3.getText() != "" || TbGrade4Term1.getText() != ""
        ||TbGrade4Term2.getText() != "" || TbGrade4Term3.getText() != ""
        ||TbGrade5Term1.getText() != "" || TbGrade5Term2.getText() != ""
        ||TbGrade5Term3.getText() != "" || TbGrade6Term1.getText() != ""
        ||TbGrade6Term2.getText() != "" || TbGrade6Term3.getText() != "") {
            Attendance NewAttendance = new Attendance();
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
                NewAttendance.setIdStu1(StudentRepo.findById(Integer.parseInt(TbId.getId())).get().getId());
            } catch (IllegalArgumentException IEX){
                System.out.println("Empty String ");
            }


            AttendaceRepo.saveAndFlush(NewAttendance);
            Dialog = new Alert(Alert.AlertType.INFORMATION);
            Dialog.setTitle("Save Dialog");
            Dialog.setHeaderText(null);
            Dialog.setContentText("Student Attendance Saved");
            Dialog.showAndWait();
        } else {
            Dialog = new Alert(Alert.AlertType.WARNING);
            Dialog.setTitle("Selection Warning");
            Dialog.setHeaderText(null);
            Dialog.setContentText("Please Select Student from the table");
            Dialog.showAndWait();
        }

    }

    @FXML
    public void BtnUpdate_Click(ActionEvent event){
        //TODO: Make Update Functions
        if(AttendaceRepo.findById(Integer.parseInt(TbId.getText())).isEmpty()){
            Dialog = new Alert(Alert.AlertType.WARNING);
            Dialog.setTitle("No Record Dialog");
            Dialog.setHeaderText(null);
            Dialog.setContentText("No Record Found");
            Dialog.showAndWait();
        }
        else {
            Dialog = new Alert(Alert.AlertType.INFORMATION);
            Dialog.setTitle("Update Dialog");
            Dialog.setHeaderText(null);
            Dialog.setContentText("Student Attendance Update");
            Dialog.showAndWait();
        }

    }
    @FXML
    public void BtnDelete_Click(ActionEvent event){
        //TODO: Make Delete Functions
        Dialog = new Alert(Alert.AlertType.CONFIRMATION);
        Dialog.setTitle("Delete Dialog");
        Dialog.setHeaderText(null);
        Dialog.setContentText("Are you want to Delete");
        Dialog.showAndWait();
    }

    @FXML
    public void initialize(){

        LoadStudentTable();

        TVStudentList.setOnMouseClicked(e -> {
            if(e.getClickCount() > 0){
               LoadSelectedContentInForm();
            }
        });


    }

    private void LoadStudentTable(){
        ArrayList<Student> Students = (ArrayList<Student>) StudentRepo.findAll();
        ColID.setCellValueFactory(new PropertyValueFactory<>("Id"));
        ColFirstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        ColMiddleName.setCellValueFactory(new PropertyValueFactory<>("MiddleName"));
        ColLastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        SList.addAll(Students);
        TVStudentList.getColumns().addAll(ColID,ColFirstName,ColMiddleName,ColLastName);
        TVStudentList.setItems(SList);
    }

    private void LoadSelectedContentInForm(){
        TbId.setText(String.valueOf(TVStudentList.getSelectionModel().getSelectedItem().getId()));
        TbFirstName.setText(TVStudentList.getSelectionModel().getSelectedItem().getFirstName());
        TbMiddleName.setText(TVStudentList.getSelectionModel().getSelectedItem().getMiddleName());
        TbLastName.setText(TVStudentList.getSelectionModel().getSelectedItem().getLastName());
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
