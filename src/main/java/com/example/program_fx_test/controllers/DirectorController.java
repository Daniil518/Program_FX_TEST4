package com.example.program_fx_test.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class DirectorController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView chemirosova;

    @FXML
    private Text text_chemirosova;

    @FXML
    void initialize() {
        assert chemirosova != null : "fx:id=\"chemirosova\" was not injected: check your FXML file 'Dekan.fxml'.";
        assert text_chemirosova != null : "fx:id=\"text_chemirosova\" was not injected: check your FXML file 'Dekan.fxml'.";

    }

}
