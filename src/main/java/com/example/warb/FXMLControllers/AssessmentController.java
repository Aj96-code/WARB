package com.example.warb.FXMLControllers;

import com.example.warb.JPAEntities.Assessment;
import com.example.warb.JPAEntities.Student;
import com.example.warb.Repositories.AssessmentRepository;
import com.example.warb.Repositories.StudentRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;


@Component
public class AssessmentController {

    @Autowired
    private StudentRepository Repo;
    @Autowired
    private AssessmentRepository ARepo;
    public Button BtnUpdate;
    public Button BtnDelete;
    public Button BtnSave;
    public javafx.scene.control.TextField IdTf;
    public Button BtnClear;
    public TextField GenKnow;
    public javafx.scene.control.TextField Soci;
    public javafx.scene.control.TextField LangAG4;
    public javafx.scene.control.TextField FNametf;
    public javafx.scene.control.TextField LNameff;
    public javafx.scene.control.TextField NumConc;
    public javafx.scene.control.TextField Geo;
    public javafx.scene.control.TextField MathsG4;
    public javafx.scene.control.TextField OLang;
    public javafx.scene.control.TextField Alg;
    public javafx.scene.control.TextField LangAG5;
    public javafx.scene.control.TextField read;
    public javafx.scene.control.TextField Stat;
    public javafx.scene.control.TextField MathsG5;
    public javafx.scene.control.TextField Stru;
    public javafx.scene.control.TextField WDraw;
    public javafx.scene.control.TextField ATestG6;
    public javafx.scene.control.TextField Vocab;
    public javafx.scene.control.TextField NEst;
    public javafx.scene.control.TextField LangAG6;
    public javafx.scene.control.TextField StudSk;
    public javafx.scene.control.TextField Sci;
    public javafx.scene.control.TextField MathsG6;
    public javafx.scene.control.TextField ComT;
    public javafx.scene.control.TextField MS6C;
    public TextField LAG6C;
    @FXML
    public TableView<Student> ListView;
    public TableView<Assessment> SecondView;

    private TextField[] SecondViewText = new TextField[24];
    private final TableColumn<Student, String> ColFName =
            new TableColumn<>("First Name");
    private final TableColumn<Student, String> ColLName =
            new TableColumn<>("Last Name");

    ObservableList<Student> StudentList = FXCollections.observableArrayList();
    ObservableList<Assessment> AssessmentList = FXCollections.observableArrayList();

    public void RefreshData() {
        GenKnow.setText("");
        Soci.setText("");
        LangAG4.setText("");
        NumConc.setText("");
        Geo.setText("");
        MathsG4.setText("");
        OLang.setText("");
        Alg.setText("");
        LangAG5.setText("");
        read.setText("");
        Stat.setText("");
        MathsG5.setText("");
        Stru.setText("");
        WDraw.setText("");
        ATestG6.setText("");
        Vocab.setText("");
        NEst.setText("");
        LangAG6.setText("");
        StudSk.setText("");
        Sci.setText("");
        MathsG6.setText("");
        ComT.setText("");
        MS6C.setText("");
        LAG6C.setText("");
    }

    private void LoadStudentInfo() {
        ArrayList<Student> Students = (ArrayList<Student>) Repo.findAll();
        SetColumnProperties();
        ListView.getColumns().addAll(ColFName, ColLName);
        ListView.getItems();
        ListView.setItems(StudentList);
        ListView.setItems(GetStudentList());
        StudentList.addAll(Repo.findAll());

    }

    private void LoadAssessmentTable() {
        TableColumn<Assessment, Integer> ColStuId = setAssessmentProperties();
        SecondView.getColumns().add(ColStuId);
        if (!GetAssessmentList().isEmpty()) {
            SecondView.setItems(AssessmentList);
        }
    }


    private ObservableList<Student> GetStudentList() {
        return StudentList = FXCollections.observableArrayList(Repo.findAll());
    }

    private ObservableList<Assessment> GetAssessmentList() {
        return AssessmentList = FXCollections.observableArrayList(ARepo.findAll());

    }

    private Student GetStudentById(int Id) {
        return Repo.findById(Id).get();
    }

