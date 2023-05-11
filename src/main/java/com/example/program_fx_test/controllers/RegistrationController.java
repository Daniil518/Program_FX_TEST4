package com.example.program_fx_test.controllers;

import com.example.program_fx_test.dao.Repository;
import com.example.program_fx_test.entities.Roles;
import com.example.program_fx_test.entities.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class RegistrationController implements Initializable {

    @FXML
    private TextField login;

    @FXML
    private TextField password;

    @FXML
    private Button submitButton;

    @FXML
    private ComboBox<String> choiceBox;
    ;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        submitButton.setOnAction(event -> {
            System.out.println(choiceBox.getValue());
            String loginText = login.getText().trim();
            String password = this.password.getText().trim();
            User user = new User(loginText, password);

            switch (choiceBox.getValue()) {
                case "Dekan" -> user.setRole(Roles.DEKAN);
                case "Student" -> user.setRole(Roles.STUDENT);
                case "Teacher" -> user.setRole(Roles.TEACHER);
            }

            Repository repository = new Repository();
            try {
                repository.createUser(user);
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            submitButton.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/example/program_fx_test/ok_form.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();

        });
    }
}

