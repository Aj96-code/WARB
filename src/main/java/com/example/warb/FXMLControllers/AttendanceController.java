package com.example.warb.FXMLControllers;

import com.example.warb.JPAEntities.Attendance;
import com.example.warb.JPAEntities.Student;
import com.example.warb.Repositories.AttendanceRepository;
import com.example.warb.Repositories.StudentRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.controlsfx.control.tableview2.TableView2;
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
    private TextField TbGrade1Term1, TbGrade1Term2, TbGrade1Term3;
    @FXML
    private TextField TbGrade2Term1, TbGrade2Term2, TbGrade2Term3;
    @FXML
    private TextField TbGrade3Term1, TbGrade3Term2, TbGrade3Term3;
    @FXML
    private TextField TbGrade4Term1, TbGrade4Term2, TbGrade4Term3;
    @FXML
    private TextField TbGrade5Term1, TbGrade5Term2, TbGrade5Term3;
    @FXML
    private TextField TbGrade6Term1, TbGrade6Term2, TbGrade6Term3;
    @FXML
    private TableView<Student> StudentTable;
    @FXML
    private TextField TbId, TbFirstName, TbMiddleName, TbLastName;

    @FXML
    private TableView2<Attendance> AttendanceTable;

    private TextField[] AttendanceTextFields = new TextField[18];
    private final TableColumn<Student, String> ColFirstName =
            new TableColumn<>("First Name");
    private final TableColumn<Student, String> ColLastName =
            new TableColumn<>("Last Name");
    private final TableColumn<Student, String> ColMiddleName =
            new TableColumn<>("Middle Name");
    private final TableColumn<Student, Integer> ColID =
            new TableColumn<>("Student Id");
    @FXML
    private ImageView ProfilePicture;
    ObservableList<Student> StudentList = FXCollections.observableArrayList();
    ObservableList<Attendance> AttendanceList = FXCollections.observableArrayList();
    Alert Dialog;

    @FXML
    public void btnSaveClick(ActionEvent event) {
        if (TbId.getText() != "") {
            saveAttendanceToDataBase();
        } else {
            Dialog = new Alert(Alert.AlertType.WARNING);
            Dialog.setTitle("Selection Warning");
            Dialog.setHeaderText("Save");
            Dialog.setContentText("Please Select Student from the table");
            Dialog.showAndWait();
        }
    }


    private ObservableList<Student> getListOfStudents() {
        return StudentList = FXCollections.observableArrayList(StudentRepo.findAll());
    }

    private ObservableList<Attendance> getListOfAttendance() {
        return AttendanceList = FXCollections.observableArrayList(AttendanceRepo.findAll());
    }

    private  Student getStudentById(int Id) {
        return StudentRepo.findById(Id).get();
    }

    private TextField  [] getAttendanceTextFields() {
        TextField[] TbArray = new TextField[18];
        TbArray[0] = TbGrade1Term1; TbArray[1] = TbGrade1Term2;TbArray[2] = TbGrade1Term3;
        TbArray[3] = TbGrade2Term1; TbArray[4] = TbGrade2Term2;TbArray[5] = TbGrade2Term3;
        TbArray[6] = TbGrade3Term1; TbArray[7] = TbGrade3Term2;TbArray[8] = TbGrade3Term3;
        TbArray[9] = TbGrade4Term1; TbArray[10] = TbGrade4Term2;TbArray[11] = TbGrade4Term3;
        TbArray[12] = TbGrade5Term1; TbArray[13] = TbGrade5Term2;TbArray[14] = TbGrade5Term3;
        TbArray[15] = TbGrade6Term1; TbArray[16] = TbGrade6Term2;TbArray[17] = TbGrade6Term3;
        return TbArray;
    }

    private void clearAttendanceTextField() {
        try {
            for (TextField Field : AttendanceTextFields) {
                if (Field.getText() != null)
                    Field.setText("");
            }
        } catch (NullPointerException NE) {
        }

    }

    @Autowired
    Attendance NewAttendance;
    public boolean validateForm() {
        return TbGrade1Term1.getText() != "" || TbGrade1Term2.getText() != ""
                || TbGrade1Term3.getText() != "" || TbGrade2Term1.getText() != ""
                || TbGrade2Term2.getText() != "" || TbGrade2Term3.getText() != ""
                || TbGrade3Term1.getText() != "" || TbGrade3Term2.getText() != ""
                || TbGrade3Term3.getText() != "" || TbGrade4Term1.getText() != ""
                || TbGrade4Term2.getText() != "" || TbGrade4Term3.getText() != ""
                || TbGrade5Term1.getText() != "" || TbGrade5Term2.getText() != ""
                || TbGrade5Term3.getText() != "" || TbGrade6Term1.getText() != ""
                || TbGrade6Term2.getText() != "" || TbGrade6Term3.getText() != "";
    }

    private void setAlert(Alert alert, String title,String message, String header){
        Dialog = alert;
        Dialog.setTitle(title);
        Dialog.setHeaderText(header);
        Dialog.setContentText(message);
    }

    private void saveAttendanceToDataBase() {

        int Stud_Id = getStudentById(Integer.parseInt(TbId.getText())).getId();
        System.out.println(Stud_Id);
        boolean IsFound = false;
        ObservableList<Attendance> AttendanceList = getListOfAttendance();
        try {
            for (Attendance Item : AttendanceList) {
                if (Item.getIdStu() == Stud_Id) {
                    IsFound = true;
                    break;
                }
            }
        } catch (Exception EXC) {
        }

        if (IsFound) {
            setAlert(new Alert(Alert.AlertType.WARNING), "Not Saved",
                    "Student Attendance is already recorded", "Save Dialog");
            Dialog.showAndWait();
        } else if (validateForm()) {


            if (Stud_Id != 0) {

                NewAttendance.setIdStu(Stud_Id);
                NewAttendance.setYear1Term1(Integer.parseInt(TbGrade1Term1.getText() == "" ? "0"
                        : TbGrade1Term1.getText()));
                NewAttendance.setYear1Term2(Integer.parseInt(TbGrade1Term2.getText() == "" ? "0"
                        : TbGrade1Term2.getText()));
                NewAttendance.setYear1Term3(Integer.parseInt(TbGrade1Term3.getText() == "" ? "0"
                        : TbGrade1Term3.getText()));
                NewAttendance.setYear2Term1(Integer.parseInt(TbGrade2Term1.getText() == "" ? "0"
                        : TbGrade2Term1.getText()));
                NewAttendance.setYear2Term2(Integer.parseInt(TbGrade2Term2.getText() == "" ? "0"
                        : TbGrade2Term2.getText()));
                NewAttendance.setYear2Term3(Integer.parseInt(TbGrade2Term3.getText() == "" ? "0"
                        : TbGrade2Term3.getText()));
                NewAttendance.setYear3Term1(Integer.parseInt(TbGrade3Term1.getText() == "" ? "0"
                        : TbGrade3Term1.getText()));
                NewAttendance.setYear3Term2(Integer.parseInt(TbGrade3Term2.getText() == "" ? "0"
                        : TbGrade3Term2.getText()));
                NewAttendance.setYear3Term3(Integer.parseInt(TbGrade3Term3.getText() == "" ? "0"
                        : TbGrade3Term3.getText()));
                NewAttendance.setYear4Term1(Integer.parseInt(TbGrade4Term1.getText() == "" ? "0"
                        : TbGrade4Term1.getText()));
                NewAttendance.setYear4Term2(Integer.parseInt(TbGrade4Term2.getText() == "" ? "0"
                        : TbGrade4Term2.getText()));
                NewAttendance.setYear4Term3(Integer.parseInt(TbGrade4Term3.getText() == "" ? "0"
                        : TbGrade4Term3.getText()));
                NewAttendance.setYear5Term1(Integer.parseInt(TbGrade5Term1.getText() == "" ? "0"
                        : TbGrade5Term1.getText()));
                NewAttendance.setYear5Term2(Integer.parseInt(TbGrade5Term2.getText() == "" ? "0"
                        : TbGrade5Term2.getText()));
                NewAttendance.setYear5Term3(Integer.parseInt(TbGrade5Term3.getText() == "" ? "0"
                        : TbGrade5Term3.getText()));
                NewAttendance.setYear6Term1(Integer.parseInt(TbGrade6Term1.getText() == "" ? "0"
                        : TbGrade6Term1.getText()));
                NewAttendance.setYear6Term2(Integer.parseInt(TbGrade6Term2.getText() == "" ? "0"
                        : TbGrade6Term2.getText()));
                NewAttendance.setYear6Term3(Integer.parseInt(TbGrade6Term3.getText() == "" ? "0" : TbGrade6Term3.getText()));


                AttendanceRepo.saveAndFlush(NewAttendance);
                setAlert(new Alert(Alert.AlertType.INFORMATION), "Saved",
                        "Student Attendance is recorded", "Save Dialog");
                Dialog.showAndWait();
                AttendanceTable.getColumns().clear();
                AttendanceTable.getItems().clear();
                NewAttendance = new Attendance();
                loadAttendanceTable();

            } else {
                setAlert(new Alert(Alert.AlertType.ERROR), "Save Error",
                        "Student Attendance could not be recorded", "Save Dialog");
                Dialog.showAndWait();
            }

        } else {
            setAlert(new Alert(Alert.AlertType.WARNING), "No information in Field",
                    "Enter the atudent's attendance record", "Save Dialog");
            Dialog.showAndWait();
        }

    }

    @FXML
    public void btnUpdate_Click(ActionEvent event) {

        boolean IsFound = false;
        ObservableList<Attendance> AttendanceList = getListOfAttendance();
        for (Attendance Item : AttendanceList) {
            if (Item.getIdStu() ==
                    AttendanceTable.getSelectionModel().getSelectedItem().getIdStu()) {
                IsFound = true;
                break;
            }
        }
        if (!IsFound) {
            setAlert(new Alert(Alert.AlertType.WARNING), "No Record",
                    "Student's Attendance record is not found ", "Update Dialog");
            Dialog.showAndWait();
        } else {
            try {
                AttendanceTable.getSelectionModel().getSelectedItem().setYear1Term1(Integer.parseInt(TbGrade1Term1.getText()));
                AttendanceTable.getSelectionModel().getSelectedItem().setYear1Term2(Integer.parseInt(TbGrade1Term2.getText()));
                AttendanceTable.getSelectionModel().getSelectedItem().setYear1Term3(Integer.parseInt(TbGrade1Term3.getText()));
                AttendanceTable.getSelectionModel().getSelectedItem().setYear2Term1(Integer.parseInt(TbGrade2Term1.getText()));
                AttendanceTable.getSelectionModel().getSelectedItem().setYear2Term2(Integer.parseInt(TbGrade2Term2.getText()));
                AttendanceTable.getSelectionModel().getSelectedItem().setYear2Term3(Integer.parseInt(TbGrade2Term3.getText()));
                AttendanceTable.getSelectionModel().getSelectedItem().setYear3Term1(Integer.parseInt(TbGrade3Term1.getText()));
                AttendanceTable.getSelectionModel().getSelectedItem().setYear3Term2(Integer.parseInt(TbGrade3Term2.getText()));
                AttendanceTable.getSelectionModel().getSelectedItem().setYear3Term3(Integer.parseInt(TbGrade3Term3.getText()));
                AttendanceTable.getSelectionModel().getSelectedItem().setYear4Term1(Integer.parseInt(TbGrade4Term1.getText()));
                AttendanceTable.getSelectionModel().getSelectedItem().setYear4Term2(Integer.parseInt(TbGrade4Term2.getText()));
                AttendanceTable.getSelectionModel().getSelectedItem().setYear4Term3(Integer.parseInt(TbGrade4Term3.getText()));
                AttendanceTable.getSelectionModel().getSelectedItem().setYear5Term1(Integer.parseInt(TbGrade5Term1.getText()));
                AttendanceTable.getSelectionModel().getSelectedItem().setYear5Term2(Integer.parseInt(TbGrade5Term2.getText()));
                AttendanceTable.getSelectionModel().getSelectedItem().setYear5Term3(Integer.parseInt(TbGrade5Term3.getText()));
                AttendanceTable.getSelectionModel().getSelectedItem().setYear6Term1(Integer.parseInt(TbGrade6Term1.getText()));
                AttendanceTable.getSelectionModel().getSelectedItem().setYear6Term2(Integer.parseInt(TbGrade6Term2.getText()));
                AttendanceTable.getSelectionModel().getSelectedItem().setYear6Term3(Integer.parseInt(TbGrade6Term3.getText()));
            } catch (IllegalArgumentException IEX) {
                System.out.println("Empty String ");
            }
            AttendanceRepo.save(AttendanceTable.getSelectionModel().getSelectedItem());
            setAlert(new Alert(Alert.AlertType.INFORMATION), "Update",
                    "Student's Attendance record is updated ", "Update Dialog");
            Dialog.showAndWait();
            AttendanceTable.getColumns().clear();
            AttendanceTable.getItems().clear();
            loadAttendanceTable();
        }

    }

    @FXML
    public void btnDeleteClick(ActionEvent event) {
        boolean IsFound = false;
        ObservableList<Attendance> AttendanceList = getListOfAttendance();
        for (Attendance Item : AttendanceList) {
            if (Item.getIdStu() == AttendanceTable.getSelectionModel().getSelectedItem().getIdStu()) {
                IsFound = true;
                break;
            }
        }
        if (IsFound) {
            setAlert(new Alert(Alert.AlertType.CONFIRMATION), "Delete",
                    "Are you sure?", "Delete Dialog");
            Optional<ButtonType> Result = Dialog.showAndWait();
            if (Result.get() == ButtonType.OK) {
                AttendanceRepo.delete(AttendanceTable.getSelectionModel().getSelectedItem());
                AttendanceRepo.flush();
                Dialog.close();
                AttendanceTable.getColumns().clear();
                AttendanceTable.getItems().clear();
                loadAttendanceTable();
            } else if (Result.get() == ButtonType.CANCEL) {
                Dialog.close();
            }
        }

    }

    @FXML
    public void initialize() {
        loadStudentTable();
        loadAttendanceTable();

        StudentTable.setOnMouseClicked(e -> {
            if (e.getClickCount() > 0) {
                loadSelectedContentInForm();
            }
        });
        AttendanceTable.setOnMouseClicked(e -> {
            if (e.getClickCount() > 0) {
                loadSelectedContentInFormAttendance();
            }
        });


    }

    private void loadSelectedContentInFormAttendance() {

        Attendance SelectedObject = AttendanceRepo.findById(
                AttendanceTable.getSelectionModel().getSelectedItem().getId()).get();
        AttendanceTextFields = getAttendanceTextFields();
        loadStudentInformation(SelectedObject);

        int[] TermValues = {
                SelectedObject.getYear1Term1() == null ? 0 : SelectedObject.getYear1Term1(),
                SelectedObject.getYear1Term2() == null ? 0 : SelectedObject.getYear1Term2(),
                SelectedObject.getYear1Term3() == null ? 0 : SelectedObject.getYear1Term3(),
                SelectedObject.getYear2Term1() == null ? 0 : SelectedObject.getYear2Term1(),
                SelectedObject.getYear2Term2() == null ? 0 : SelectedObject.getYear2Term2(),
                SelectedObject.getYear2Term3() == null ? 0 : SelectedObject.getYear2Term3(),
                SelectedObject.getYear3Term1() == null ? 0 : SelectedObject.getYear3Term1(),
                SelectedObject.getYear3Term2() == null ? 0 : SelectedObject.getYear3Term2(),
                SelectedObject.getYear3Term3() == null ? 0 : SelectedObject.getYear3Term3(),
                SelectedObject.getYear4Term1() == null ? 0 : SelectedObject.getYear4Term1(),
                SelectedObject.getYear4Term2() == null ? 0 : SelectedObject.getYear4Term2(),
                SelectedObject.getYear4Term3() == null ? 0 : SelectedObject.getYear4Term3(),
                SelectedObject.getYear5Term1() == null ? 0 : SelectedObject.getYear5Term1(),
                SelectedObject.getYear5Term2() == null ? 0 : SelectedObject.getYear5Term2(),
                SelectedObject.getYear5Term3() == null ? 0 : SelectedObject.getYear5Term3(),
                SelectedObject.getYear6Term1() == null ? 0 : SelectedObject.getYear6Term1(),
                SelectedObject.getYear6Term2() == null ? 0 : SelectedObject.getYear6Term2(),
                SelectedObject.getYear6Term3() == null ? 0 : SelectedObject.getYear6Term3(),
        };

        for (int i = 0; i < TermValues.length; i++) {
            AttendanceTextFields[i].setText(String.valueOf(TermValues[i]));
        }
        loadAttendanceProfileImage();
    }

    private void loadStudentInformation( Attendance SelectedObject) {
        TbId.setText(String.valueOf(SelectedObject.getIdStu()));
        TbFirstName.setText(StudentRepo.findById(SelectedObject.getIdStu()).get().getFirstName());
        TbMiddleName.setText(StudentRepo.findById(SelectedObject.getIdStu()).get().getMiddleName());
        TbLastName.setText(StudentRepo.findById(SelectedObject.getIdStu()).get().getLastName());
    }


    private void loadStudentInformation( Student SelectObject) {
        TbId.setText(String.valueOf(SelectObject.getId()));
        TbFirstName.setText(SelectObject.getFirstName());
        TbMiddleName.setText(SelectObject.getMiddleName());
        TbLastName.setText(SelectObject.getLastName());
    }

    private void loadAttendanceProfileImage() {
        try {
            byte[] imageBytes = Base64.getDecoder().decode(
                    StudentRepo.findById(AttendanceTable.getSelectionModel().getSelectedItem().getIdStu())
                            .get().getPhoto()
                            .replace("data:image/png;base64,", "")
            );
            ByteArrayInputStream ByteImage = new ByteArrayInputStream(imageBytes);
            ProfilePicture.setImage(new Image(ByteImage));
        } catch (Exception E) {
            System.out.println("No Profile Image Found");
        }
    }

    private void loadStudentTable() {
        ArrayList<Student> Students = (ArrayList<Student>) StudentRepo.findAll();
        setCellValueFactoryForStudentTableColumn();
        StudentTable.getColumns().addAll(ColID, ColFirstName, ColMiddleName, ColLastName);
        StudentTable.setItems(getListOfStudents());
    }

    private void setCellValueFactoryForStudentTableColumn() {
        ColID.setCellValueFactory(new PropertyValueFactory<>("Id"));
        ColFirstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        ColMiddleName.setCellValueFactory(new PropertyValueFactory<>("MiddleName"));
        ColLastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
    }

    private void loadAttendanceTable() {
        TableColumn<Attendance, Integer> ColStudId = setCellValueFactoryForAttendanceTableColumn();
        AttendanceTable.getColumns().add(ColStudId);
        if (!getListOfAttendance().isEmpty()) {
            AttendanceTable.setItems(AttendanceList);
        }
    }

    private  TableColumn setCellValueFactoryForAttendanceTableColumn() {
        TableColumn<Attendance, Integer> ColStudId = new TableColumn<>("Student Id");
        ColStudId.setCellValueFactory(new PropertyValueFactory<>("idStu"));
        return ColStudId;
    }

    private void loadSelectedContentInForm() {
        clearAttendanceTextField();
        loadStudentInformation(StudentTable.getSelectionModel().getSelectedItem());
        loadProfileImage();
    }


    private void loadProfileImage() throws IllegalArgumentException {
        try {
            byte[] imageBytes = Base64.getDecoder().decode(
                    StudentTable.getSelectionModel().getSelectedItem().getPhoto()
                            .replace("data:image/png;base64,", "")
            );
            ByteArrayInputStream ByteImage = new ByteArrayInputStream(imageBytes);
            ProfilePicture.setImage(new Image(ByteImage));
        } catch (Exception E) {
            System.out.println("No Profile Image Found");
        }
    }

}
