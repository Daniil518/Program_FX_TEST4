package com.example.program_fx_test;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javax.imageio.IIOException;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class ReferenceController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField date;

    @FXML
    private TextField signature;

    @FXML
    private TextField statement;

    @FXML
    private TextField whom;

    @FXML
    void initialize() {
        assert date != null : "fx:id=\"date\" was not injected: check your FXML file 'reference.fxml'.";
        assert signature != null : "fx:id=\"signature\" was not injected: check your FXML file 'reference.fxml'.";
        assert statement != null : "fx:id=\"statement\" was not injected: check your FXML file 'reference.fxml'.";
        assert whom != null : "fx:id=\"whom\" was not injected: check your FXML file 'reference.fxml'.";

    }

}