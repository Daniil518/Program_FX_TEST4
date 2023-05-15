package com.example.program_fx_test.controllers;

import com.example.program_fx_test.SceneCreator;
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
    private TextField name;
    @FXML
    private TextField surname;

    @FXML
    private ComboBox<String> choiceBox;

    private final Repository repository = new Repository();

    private final SceneCreator sceneCreator = new SceneCreator();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        submitButton.setOnAction(event -> {
            String loginText = login.getText().trim();
            String password = this.password.getText().trim();
            String name = this.name.getText().trim();
            String surname = this.surname.getText().trim();



            User user = new User(loginText, password, name, surname);

            try {
                if(repository.checkUserIfExist(user)){
                    sceneCreator.newScene("UserExistForm.fxml");
                    return;
                }
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            System.out.println(user.getLogin()+" "+user.getPassword());
                try{
                    switch (choiceBox.getValue()) {
                        case "Dekan" -> user.setRole(Roles.DEKAN);
                        case "Student" -> user.setRole(Roles.STUDENT);
                        case "Teacher" -> user.setRole(Roles.TEACHER);
                    }
                } catch (RuntimeException e) {
                    sceneCreator.newScene("dataError.fxml");
                }
            switch (choiceBox.getValue()) {
                case "Dekan" -> user.setRole(Roles.DEKAN);
                case "Student" -> user.setRole(Roles.STUDENT);
                case "Teacher" -> user.setRole(Roles.TEACHER);
            }



            try {
                repository.createUser(user);
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
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (NullPointerException e){
                sceneCreator.newScene("dataError.fxml");
            }


        });
    }
}

