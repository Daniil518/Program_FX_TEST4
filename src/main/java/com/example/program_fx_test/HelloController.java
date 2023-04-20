package com.example.program_fx_test;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.imageio.IIOException;

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
    void initialize() {

        next_button.setOnAction(event -> {
         String loginText = login.getText().trim();
         String loginPassword = password.getText().trim();

         if(!loginText.equals("") && !loginPassword.equals(""))
             loginUser(loginText, loginPassword);
               else
             System.out.println("Login and password is empty");
                });

        next_button.setOnAction(event -> {
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
        });
    }

    private void loginUser(String loginText, String loginPassword) {
    }

}