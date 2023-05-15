package com.example.program_fx_test.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.program_fx_test.SceneCreator;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HomeController {

    @FXML
    private Button Reference;

    @FXML
    private Button dekan;

    @FXML
    private Button students;

    @FXML
    private Button teachers;

    private SceneCreator sceneCreator = new SceneCreator();


    @FXML
    void initialize() {
        dekan.setOnAction(event -> {
          sceneCreator.newScene("Director.fxml");});
        Reference.setOnAction(event -> {
            sceneCreator.newScene("text.fxml");
        });
        students.setOnAction(event -> {
            sceneCreator.newScene("Student.fxml");
        });
        teachers.setOnAction(event -> {
            sceneCreator.newScene("Teacher.fxml");
        });
    }

}
