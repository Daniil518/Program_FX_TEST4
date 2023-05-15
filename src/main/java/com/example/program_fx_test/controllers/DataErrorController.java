package com.example.program_fx_test.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class DataErrorController {

    @FXML
    private Button button;

    @FXML
    public void initialize() {
        button.setOnAction(event -> {
            button.getScene().getWindow().hide();
        });

    }
}
