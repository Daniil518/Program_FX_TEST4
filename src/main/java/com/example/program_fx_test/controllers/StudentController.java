package com.example.program_fx_test.controllers;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import com.example.program_fx_test.Application;
import com.example.program_fx_test.SceneCreator;
import com.example.program_fx_test.dao.Repository;
import com.example.program_fx_test.entities.Roles;
import com.example.program_fx_test.entities.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class StudentController implements Initializable {
    @FXML
    public TableView<User> tableStudents;
    public Button addButton;
    public Button deleteButton;
    public Button reload;

    @FXML
    private TableColumn<User, String> name;
    @FXML
    private TableColumn<User, String> surname;

    SceneCreator sceneCreator = new SceneCreator();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        Repository repository = new Repository();
        List<User> studentUsers;
        try {
            studentUsers = repository.getAllUsers().stream().filter(user -> user.getRole() == Roles.STUDENT).toList();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        tableStudents.getItems().setAll(studentUsers);
        tableStudents.setEditable(true);

        addButton.setOnAction(event -> {
            sceneCreator.newScene("addStudent.fxml");
        });

        Roles currentUserRole = Application.getCurrentUserRole();
        if (currentUserRole.equals(Roles.STUDENT)) {
            addButton.setVisible(false);
            deleteButton.setVisible(false);
        }


        reload.setOnAction(e -> {
            List<User> studentsReloaded;
            try {
                studentsReloaded = repository.getAllUsers().stream().filter(user -> user.getRole() == Roles.STUDENT).toList();
            } catch (SQLException | ClassNotFoundException e2) {
                throw new RuntimeException(e2);
            }
            tableStudents.getItems().setAll(studentsReloaded);
        });

        deleteButton.setOnAction(e-> {
            User userSelected = tableStudents.getSelectionModel().getSelectedItem();
            try {
                repository.deleteUser(userSelected);
                List<User> studentsReloaded;
                try {
                    studentsReloaded = repository.getAllUsers().stream().filter(u -> u.getRole() == Roles.STUDENT).toList();
                } catch (SQLException | ClassNotFoundException e2) {
                    throw new RuntimeException(e2);
                }
                tableStudents.getItems().setAll(studentsReloaded);
            } catch (SQLException | ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }

        });



    }


}