    private TextField[] getAssessmentTextField() {
        TextField[] tbArray = new TextField[24];
        tbArray[3] = GenKnow;
        tbArray[15] = read;
        tbArray[12] = NumConc;
        tbArray[20] = WDraw;
        tbArray[14] = OLang;
        tbArray[13] = NEst;
        tbArray[2] = ComT;
        tbArray[23] = Stat;
        tbArray[4] = Geo;
        tbArray[21] = Vocab;
        tbArray[1] = Alg;
        tbArray[18] = StudSk;
        tbArray[22] = Stru;
        tbArray[5] = LangAG4;
        tbArray[8] = MathsG4;
        tbArray[6] = LangAG5;
        tbArray[9] = MathsG5;
        tbArray[0] = ATestG6;
        tbArray[10] = MathsG6;
        tbArray[19] = LangAG6;
        tbArray[7] = LAG6C;
        tbArray[17] = Sci;
        tbArray[11] = MS6C;
        tbArray[16] = Soci;

        return tbArray;
    }

    private void LoadSelectedAssessment() {

        Assessment SelectedObject = ARepo.findById(
                SecondView.getSelectionModel().getSelectedItem().getId()).get();
        SecondViewText = getAssessmentTextField();
        LoadAInfo(SelectedObject);
        // SelectedObject = ARepo.findById(ListView.getSelectionModel().getSelectedItem().getId()).get();

        int[] assessmentValues = {
                SelectedObject.getAbilityTest() == null ? 0 : SelectedObject.getAbilityTest(),
                SelectedObject.getAlgebra() == null ? 0 : SelectedObject.getAlgebra(),
                SelectedObject.getComTask() == null ? 0 : SelectedObject.getComTask(),
                SelectedObject.getGenKnowledge() == null ? 0 : SelectedObject.getGenKnowledge(),
                SelectedObject.getGeometry() == null ? 0 : SelectedObject.getGeometry(),
                SelectedObject.getLangArtGrade4() == null ? 0 : SelectedObject.getLangArtGrade4(),
                SelectedObject.getLangArtGrade5() == null ? 0 : SelectedObject.getLangArtGrade5(),
                SelectedObject.getLangArtGrade6Curri() == null ? 0 : SelectedObject.getLangArtGrade6Curri(),
                SelectedObject.getMathGrade4() == null ? 0 : SelectedObject.getMathGrade4(),
                SelectedObject.getMathGrade5() == null ? 0 : SelectedObject.getMathGrade5(),
                SelectedObject.getMathGrade6() == null ? 0 : SelectedObject.getMathGrade6(),
                SelectedObject.getMathGrade6Curri() == null ? 0 : SelectedObject.getMathGrade6Curri(),
                SelectedObject.getNumberConcept() == null ? 0 : SelectedObject.getNumberConcept(),
                SelectedObject.getNumEst() == null ? 0 : SelectedObject.getNumEst(),
                SelectedObject.getOralLang() == null ? 0 : SelectedObject.getOralLang(),
                SelectedObject.getReading() == null ? 0 : SelectedObject.getReading(),
                SelectedObject.getScience() == null ? 0 : SelectedObject.getScience(),
                SelectedObject.getStructure() == null ? 0 : SelectedObject.getStructure(),
                SelectedObject.getStudySkills() == null ? 0 : SelectedObject.getStudySkills(),
                SelectedObject.getVocab() == null ? 0 : SelectedObject.getVocab(),
                SelectedObject.getWritingDrawing() == null ? 0 : SelectedObject.getWritingDrawing(),
                SelectedObject.getSocialStudies() == null ? 0 : SelectedObject.getSocialStudies(),

        };
        for (int i = 0; i < assessmentValues.length; i++) {
            SecondViewText[i].setText(String.valueOf(assessmentValues[i]));

        }
    }

    private void LoadAInfo(Assessment SelectedObject) {
        IdTf.setText(String.valueOf(SelectedObject.getIdStu()));
        FNametf.setText(Repo.findById(SelectedObject.getIdStu()).get().getFirstName());
        LNameff.setText(Repo.findById(SelectedObject.getIdStu()).get().getLastName());

    }

    private void LoadInfo(Student SelectedObject) {
        IdTf.setText(String.valueOf(SelectedObject.getId()));
        FNametf.setText(SelectedObject.getFirstName());
        LNameff.setText(SelectedObject.getLastName());
        LangAG5.setText(SelectedObject.getBirthCertNum());
    }

    private void LoadSelectedData() {
        clearTextField();
        LoadInfo(ListView.getSelectionModel().getSelectedItem());


    }


    private void clearTextField() {
        try {
            for (TextField Field : SecondViewText) {
                if (Field.getText() != null)
                    Field.setText("");
            }
        } catch (NullPointerException NE) {
        }

    }

