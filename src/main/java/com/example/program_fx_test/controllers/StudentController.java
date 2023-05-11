
package com.example.program_fx_test.controllers;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.program_fx_test.dao.Repository;
import com.example.program_fx_test.entities.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class StudentController implements Initializable {
    @FXML
    public TableView<User> tableStudents;

    @FXML private TableColumn<User, String> name;
    @FXML private TableColumn<User, String> surname;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        name.setCellValueFactory(new PropertyValueFactory<User, String>("login"));
        surname.setCellValueFactory(new PropertyValueFactory<User, String>("password"));

        try {
            tableStudents.getItems().setAll(new Repository().getStudetsList());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        tableStudents.setEditable(true);
    }


}
