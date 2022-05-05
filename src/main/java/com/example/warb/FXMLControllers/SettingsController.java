package com.example.warb.FXMLControllers;

import com.example.warb.JPAEntities.User;
import com.example.warb.Repositories.UserRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;


import javafx.scene.control.*;


@Component
public class SettingsController {
    ObservableList<User> Userlist = FXCollections.observableArrayList();
    @Autowired
    private UserRepository UserRepo;
    private ObservableList<User> getListOfUsers() {
        return Userlist = FXCollections.observableArrayList(UserRepo.findAll());

    }
@FXML
    private TableView<User> UserTable;
    private final TableColumn<User, Integer> ColID =
            new TableColumn<>("ID");
    private final TableColumn<User, String> ColFirstName =
            new TableColumn<>("First Name");
    private final TableColumn<User, String> ColLastName =
            new TableColumn<>("Last Name");


    private final TableColumn<User, String> ColEmail =
            new TableColumn<>("Email");
    private final TableColumn<User, String> ColRole =
            new TableColumn<>("Role");
    private TableColumn<User, String> ColPassword =
            new TableColumn<>("Password");
    private final TableColumn<User, String> ColUsername =
            new TableColumn<>("Username");




    public TextField txtId;
    public ComboBox txtRole;
    public TextField txtFirstName;
    public TextField txtLastName;
    public TextField txtEmail;
    public TextField txtUserName;
    public PasswordField txtPassword;

    public PasswordField txtConfirmPassword;


@FXML
private void initialize() {
    loadUserTable();
   populateComboBox();

    UserTable.setOnMouseClicked(e -> {
        if (e.getClickCount() > 0) {
            loadSelectedUserInFields();
        }

    });

}

private void populateComboBox(){
    ObservableList<String> data1 = FXCollections.observableArrayList("Admin", "Regular");
    txtRole.setItems(data1);
}
    private void loadUserTable() {

        try {


            UserTable.getColumns().clear();
            UserTable.getItems().clear();

            ArrayList<User> Users = (ArrayList<User>) UserRepo.findAll();
            setCellValueFactoryForUserTableColumn();
            UserTable.getColumns().addAll(ColID,ColFirstName,ColLastName,ColUsername,ColPassword,ColEmail,ColRole);
            if (!getListOfUsers().isEmpty()) {
                UserTable.setItems(getListOfUsers());
            }

        } catch (Exception e) {
            e.printStackTrace();
            Alert Dialog = new Alert(Alert.AlertType.WARNING);
            Dialog.setTitle("Error Message");
            Dialog.setHeaderText("Error");
            Dialog.setContentText("An error occurred please try again");
            Dialog.showAndWait();

        }


    }
    private void setCellValueFactoryForUserTableColumn() {
        try {
            ColUsername.setCellValueFactory(new PropertyValueFactory<>("Username"));
            ColPassword.setCellValueFactory(new PropertyValueFactory<>("Password1"));
            ColID.setCellValueFactory(new PropertyValueFactory<>("Id"));
            ColFirstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
            ColLastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
            ColEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
            ColRole.setCellValueFactory(new PropertyValueFactory<>("Role1"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void clearFields(){
        txtId.setText("");
        txtRole.setValue("");
        txtFirstName.setText("");
        txtLastName.setText("");
        txtEmail.setText("");
        txtUserName.setText("");
        txtPassword.setText("");
        txtConfirmPassword.setText("");
    }

    User newUser = new User();
@FXML

    private void addUser(){
    try {
        boolean IsFound = false;

        for (User user1 : Userlist) {
            if (user1.getId() == Integer.parseInt(txtId.getText())) {
                IsFound = true;
                break;
            }
        }
        if (!IsFound) {

            newUser.setId(Integer.parseInt(txtId.getText()));
            newUser.setRole(txtRole.getSelectionModel().getSelectedItem().toString());
            newUser.setFirstName(txtFirstName.getText());
            newUser.setLastName(txtLastName.getText());
            newUser.setEmail(txtEmail.getText());
            newUser.setUsername(txtUserName.getText());
            newUser.setPassword(txtPassword.getText());
            UserRepo.saveAndFlush(newUser);
            loadUserTable();
            clearFields();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            //alert.setTitle("Confirmation");
            alert.setTitle("Record Saved");
            alert.showAndWait();

        }
    }catch(Exception e){
        e.printStackTrace();
        Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
        alert1.setTitle("Error");
        alert1.setContentText("An Error Occurred Please Try Again");
        alert1.showAndWait();
    }


    }
    @FXML
    void deleteUser() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        //alert.setTitle("Confirmation");
        alert.setTitle("Delete Record Confirmation");
        alert.setContentText("Are you sure you want to Delete this User?");

        Optional<ButtonType> option = alert.showAndWait();

        if (option.get() == null || option.get() == ButtonType.CANCEL) {

        } else if (option.get() == ButtonType.OK) {

            try{
                if(!UserTable.getSelectionModel().isEmpty()){
                    UserRepo.deleteById(UserTable.getSelectionModel().getSelectedItem().getId());
                    loadUserTable();
                }

            }catch(Exception e){
                Alert Dialog = new Alert(Alert.AlertType.WARNING);
                Dialog.setTitle("Error Message");
                Dialog.setHeaderText("Error");
                Dialog.setContentText("Please try again");
                Dialog.showAndWait();

            }

        }
    }


    @FXML

    private void loadSelectedUserInFields(){
    try{

        txtId.setText(UserTable.getSelectionModel().getSelectedItem().getId().toString());
        txtRole.setValue(UserTable.getSelectionModel().getSelectedItem().getRole());
        txtFirstName.setText(UserTable.getSelectionModel().getSelectedItem().getFirstName());
        txtLastName.setText(UserTable.getSelectionModel().getSelectedItem().getLastName());
        txtEmail.setText(UserTable.getSelectionModel().getSelectedItem().getEmail());
        txtUserName.setText(UserTable.getSelectionModel().getSelectedItem().getUsername());
        txtPassword.setText(UserTable.getSelectionModel().getSelectedItem().getPassword());


    }
    catch(Exception e){

        }
    }

    @FXML

    private void UpdateUserRecord(){
    try{
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        //alert.setTitle("Confirmation");

        alert.setTitle("Update Record Confirmation");
        alert.setContentText("Are you sure you want to update this User?");

        Optional<ButtonType> option = alert.showAndWait();

        if (option.get() == null || option.get() == ButtonType.CANCEL) {

        } else if (option.get() == ButtonType.OK) {
            if(!UserTable.getSelectionModel().isEmpty()){
                UserTable.getSelectionModel().getSelectedItem().setId(Integer.parseInt(txtId.getText()));
                UserTable.getSelectionModel().getSelectedItem().setRole(txtRole.getValue().toString());
                UserTable.getSelectionModel().getSelectedItem().setFirstName(txtFirstName.getText());
                UserTable.getSelectionModel().getSelectedItem().setLastName(txtLastName.getText());
                UserTable.getSelectionModel().getSelectedItem().setEmail(txtEmail.getText());
                UserTable.getSelectionModel().getSelectedItem().setUsername(txtUserName.getText());
                UserTable.getSelectionModel().getSelectedItem().setPassword(txtPassword.getText());

                UserRepo.save(UserTable.getSelectionModel().getSelectedItem());
                clearFields();
                loadUserTable();
                Alert Dialog = new Alert(Alert.AlertType.INFORMATION);
                Dialog.setTitle("Success");
                Dialog.setContentText("Record Updated!");
                Dialog.showAndWait();

            }

        }

    }
    catch(Exception e ){

        e.printStackTrace();
    }
    }


}