    private void LoadUserDetails() {
        StudentList.clear();
        StudentList.addAll(Repo.findAll());
        ListView.setItems(StudentList);

    }

    private void LoadAssessmentDetails() {
        AssessmentList.clear();
        AssessmentList.addAll(ARepo.findAll());
        SecondView.setItems(AssessmentList);
    }

    @FXML
    public void initialize() {
        //Add All User to the table
        LoadStudentInfo();
        SetColumnProperties();
        LoadAssessmentTable();
        setAssessmentProperties();

        ListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        LoadUserDetails();
        ListView.setOnMouseClicked(e -> {
            if (e.getClickCount() > 0) {
                LoadSelectedData();
            }
        });

        LoadAssessmentDetails();
        SecondView.setOnMouseClicked(e -> {
            if (e.getClickCount() > 0) {
                LoadSelectedAssessment();
            }
        });
    }

    private void SetColumnProperties() {
        ColLName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        ColFName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
    }

    private TableColumn<Assessment, Integer> setAssessmentProperties() {
        TableColumn<Assessment, Integer> ColStuId = new TableColumn<>("Student Id");
        ColStuId.setCellValueFactory(new PropertyValueFactory<>("idStu"));
        return ColStuId;
    }

    public boolean Validate() {
        return GenKnow.getText().isEmpty() || Soci.getText().isEmpty() ||
                LangAG4.getText().isEmpty() || NumConc.getText().isEmpty() || Geo.getText().isEmpty() ||
                MathsG4.getText().isEmpty() || OLang.getText().isEmpty() ||
                Alg.getText().isEmpty() || LangAG5.getText().isEmpty() || read.getText().isEmpty() || Stat.getText().isEmpty() ||
                MathsG5.getText().isEmpty() || Stru.getText().isEmpty() || WDraw.getText().isEmpty() || ATestG6.getText().isEmpty() ||
                Vocab.getText().isEmpty()|| NEst.getText().isEmpty()|| LangAG6.getText().isEmpty() || StudSk.getText().isEmpty() ||
                Sci.getText().isEmpty()|| MathsG6.getText().isEmpty()|| ComT.getText().isEmpty() || MS6C.getText().isEmpty();
    }

    @FXML
    public void SaveData(ActionEvent actionEvent) {
        if (!Objects.equals(IdTf.getText(), "")) {
            saveToDb();
        } else {
            Alert Dialog = new Alert(Alert.AlertType.ERROR);
            Dialog.setTitle("Selection Error");
            Dialog.setHeaderText(null);
            Dialog.setContentText("Enter Correct Student ID");
            Dialog.showAndWait();

        }

    }

