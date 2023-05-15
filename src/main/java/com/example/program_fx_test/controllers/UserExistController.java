package com.example.program_fx_test.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class UserExistController implements Initializable {

    @FXML
    private Button okButton;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        okButton.setOnAction(event ->

                okButton.getScene().getWindow().hide());

    }
}
