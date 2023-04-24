package com.example.program_fx_test.controllers;

import com.example.program_fx_test.dao.Repository;
import com.example.program_fx_test.entities.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class RegistrationController {

    @FXML
    private TextField login;

    @FXML
    private TextField password;

    @FXML
    private Button submitButton;


    @FXML
    void initialize() {
        submitButton.setOnAction(event -> {
            String loginText = login.getText().trim();
            String password = this.password.getText().trim();

            User user = new User(loginText, password);
            Repository repository = new Repository();
            try {
                repository.createUser(user);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
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
