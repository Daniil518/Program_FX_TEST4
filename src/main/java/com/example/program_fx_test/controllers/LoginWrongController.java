package com.example.program_fx_test.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LoginWrongController {
    @FXML
    private Button okButton;
    @FXML
    void initialize() {
        okButton.setOnAction(event -> {
            okButton.getScene().getWindow().hide();
        });
    }
}
