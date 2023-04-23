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
         String password = this.password.getText().trim();
         User user;

            try {
                user  = getUserFormDb(loginText, password);
            } catch (Exception e) {
                //TODO pop up new scene like allert that user not found;
            }


            if(!loginText.equals("") && !password.equals(""))
             loginUser(loginText, password);
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

    private User getUserFormDb(String login, String password) throws Exception{
        //TODO Go to db, find user
        return null;
    }

}