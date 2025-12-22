package com.example.doctorsappointment;

import javafx.animation.PauseTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SplashController {

    public void initialize() {
        PauseTransition pause = new PauseTransition(Duration.seconds(2));

        pause.setOnFinished(e -> {
            try {
                Stage stage = (Stage) Stage.getWindows().get(0);
                FXMLLoader loader = new FXMLLoader(
                        HelloApplication.class.getResource("firstpage.fxml")
                );
                stage.setScene(new Scene(loader.load(), 600, 400));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        pause.play();
    }
}
