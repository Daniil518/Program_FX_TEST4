package com.example.program_fx_test.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.program_fx_test.dao.Repository;
import com.example.program_fx_test.entities.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField login;

    @FXML
    private Button next_button;

    @FXML
    private PasswordField password;

    @FXML
    private Button regButton;

    private final Repository repository = new Repository();

    @FXML
    void initialize() {

        next_button.setOnAction(event -> {
         String loginText = login.getText().trim();
         String password = this.password.getText().trim();
         User user = new User(loginText, password);
            try {
                if(repository.checkUser(user)){
                    next_button.getScene().getWindow().hide();

                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/com/example/program_fx_test/Home.fxml"));

                    try {
                        loader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    Parent root = loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.showAndWait();

                } else {
                    System.out.println("i am here");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }


            if(!loginText.equals("") && !password.equals(""))
             loginUser(loginText, password);
               else
             System.out.println("Login and password is empty");
                });

        regButton.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/example/program_fx_test/registration-from.fxml"));

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

    private void loginUser(String loginText, String loginPassword) {
    }


}