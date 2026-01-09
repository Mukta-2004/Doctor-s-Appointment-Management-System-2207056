package com.example.doctorsappointment;

import javafx.application.Application;
import javafx.stage.Stage;

public class  HelloApplication extends Application {

    @Override
    public void start(Stage stage) {
        SceneUtil.switchScene(stage, "splash.fxml");
    }

    public static void main(String[] args) {
        launch();
    }
}
