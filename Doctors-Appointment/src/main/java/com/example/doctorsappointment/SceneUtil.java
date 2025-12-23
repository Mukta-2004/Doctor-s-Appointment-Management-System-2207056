package com.example.doctorsappointment;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneUtil {

    public static void switchScene(Stage stage, String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    SceneUtil.class.getResource(fxml)
            );

            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setMaximized(true);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
