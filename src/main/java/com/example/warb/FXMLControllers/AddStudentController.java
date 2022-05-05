package com.example.warb.FXMLControllers;


import com.example.warb.JPAEntities.Student;
import com.example.warb.Repositories.StudentRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Optional;



public class AddStudentController {

    @FXML
    public Button btnAddStudent;
    @FXML
    public Button updateProfilePicture;
    @FXML public TextField txtId;
    @FXML public TextField txtFirstName;
    @FXML public TextField txtMiddleName;
    @FXML public TextField txtLastName;
    @FXML  public TextField txtBirthCertNumber;
    @FXML public DatePicker txtDOB;
    @FXML public DatePicker txtDateReg;
    @FXML public ComboBox txtSportsHouse;
    @FXML public TextField txtClub;
    @FXML  public ComboBox txtGender;
    @FXML public TextField txtStudentAddress;
    @FXML public TextField txtMotherName;
    @FXML public TextField txtMotherOccupation;
    @FXML public TextField txtMotherTelephone;
    @FXML public TextField txtFatherName;
    @FXML public TextField txtFatherTelephone;
    @FXML public TextField txtFatherAddress;
    @FXML public TextField txtGuardianName;
    @FXML public TextField txtGuardOccupation;
    @FXML public TextField txtGuardianAddress;
    @FXML public TextField txtGuardianTelephone;
    @FXML public ImageView ProfilePicture;
    @FXML
    public Label ern;
    @FXML
    public Button btnUpdateProfilePicture;
    @FXML
    public Button btnClear;
    public void initialize() {
        try {
            loadProfileImage();
            loadStudentTable();
            updateComboBox();
            StudentTable.setOnMouseClicked(e -> {
                if (e.getClickCount() > 0) {
                    loadSelectedItemInFields();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            Dialog = new Alert(Alert.AlertType.WARNING);
            Dialog.setTitle("Error Warning");
            Dialog.setHeaderText("Error");
            Dialog.setContentText("An Error occurred please try again");
            Dialog.showAndWait();
        }
    }

    @FXML
    private void loadProfileImage() throws IllegalArgumentException {
        File file = new File("src/icons8-user-80.png");
        Image image = new Image(file.toURI().toString());
        ProfilePicture.setImage(image);
    }


    @FXML
    private void onBtnUpdateProfilePicture(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Profile Picture");
        File file =fileChooser.showOpenDialog(null);
        if( file != null){
            Image image = new Image(file.getPath());
            ProfilePicture.setImage(image);
        }


    }


    public boolean validateForm() {
        return !txtId.getText().equals("") || txtFirstName.getText().equals("")
                ||!txtMiddleName.getText().equals("") ||!txtLastName.getText().equals("")
                ||!txtBirthCertNumber.getText().equals("") ||!txtSportsHouse.getValue().equals("")
                ||!txtClub.getText().equals("") ||!txtGender.getValue().equals("")
                ||!txtStudentAddress.getText().equals("") ||!txtMotherName.getText().equals("")
                ||!txtMotherOccupation.getText().equals("") ||!txtMotherTelephone.getText().equals("")
                ||!txtFatherName.getText().equals("") ||!txtFatherTelephone.getText().equals("")
                ||!txtFatherAddress.getText().equals("") ||!txtGuardianName.getText().equals("")
                ||!txtGuardOccupation.getText().equals("") ||!txtGuardianAddress.getText().equals("")
                ||!txtGuardianTelephone.getText().equals("");
    }

    public void updateComboBox() {
        ObservableList<String> data1 = FXCollections.observableArrayList("male", "female", "other");
        ObservableList<String> data2 = FXCollections.observableArrayList("Blue", "Red", "Purple", "Green");
        txtGender.setItems(data1);

        txtSportsHouse.setItems(data2);
    }

    @Autowired
    Student NewStudent;
    ObservableList<Student> StudentList = FXCollections.observableArrayList();
    @Autowired
    private StudentRepository StudentRepo;

    private Student getStudentById(int Id) {
        return StudentRepo.findById(Id).get();
    }

    private ObservableList<Student> getListOfStudents() {
        return StudentList = FXCollections.observableArrayList(StudentRepo.findAll());

    }

    @FXML
    protected void clearFields() {
        try {
            txtId.setText("");
            txtFirstName.setText("");
            txtMiddleName.setText("");
            txtLastName.setText("");
            txtBirthCertNumber.setText("");
            txtBirthCertNumber.setText("");
            txtDOB.getEditor().clear();
            txtDateReg.getEditor().clear();
            txtSportsHouse.setValue("");
            txtClub.setText("");
            txtGender.setValue("");
            txtStudentAddress.setText("");
            txtMotherName.setText("");
            txtMotherOccupation.setText("");
            txtMotherTelephone.setText("");
            txtFatherTelephone.setText("");
            txtFatherName.setText("");
            txtFatherAddress.setText("");
            txtGuardianName.setText("");
            txtGuardianAddress.setText("");
            txtGuardOccupation.setText("");
            txtGuardianTelephone.setText("");
            File file = new File("src/icons8-user-80.png");
            Image image = new Image(file.toURI().toString());
            ProfilePicture.setImage(image);
            StudentTable.getSelectionModel().clearSelection();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    Alert Dialog;
    @FXML
    private TableView<Student> StudentTable;
    private final TableColumn<Student, String> ColFirstName =
            new TableColumn<>("First Name");
    private final TableColumn<Student, String> ColLastName =
            new TableColumn<>("Last Name");
    private final TableColumn<Student, String> ColMiddleName =
            new TableColumn<>("Middle Name");

    private final TableColumn<Student, Integer> ColID =
            new TableColumn<>("Student Id");
    private final TableColumn<Student, Date> ColDareReg =
            new TableColumn<>("Date Registered");
    private TableColumn<Student, Date> ColDOB =
            new TableColumn<>("Date of Birth");
    private final TableColumn<Student, String> ColBirthCertNum =
            new TableColumn<>("Birth Certificate Number");


    private final TableColumn<Student, String> ColSportsHouse =
            new TableColumn<>("Sports House");

    private final TableColumn<Student, String> ColClub =
            new TableColumn<>("Club");

    private final TableColumn<Student, String> ColGender =
            new TableColumn<>("Gender");

    private final TableColumn<Student, String> ColStudentAddress =
            new TableColumn<>("Student Address");

    private final TableColumn<Student, String> ColMotherName =
            new TableColumn<>("Mother Name");

    private final TableColumn<Student, String> ColMotherOccupation =
            new TableColumn<>("Mother Occupation");

    private final TableColumn<Student, String> ColMotherTele =
            new TableColumn<>("Mother Telephone ");

    private final TableColumn<Student, String> ColFatherName =
            new TableColumn<>("Father Name");

    private final TableColumn<Student, String> ColFatherTele =
            new TableColumn<>("Father Telephone");

    private final TableColumn<Student, String> ColFatherAddress =
            new TableColumn<>("Father Address");

    private final TableColumn<Student, String> ColGuardianName =
            new TableColumn<>("Guardian Name");

    private final TableColumn<Student, String> ColGuardianOccupation =
            new TableColumn<>("Guardian Occupation");

    private final TableColumn<Student, String> ColGuardianAddress =
            new TableColumn<>("Guardian Address");

    private final TableColumn<Student, String> ColGuardianTele =
            new TableColumn<>("Guardian Telephone");

    private final TableColumn<Student, String> ColId =
            new TableColumn<>("Id");

    private final TableColumn<Student, String> ColPhoto =
            new TableColumn<>("Photo");


    @FXML

    private void loadStudentTable() {
        try {
            StudentTable.getColumns().clear();
            StudentTable.getItems().clear();
            ArrayList<Student> Students = (ArrayList<Student>) StudentRepo.findAll();
            setCellValueFactoryForStudentTableColumn();
            StudentTable.getColumns().addAll(ColID, ColFirstName, ColMiddleName, ColLastName, ColBirthCertNum, ColDOB, ColDareReg, ColSportsHouse, ColClub, ColGender,
                    ColStudentAddress, ColMotherName, ColMotherOccupation, ColMotherTele, ColFatherName, ColFatherTele, ColFatherAddress,
                    ColGuardianName, ColGuardianOccupation, ColGuardianAddress, ColGuardianTele,ColPhoto);
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

    @FXML

    private void setCellValueFactoryForStudentTableColumn() {
        try {
            ColID.setCellValueFactory(new PropertyValueFactory<>("Id"));
            ColFirstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
            ColMiddleName.setCellValueFactory(new PropertyValueFactory<>("MiddleName"));
            ColLastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
            ColBirthCertNum.setCellValueFactory(new PropertyValueFactory<>("BirthCertNum"));
            ColDareReg.setCellValueFactory(new PropertyValueFactory<>("DareReg"));
            ColSportsHouse.setCellValueFactory(new PropertyValueFactory<>("SportsHouse"));
            ColClub.setCellValueFactory(new PropertyValueFactory<>("Club"));
            ColGender.setCellValueFactory(new PropertyValueFactory<>("Gender"));
            ColStudentAddress.setCellValueFactory(new PropertyValueFactory<>("StudentAddress"));
            ColDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
            ColMotherName.setCellValueFactory(new PropertyValueFactory<>("MotherName"));
            ColMotherOccupation.setCellValueFactory(new PropertyValueFactory<>("MotherOccupation"));
            ColMotherTele.setCellValueFactory(new PropertyValueFactory<>("MotherTel"));
            ColFatherName.setCellValueFactory(new PropertyValueFactory<>("FatherName"));
            ColFatherTele.setCellValueFactory(new PropertyValueFactory<>("FatherTel"));
            ColFatherAddress.setCellValueFactory(new PropertyValueFactory<>("FatherAddress"));
            ColGuardianName.setCellValueFactory(new PropertyValueFactory<>("GuardianName"));
            ColGuardianOccupation.setCellValueFactory(new PropertyValueFactory<>("GuardianOccupation"));
            ColGuardianAddress.setCellValueFactory(new PropertyValueFactory<>("GuardianAddress"));
            ColGuardianTele.setCellValueFactory(new PropertyValueFactory<>("GuardianTel"));
            ColPhoto.setCellValueFactory(new PropertyValueFactory<>("Photo"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    protected void deleteStudentRecord() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        //alert.setTitle("Confirmation");
        alert.setTitle("Delete Record Confirmation");
        alert.setContentText("Are you sure you want to Delete this record?");

        Optional<ButtonType> option = alert.showAndWait();

        if ( option.get() == ButtonType.CANCEL) {

        } else if (option.get() == ButtonType.OK) {
            try {
                if (!StudentTable.getSelectionModel().isEmpty()) {
                    StudentRepo.deleteById(StudentTable.getSelectionModel().getSelectedItem().getId());
                    loadStudentTable();
                } else {
                    Dialog = new Alert(Alert.AlertType.WARNING);
                    Dialog.setTitle("Selection Warning");
                    Dialog.setHeaderText("Delete Student");
                    Dialog.setContentText("Please Select A Student from the table to delete!");
                    Dialog.showAndWait();
                }
            } catch (Exception e) {
                Dialog = new Alert(Alert.AlertType.WARNING);
                Dialog.setTitle("Error Message");
                Dialog.setHeaderText("Error");
                Dialog.setContentText("Please try again");
                Dialog.showAndWait();

            }
        }


    }

    @FXML
    private void loadSelectedItemInFields() {

        try {
            
            txtId.setText(StudentTable.getSelectionModel().getSelectedItem().getId().toString());
            txtFirstName.setText(StudentTable.getSelectionModel().getSelectedItem().getFirstName());
            txtLastName.setText(StudentTable.getSelectionModel().getSelectedItem().getLastName());
            txtMiddleName.setText(StudentTable.getSelectionModel().getSelectedItem().getMiddleName());
            txtBirthCertNumber.setText(StudentTable.getSelectionModel().getSelectedItem().getBirthCertNum());
            txtDOB.setValue(StudentTable.getSelectionModel().getSelectedItem().getDob());
            txtDateReg.setValue(StudentTable.getSelectionModel().getSelectedItem().getDareReg());
            txtSportsHouse.setValue(StudentTable.getSelectionModel().getSelectedItem().getSportsHouse());
            txtClub.setText(StudentTable.getSelectionModel().getSelectedItem().getClub());
            txtGender.setValue(StudentTable.getSelectionModel().getSelectedItem().getGender());
            txtStudentAddress.setText(StudentTable.getSelectionModel().getSelectedItem().getStudentAddress());
            txtMotherName.setText(StudentTable.getSelectionModel().getSelectedItem().getMotherName());
            txtMotherOccupation.setText(StudentTable.getSelectionModel().getSelectedItem().getMotherOccupation());
            txtMotherTelephone.setText(StudentTable.getSelectionModel().getSelectedItem().getMotherTel());
            txtFatherName.setText(StudentTable.getSelectionModel().getSelectedItem().getFatherName());
            txtFatherTelephone.setText(StudentTable.getSelectionModel().getSelectedItem().getFatherTel());
            txtFatherAddress.setText(StudentTable.getSelectionModel().getSelectedItem().getFatherAddress());
            txtGuardianName.setText(StudentTable.getSelectionModel().getSelectedItem().getGuardianName());
            txtGuardOccupation.setText(StudentTable.getSelectionModel().getSelectedItem().getGuardianOccupation());
            txtGuardianAddress.setText(StudentTable.getSelectionModel().getSelectedItem().getGuardianAddress());
            txtGuardianTelephone.setText(StudentTable.getSelectionModel().getSelectedItem().getGuardianTel());
            Image image1 = new Image(StudentTable.getSelectionModel().getSelectedItem().getPhoto());
            ProfilePicture.setImage(image1);
        } catch (Exception e) {
            e.printStackTrace();

        }

    }
    void toFile(byte[] data, File destination){
        try(FileOutputStream fos = new FileOutputStream(destination)){
            fos.write(data);
            fos.close();

        }
        catch(Exception e){
            System.out.println("There was an error");
        }
    }

    @FXML
    protected void updateStudentRecord() {

        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

            alert.setTitle("Update Record Confirmation");
            alert.setContentText("Are you sure you want to update this record?");

            Optional<ButtonType> option = alert.showAndWait();

            if (option.get() == ButtonType.CANCEL) {

            } else if (option.get() == ButtonType.OK) {
                if (!StudentTable.getSelectionModel().isEmpty()) {
                    StudentTable.getSelectionModel().getSelectedItem().setErn(txtId.getText());
                    StudentTable.getSelectionModel().getSelectedItem().setFirstName(txtFirstName.getText());
                    StudentTable.getSelectionModel().getSelectedItem().setMiddleName(txtMiddleName.getText());
                    StudentTable.getSelectionModel().getSelectedItem().setBirthCertNum(txtBirthCertNumber.getText());
                    StudentTable.getSelectionModel().getSelectedItem().setDob(txtDOB.getValue());
                    StudentTable.getSelectionModel().getSelectedItem().setDareReg(txtDateReg.getValue());
                    StudentTable.getSelectionModel().getSelectedItem().setSportsHouse(txtSportsHouse.getValue().toString());
                    StudentTable.getSelectionModel().getSelectedItem().setClub(txtClub.getText());
                    StudentTable.getSelectionModel().getSelectedItem().setGender(txtGender.getValue().toString());
                    StudentTable.getSelectionModel().getSelectedItem().setStudentAddress(txtStudentAddress.getText());
                    StudentTable.getSelectionModel().getSelectedItem().setMotherName(txtMotherName.getText());
                    StudentTable.getSelectionModel().getSelectedItem().setMotherOccupation(txtMotherOccupation.getText());
                    StudentTable.getSelectionModel().getSelectedItem().setMotherTel(txtMotherTelephone.getText());
                    StudentTable.getSelectionModel().getSelectedItem().setFatherName(txtFatherName.getText());
                    StudentTable.getSelectionModel().getSelectedItem().setFatherTel(txtFatherTelephone.getText());
                    StudentTable.getSelectionModel().getSelectedItem().setFatherAddress(txtFatherAddress.getText());
                    StudentTable.getSelectionModel().getSelectedItem().setGuardianName(txtGuardianName.getText());
                    StudentTable.getSelectionModel().getSelectedItem().setGuardianOccupation(txtGuardOccupation.getText());
                    StudentTable.getSelectionModel().getSelectedItem().setGuardianAddress(txtGuardianAddress.getText());
                    StudentTable.getSelectionModel().getSelectedItem().setGuardianTel(txtGuardianTelephone.getText());
                    StudentTable.getSelectionModel().getSelectedItem().setPhoto(ProfilePicture.getImage().getUrl());

                    StudentRepo.save(StudentTable.getSelectionModel().getSelectedItem());
                    clearFields();
                    loadStudentTable();

                    Dialog = new Alert(Alert.AlertType.INFORMATION);
                    Dialog.setTitle("Success");
                    Dialog.setContentText("Record Updated!");
                    Dialog.showAndWait();
                } else {
                    Dialog = new Alert(Alert.AlertType.WARNING);
                    Dialog.setTitle("Selection Warning");
                    Dialog.setHeaderText("Edit Student");
                    Dialog.setContentText("Please Select Student from the table");
                    Dialog.showAndWait();
                }

            }


        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @FXML
    private void addStudent() {

        try {
            boolean IsFound = false;
            ObservableList<Student> Studentlist = getListOfStudents();
            for (Student Stu1 : Studentlist) {
                if (Stu1.getId() == Integer.parseInt(txtId.getText())) {
                    IsFound = true;
                    break;
                }
            }

            if (!IsFound && Integer.parseInt(txtId.getText()) != 0) {
                NewStudent.setErn(txtId.getText());
                NewStudent.setFirstName(txtFirstName.getText());
                NewStudent.setMiddleName(txtMiddleName.getText());
                NewStudent.setLastName(txtLastName.getText());
                NewStudent.setBirthCertNum(txtBirthCertNumber.getText());
                NewStudent.setBirthCertNum(txtBirthCertNumber.getText());
                NewStudent.setDob(txtDOB.getValue());
                NewStudent.setDareReg(txtDateReg.getValue());
                NewStudent.setSportsHouse(txtSportsHouse.getValue().toString());
                NewStudent.setClub(txtClub.getText());
                NewStudent.setGender(txtGender.getValue().toString());
                NewStudent.setStudentAddress(txtStudentAddress.getText());
                NewStudent.setMotherName(txtMotherName.getText());
                NewStudent.setMotherOccupation(txtMotherOccupation.getText());
                NewStudent.setMotherTel(txtMotherTelephone.getText());
                NewStudent.setFatherTel(txtFatherTelephone.getText());
                NewStudent.setFatherName(txtFatherName.getText());
                NewStudent.setFatherAddress(txtFatherAddress.getText());
                NewStudent.setGuardianName(txtGuardianName.getText());
                NewStudent.setGuardianOccupation(txtGuardOccupation.getText());
                NewStudent.setGuardianAddress(txtGuardianAddress.getText());
                NewStudent.setGuardianTel(txtGuardianTelephone.getText());
                NewStudent.setPhoto(ProfilePicture.getImage().getUrl().toString());

               /* BufferedImage bImage = ImageIO.read(new File(ProfilePicture.getImage().getUrl()));
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ImageIO.write(bImage, "png", bos );
                byte [] data = bos.toByteArray();

                */

               /*
                BufferedImage image = ImageIO.read(new File(ProfilePicture.getImage().getUrl()));
                ByteArrayOutputStream outStreamObj = new ByteArrayOutputStream();
                ImageIO.write(image, "png", outStreamObj);
                byte [] byteArray = outStreamObj.toByteArray();
                newstudent.setPhoto(byteArray.toString());



              //  newstudent.setPhoto(ProfilePicture.getImage().getUrl().getBytes().toString());

                */
                StudentRepo.saveAndFlush(NewStudent);
                Alert b = new Alert(Alert.AlertType.NONE);
                b.setAlertType(Alert.AlertType.CONFIRMATION);
                b.setTitle("Success!");
                b.setContentText("Record Added");
                b.show();
                clearFields();
                loadStudentTable();
            } else {
                if (IsFound) {
                    Alert b = new Alert(Alert.AlertType.NONE);
                    b.setAlertType(Alert.AlertType.CONFIRMATION);
                    b.setTitle("Error!");
                    b.setContentText("A record with this ern already exist please try again");
                    b.show();
                }
                if (txtId.getText().isBlank()) {
                    Alert b = new Alert(Alert.AlertType.NONE);
                    b.setAlertType(Alert.AlertType.CONFIRMATION);
                    b.setTitle("Error!");
                    b.setContentText("The ERN Field is required");
                    b.show();
                }
            }
        } catch (Exception e) {
            if(!validateForm()) {
                Alert b = new Alert(Alert.AlertType.NONE);
                b.setAlertType(Alert.AlertType.CONFIRMATION);
                b.setTitle("Error!");
                b.setContentText("All fields are required for adding a student");
                b.show();
            }
            else {
                Alert b = new Alert(Alert.AlertType.NONE);
                b.setAlertType(Alert.AlertType.CONFIRMATION);
                b.setTitle("Error!");
                b.setContentText("An error occurred please try again");
                b.show();
            }
        }
    }
}