    public void saveToDb() {

        int Stud_Id = GetStudentById(Integer.parseInt(IdTf.getText())).getId();
        System.out.print(Stud_Id);
        boolean IsFound = false;
        ObservableList<Assessment> AssessmentList = GetAssessmentList();
        try {
            for (Assessment Item : AssessmentList) {
                if (Item.getIdStu() == Stud_Id) {
                    IsFound = true;
                }
            }
        } catch (Exception EXC) {
        }
        if (IsFound) {
            Alert Dialog = new Alert(Alert.AlertType.WARNING);
            Dialog.setContentText("Student Assessment Has Already Being Assigned");
            Dialog.setTitle("Not Saved");
            Dialog.setHeaderText("Save Dialog");
            Dialog.showAndWait();
        } else if (Validate()) {
            //Assessment Assessment = null;
            if (Stud_Id != 0) {

                Assessment newAssessment = new Assessment();
                newAssessment.setIdStu(Stud_Id);
                newAssessment.setAbilityTest(Integer.parseInt(ATestG6.getText() == "" ? "0"
                        : ATestG6.getText()));
                newAssessment.setAlgebra(Integer.parseInt(Alg.getText() == "" ? "0"
                        : Alg.getText()));
                newAssessment.setComTask(Integer.parseInt(ComT.getText() == "" ? "0"
                        : ComT.getText()));
                newAssessment.setGenKnowledge(Integer.parseInt(GenKnow.getText() == "" ? "0"
                        : GenKnow.getText()));
                newAssessment.setGeometry(Integer.parseInt(Geo.getText() == "" ? "0"
                        : Geo.getText()));
                newAssessment.setLangArtGrade4(Integer.parseInt(LangAG4.getText() == "" ? "0"
                        : LangAG4.getText()));
                newAssessment.setLangArtGrade5(Integer.parseInt(LangAG5.getText() == "" ? "0"
                        : LangAG5.getText()));
                newAssessment.setLangArtGrade6Curri(Integer.parseInt(LAG6C.getText() == "" ? "0"
                        : LAG6C.getText()));
                newAssessment.setMathGrade4(Integer.parseInt(MathsG4.getText() == "" ? "0"
                        : MathsG4.getText()));
                newAssessment.setMathGrade5(Integer.parseInt(MathsG5.getText() == "" ? "0"
                        : MathsG5.getText()));
                newAssessment.setMathGrade6(Integer.parseInt(MathsG6.getText() == "" ? "0"
                        : MathsG6.getText()));
                newAssessment.setMathGrade6Curri(Integer.parseInt(MS6C.getText() == "" ? "0"
                        : MS6C.getText()));
                newAssessment.setNumEst(Integer.parseInt(NEst.getText() == "" ? "0"
                        : NEst.getText()));
                newAssessment.setNumberConcept(Integer.parseInt(NumConc.getText() == "" ? "0"
                        : NumConc.getText()));
                newAssessment.setOralLang(Integer.parseInt(OLang.getText() == "" ? "0"
                        : OLang.getText()));
                newAssessment.setReading(Integer.parseInt(read.getText() == "" ? "0"
                        : read.getText()));
                newAssessment.setScience(Integer.parseInt(Sci.getText() == "" ? "0"
                        : Sci.getText()));
                newAssessment.setSocialStudies(Integer.parseInt(Soci.getText() == "" ? "0"
                        : Soci.getText()));
                newAssessment.setStatistics(Integer.parseInt(Stat.getText() == "" ? "0"
                        : Stat.getText()));
                newAssessment.setStudySkills(Integer.parseInt(StudSk.getText() == "" ? "0"
                        : StudSk.getText()));
                newAssessment.setStructure(Integer.parseInt(Stru.getText() == "" ? "0"
                        : Stru.getText()));
                newAssessment.setVocab(Integer.parseInt(Vocab.getText() == "" ? "0"
                        : Vocab.getText()));
                newAssessment.setWritingDrawing(Integer.parseInt(WDraw.getText() == "" ? "0"
                        : WDraw.getText()));
                newAssessment.setIdStu(Integer.parseInt(IdTf.getText()));

                Assessment assessment = ARepo.save(newAssessment);
                ARepo.saveAndFlush(newAssessment);
                LoadAssessmentTable();
                LoadAssessmentDetails();
                saveAlert(assessment);

            } else {
                Error();
            }
        } else {
            Empty();
        }
    }

    private void saveAlert(Assessment assessment) {

        Alert Dialog = new Alert(Alert.AlertType.INFORMATION);
        Dialog.setContentText("Student Assessment Has Being Saved!");
        Dialog.setTitle("The Student" + assessment.getIdStu()+"" + "Has Being Added");
        Dialog.setHeaderText("Save Dialog");
        Dialog.showAndWait();
    }

    private void Error() {
        Alert Dialog = new Alert(Alert.AlertType.ERROR);
        Dialog.setContentText("Assessment Cannot Be Saved!");
        Dialog.setTitle("Save Error");
        Dialog.setHeaderText("Save Dialog");
        Dialog.showAndWait();
    }

    private void Empty() {
        Alert Dialog = new Alert(Alert.AlertType.INFORMATION);
        Dialog.setContentText("Enter Student Assessment Record");
        Dialog.setTitle("No Information Enterd");
        Dialog.setHeaderText("Save Dialog");
        Dialog.showAndWait();
    }

    private void NoRecord() {
        Alert Dialog = new Alert(Alert.AlertType.WARNING);
        Dialog.setContentText("Student Assessment Record Cannot be Found");
        Dialog.setTitle("No Record");
        Dialog.setHeaderText("Update Dialog");
        Dialog.showAndWait();
    }

