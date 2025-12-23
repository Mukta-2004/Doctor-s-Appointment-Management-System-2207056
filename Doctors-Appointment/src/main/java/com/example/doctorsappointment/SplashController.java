package com.example.doctorsappointment;

import javafx.animation.PauseTransition;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SplashController {

    public void initialize() {

        PauseTransition delay = new PauseTransition(Duration.seconds(3));

        delay.setOnFinished(e -> {
            Stage stage = (Stage) Stage.getWindows().get(0);
            SceneUtil.switchScene(stage, "firstpage.fxml");
        });

        delay.play();
    }
}
