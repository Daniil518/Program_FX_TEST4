package com.example.program_fx_test.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.program_fx_test.Application;
import com.example.program_fx_test.SceneCreator;
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
    private TextField login;

    @FXML
    private Button next_button;

    @FXML
    private PasswordField password;

    @FXML
    private Button regButton;

    private final SceneCreator sceneCreator = new SceneCreator();

    private final Repository repository = new Repository();

    @FXML
    void initialize() {
        next_button.setOnAction(event -> {
         String loginText = login.getText().trim();
         String password = this.password.getText().trim();
         User user = new User(loginText, password);
            try {
                User userFromDb = repository.getUser(user.getLogin());
                System.out.println(userFromDb.getRole());
                Application.setCurrentUser(userFromDb);
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            try {
                if(repository.checkUser(user)){
                    next_button.getScene().getWindow().hide();
                    sceneCreator.newScene("Home.fxml");
                } else {
                    System.out.println("i am here");
                    sceneCreator.newScene("login_wrong_form.fxml");
                }
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            if(!loginText.equals("") && !password.equals(""))
             loginUser(loginText, password);
               else
             System.out.println("Login and password is empty");
                });
        regButton.setOnAction(event -> {
            sceneCreator.newScene("registration-from.fxml");
        });
    }

    private void loginUser(String loginText, String loginPassword) {
    }
}