    private void UpdateDialog() {
        Alert Dialog = new Alert(Alert.AlertType.INFORMATION);
        Dialog.setContentText("Student Assessment Has Being Updated");
        Dialog.setTitle("Update");
        Dialog.setHeaderText("Update Dialog");
        Dialog.showAndWait();
    }
    @FXML
    public void UpdateData() {

        boolean IsFound = false;
        ObservableList<Assessment> AssessmentList = GetAssessmentList();
        for (Assessment Item : AssessmentList) {
            if (Item.getIdStu() ==
                    SecondView.getSelectionModel().getSelectedItem().getIdStu()) {
                IsFound = true;
                break;
            }
        }

        if (!IsFound) {
            NoRecord();
        } else {
            try {


                SecondView.getSelectionModel().getSelectedItem().setAbilityTest(Integer.parseInt(ATestG6.getText()));
                SecondView.getSelectionModel().getSelectedItem().setAlgebra(Integer.parseInt(Alg.getText()));
                SecondView.getSelectionModel().getSelectedItem().setComTask(Integer.parseInt(ComT.getText()));
                SecondView.getSelectionModel().getSelectedItem().setGenKnowledge(Integer.parseInt(GenKnow.getText()));
                SecondView.getSelectionModel().getSelectedItem().setGeometry(Integer.parseInt(Geo.getText()));
                SecondView.getSelectionModel().getSelectedItem().setLangArtGrade4(Integer.parseInt(LangAG4.getText()));
                SecondView.getSelectionModel().getSelectedItem().setLangArtGrade5(Integer.parseInt(LangAG5.getText()));
                SecondView.getSelectionModel().getSelectedItem().setLangArtGrade6Curri(Integer.parseInt(LAG6C.getText()));
                SecondView.getSelectionModel().getSelectedItem().setMathGrade4(Integer.parseInt(MathsG4.getText()));
                SecondView.getSelectionModel().getSelectedItem().setMathGrade5(Integer.parseInt(MathsG5.getText()));
                SecondView.getSelectionModel().getSelectedItem().setMathGrade6(Integer.parseInt(MathsG6.getText()));
                SecondView.getSelectionModel().getSelectedItem().setMathGrade6Curri(Integer.parseInt(MS6C.getText()));
                SecondView.getSelectionModel().getSelectedItem().setNumEst(Integer.parseInt(NEst.getText()));
                SecondView.getSelectionModel().getSelectedItem().setNumberConcept(Integer.parseInt(NumConc.getText()));
                SecondView.getSelectionModel().getSelectedItem().setOralLang(Integer.parseInt(OLang.getText()));
                SecondView.getSelectionModel().getSelectedItem().setReading(Integer.parseInt(read.getText()));
                SecondView.getSelectionModel().getSelectedItem().setScience(Integer.parseInt(Sci.getText()));
                SecondView.getSelectionModel().getSelectedItem().setSocialStudies(Integer.parseInt(Soci.getText()));
                SecondView.getSelectionModel().getSelectedItem().setStatistics(Integer.parseInt(Stat.getText()));
                SecondView.getSelectionModel().getSelectedItem().setStudySkills(Integer.parseInt(StudSk.getText()));
                SecondView.getSelectionModel().getSelectedItem().setStructure(Integer.parseInt(Stru.getText()));
                SecondView.getSelectionModel().getSelectedItem().setVocab(Integer.parseInt(Vocab.getText()));
                SecondView.getSelectionModel().getSelectedItem().setWritingDrawing(Integer.parseInt(WDraw.getText()));

            } catch (IllegalArgumentException IEX) {
                System.out.print("Field Is Empty");
            }
            ARepo.save(SecondView.getSelectionModel().getSelectedItem());
            UpdateDialog();
            SecondView.getColumns().clear();
            SecondView.getItems().clear();
            LoadAssessmentTable();
        }

    }


    @FXML
    public void DeleteData(ActionEvent actionEvent) {

        List<Assessment> Assessment = SecondView.getSelectionModel().getSelectedItems();
        boolean IsFound = false;
        ObservableList<Assessment> AssessmentList = GetAssessmentList();
        for (Assessment Items : AssessmentList) {
            if (Items.getIdStu() == SecondView.getSelectionModel().getSelectedItem().getIdStu()) {
                IsFound = true;
                break;
            }
        }
        Alert Dialog = new Alert(Alert.AlertType.CONFIRMATION);
        Dialog.setTitle("Conformation Dialog");
        Dialog.setHeaderText(null);
        Dialog.setContentText("Are you sure you want to delete Selected?");
        Optional<ButtonType> action = Dialog.showAndWait();
        if (action.get() == ButtonType.OK) {
            ARepo.delete(SecondView.getSelectionModel().getSelectedItem());
            ARepo.flush();
            Dialog.close();
            SecondView.getColumns().clear();
            SecondView.getItems().clear();
            LoadAssessmentDetails();
        }


    }

}



