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
import javafx.scene.image.ImageView;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
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

    @Autowired
    private UserRepository UserRepo;

    @Autowired
    Health health1;
    @FXML
    private TextField TFId, TFFirstName, TFMiddleName, TFLastName;

    @FXML
    private TableView<Student> StudentTable;
    @FXML
    private TableView<Health> HealthTable;

    private ObservableList<Health> GetHealthById(int id) {
        return HealthList = FXCollections.observableArrayList(HealthRepo.findById(id).get());

    }

    private Student getStudentById(int Id) {
        return StudentRepo.findById(Id).get();
    }

    private final TableColumn<Health, String> ColAsthmatic =
            new TableColumn<>("Asthmatic");
    private final TableColumn<Health, Integer> ColStudId = new TableColumn<>("Student Id");
    private final TableColumn<Health, String> ColUrinaryDisorder =
            new TableColumn<>("Urinary Disorder");
    private final TableColumn<Health, String> ColEarProblem =
            new TableColumn<>("Ear Problem");
    private final TableColumn<Health, String> ColEyeProblem =
            new TableColumn<>("Eye Problem");
    private final TableColumn<Health, String> ColHeartProblems =
            new TableColumn<>("Heart Problem");
    private final TableColumn<Health, String> ColOther =
            new TableColumn<>("Other");
    private final TableColumn<Health, String> ColPhysicalDefects =
            new TableColumn<>("Physical Defects");

    private final TableColumn<Student, Integer> StuColID =
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

    private ObservableList<Health> getListOfHealth() {
        return HealthList = FXCollections.observableArrayList(HealthRepo.findAll());
    }

    @FXML
    private void initialize() {
        LoadStudentInfo();
        LoadHealthTable();
        StudentTable.setOnMouseClicked(e -> {
            if (e.getClickCount() > 0) {
                ClearFields();
                loadSelectedItemInFields();
            }
        });
        HealthTable.setOnMouseClicked( e -> {
            if(e.getClickCount() > 0){
                loadSelectedItemInHealthTable();
            }
        });
    }



    private void SetColumnProperties() {
        StuColID.setCellValueFactory(new PropertyValueFactory<>("Id"));
        ColLastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        ColMiddleName.setCellValueFactory(new PropertyValueFactory<>("MiddleName"));
        ColFirstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
    }

    private void SetHealthTableColumnProperties() {
        ColStudId.setCellValueFactory(new PropertyValueFactory<>("idStu"));
        ColAsthmatic.setCellValueFactory(new PropertyValueFactory<>("Asthmatic"));
        ColUrinaryDisorder.setCellValueFactory(new PropertyValueFactory<>("UrinaryDisoder"));
        ColEarProblem.setCellValueFactory(new PropertyValueFactory<>("EarProblem"));
        ColEyeProblem.setCellValueFactory(new PropertyValueFactory<>("EyeProblem"));
        ColHeartProblems.setCellValueFactory(new PropertyValueFactory<>("HeartProblem"));
        ColOther.setCellValueFactory(new PropertyValueFactory<>("Other"));
        ColPhysicalDefects.setCellValueFactory(new PropertyValueFactory<>("PhysicalDefects"));
    }


    @FXML
    private void LoadHealthTable() {
        ArrayList<Student> Students = (ArrayList<Student>) StudentRepo.findAll();
        SetHealthTableColumnProperties();
        HealthTable.getColumns().clear();
        HealthTable.getItems().clear();
        HealthTable.getColumns().addAll(ColStudId,ColAsthmatic, ColEarProblem, ColEyeProblem, ColHeartProblems, ColPhysicalDefects,
                ColUrinaryDisorder, ColOther);
        HealthTable.getItems();
        HealthList.addAll(HealthRepo.findAll());
        HealthTable.setItems(HealthList);
    }

    @FXML
    private void AddHealthRecord() {

        try {
            if (!TFId.getText().isEmpty()) {

                boolean isFound = false;
                for (Health health2 : HealthList) {
                    if(health2.getIdStu() != null)
                    if (health2.getIdStu() == Integer.parseInt(TFId.getText())) {
                        Alert b = new Alert(Alert.AlertType.NONE);
                        isFound = true;
                        break;
                    }

                }
                if (isFound == false) {

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
                    health1 = new Health();
                    ClearFields();
                    LoadHealthTable();

                } else {
                    Alert b = new Alert(Alert.AlertType.WARNING);
                    b.setTitle("Error!");
                    b.setContentText("A Health Record for this Student Already exists, please update or delete it ");
                    ClearFields();
                    b.showAndWait();


                }


            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    @FXML
    private void DeleteHealthRecord() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Record Confirmation");
        alert.setContentText("Are you sure you want to Delete this record?");
        Optional<ButtonType> option = alert.showAndWait();

        if (option.get().equals(ButtonType.CANCEL)) {

        } else if (option.get().equals(ButtonType.OK)) {
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
            alert.setTitle("Update Record Confirmation");
            alert.setContentText("Are you sure you want to update this record?");
            Optional<ButtonType> option = alert.showAndWait();
            if (option.get().equals(ButtonType.CANCEL)) {
            } else if (option.get().equals(ButtonType.OK)) {
                if (!HealthTable.getSelectionModel().isEmpty()) {
                    HealthTable.getSelectionModel().getSelectedItem().setHeartProblem(TbHeartProblems.getText());
                    HealthTable.getSelectionModel().getSelectedItem().setAsthmatic(TbAsthmatic.getText());

                    HealthTable.getSelectionModel().getSelectedItem().setPhysicalDefects(TbPhysicalDefects.getText());
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
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    public void ClearFields() {
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
        SetColumnProperties();
        StudentTable.getColumns().clear();
        StudentTable.getItems().clear();
        StudentTable.getColumns().addAll(StuColID, ColFirstName, ColMiddleName, ColLastName);
        StudentTable.getItems();
        StudentList.addAll(StudentRepo.findAll());
        StudentTable.setItems(StudentList);


    }

    @FXML
    private void loadSelectedItemInFields() {
        try {
            TFId.setText(StudentTable.getSelectionModel().getSelectedItem().getId().toString());
            TFFirstName.setText(StudentTable.getSelectionModel().getSelectedItem().getFirstName());
            TFMiddleName.setText(StudentTable.getSelectionModel().getSelectedItem().getMiddleName());
            TFLastName.setText(StudentTable.getSelectionModel().getSelectedItem().getLastName());
            System.out.println(StudentTable.getSelectionModel().getSelectedItem().getLastName());


            int searchId = Integer.parseInt(TFId.getText()) ;
            HealthTable.getItems().stream().filter(item -> item.getId()==searchId).findAny();
            HealthTable.getItems().stream()
                    .filter(item -> item.getId() == Integer.parseInt(TFId.getText()))
                    .findAny()
                    .ifPresent(item -> {
                        HealthTable.getSelectionModel().select(item);
                        HealthTable.scrollTo(item);
                        Alert a = new Alert(Alert.AlertType.NONE);
                        a.setAlertType(Alert.AlertType.CONFIRMATION);
                        a.setTitle("Record Found");
                        a.showAndWait();
                    });


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void loadSelectedItemInHealthTable() {
        Health SelectedItem = HealthTable.getSelectionModel().getSelectedItem();
        if(SelectedItem != null){
            Student RecordFor = StudentRepo.findById(SelectedItem.getIdStu()).get();
            //Student Information Section
            TFId.setText(RecordFor.getId().toString());
            TFFirstName.setText(RecordFor.getFirstName());
            TFLastName.setText(RecordFor.getLastName());
            TFMiddleName.setText(RecordFor.getMiddleName());
            //Health Table Section
            TbHeartProblems.setText(SelectedItem.getHeartProblem());
            TbOther.setText(SelectedItem.getOther());
            TbUrinaryDisorder.setText(SelectedItem.getUrinaryDisoder());
            TbEyeProblem.setText(SelectedItem.getEyeProblem());
            TbAsthmatic.setText(SelectedItem.getAsthmatic());
            TbEarProblem.setText(SelectedItem.getEyeProblem());
            TbPhysicalDefects.setText(SelectedItem.getPhysicalDefects());
        }
    }
}