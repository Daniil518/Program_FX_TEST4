package com.example.program_fx_test.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HomeController {

    @FXML
    private AnchorPane root;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Reference;

    @FXML
    private Button dekan;

    @FXML
    private Button students;

    @FXML
    private Button teachers;

    @FXML
    void initialize() {
        dekan.setOnAction(event -> {
          dekan.getScene().getWindow().hide();

            FXMLLoader loader1 = new FXMLLoader();
            loader1.setLocation(getClass().getResource("/com/example/program_fx_test/Director.fxml"));

            try {
                loader1.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root1 = loader1.getRoot();
            Stage stage1 = new Stage();
            stage1.setScene(new Scene(root1));
            stage1.showAndWait();
        });
        Reference.setOnAction(event -> {
            Reference.getScene().getWindow().hide();

            FXMLLoader loader2 = new FXMLLoader();
            loader2.setLocation(getClass().getResource("/com/example/program_fx_test/Reference.fxml"));

            try {
                loader2.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root2 = loader2.getRoot();
            Stage stage2 = new Stage();
            stage2.setScene(new Scene(root2));
            stage2.showAndWait();
        });
        students.setOnAction(event -> {
            students.getScene().getWindow().hide();

            FXMLLoader loader1 = new FXMLLoader();
            loader1.setLocation(getClass().getResource("/com/example/program_fx_test/Students_new.fxml"));

            try {
                loader1.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root1 = loader1.getRoot();
            Stage stage1 = new Stage();
            stage1.setScene(new Scene(root1));
            stage1.showAndWait();
        });
        teachers.setOnAction(event -> {
            teachers.getScene().getWindow().hide();

            FXMLLoader loader1 = new FXMLLoader();
            loader1.setLocation(getClass().getResource("/com/example/program_fx_test/Teacher.fxml"));

            try {
                loader1.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root1 = loader1.getRoot();
            Stage stage1 = new Stage();
            stage1.setScene(new Scene(root1));
            stage1.showAndWait();
        });
    }

}
