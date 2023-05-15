package com.example.program_fx_test.controllers;

import com.example.program_fx_test.dao.Repository;
import com.example.program_fx_test.entities.Roles;
import com.example.program_fx_test.entities.User;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddTeacherController implements Initializable {
    public Button submitButton;
    public TextField nameField;
    public TextField surnameField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        submitButton.setOnAction(e -> {
            String name = nameField.getText();
            String surname = surnameField.getText();

            User user = new User("AddedByDekanOrTeacher", "AddedByDekanOrTeacher", name,surname);
            user.setRole(Roles.TEACHER);
            Repository repository = new Repository();
            try {
                repository.createUser(user);
                submitButton.getScene().getWindow().hide();
            } catch (SQLException | ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });


    }
}
