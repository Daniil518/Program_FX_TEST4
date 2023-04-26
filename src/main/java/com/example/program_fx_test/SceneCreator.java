package com.example.program_fx_test;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneCreator {

    public void newScene(String fxmlFileName) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/example/program_fx_test/"+fxmlFileName));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }
}
