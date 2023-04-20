
package com.example.program_fx_test;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Student {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<?, ?> FamiliaColumn1;

    @FXML
    private TableColumn<?, ?> NameColumn1;

    @FXML
    private TableColumn<?, ?> OthestvoColumn1;

    @FXML
    private TableColumn<?, ?> idColumn1;

    @FXML
    private TableView<?> tableUsers;

    @FXML
    void initialize() {
        assert FamiliaColumn1 != null : "fx:id=\"FamiliaColumn1\" was not injected: check your FXML file 'Student.fxml'.";
        assert NameColumn1 != null : "fx:id=\"NameColumn1\" was not injected: check your FXML file 'Student.fxml'.";
        assert OthestvoColumn1 != null : "fx:id=\"OthestvoColumn1\" was not injected: check your FXML file 'Student.fxml'.";
        assert idColumn1 != null : "fx:id=\"idColumn1\" was not injected: check your FXML file 'Student.fxml'.";
        assert tableUsers != null : "fx:id=\"tableUsers\" was not injected: check your FXML file 'Student.fxml'.";

    }

}
