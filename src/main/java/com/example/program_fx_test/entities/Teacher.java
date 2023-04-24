package com.example.program_fx_test.entities;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Teacher {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<?, ?> FamiliaColumn;

    @FXML
    private TableColumn<?, ?> NameColumn;

    @FXML
    private TableColumn<?, ?> OthestvoColumn;

    @FXML
    private TableColumn<?, ?> idColumn;

    @FXML
    private TableView<?> tableUsers;

    @FXML
    void initialize() {
        assert FamiliaColumn != null : "fx:id=\"FamiliaColumn\" was not injected: check your FXML file 'Teacher.fxml'.";
        assert NameColumn != null : "fx:id=\"NameColumn\" was not injected: check your FXML file 'Teacher.fxml'.";
        assert OthestvoColumn != null : "fx:id=\"OthestvoColumn\" was not injected: check your FXML file 'Teacher.fxml'.";
        assert idColumn != null : "fx:id=\"idColumn\" was not injected: check your FXML file 'Teacher.fxml'.";
        assert tableUsers != null : "fx:id=\"tableUsers\" was not injected: check your FXML file 'Teacher.fxml'.";

    }

}