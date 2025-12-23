package com.example.doctorsappointment;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneUtil {

    // Normal scene switch (used by splash, others)
    public static void switchScene(Stage stage, String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    SceneUtil.class.getResource(fxml)
            );
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // FIXED SIZE — ONLY FOR FIRST PAGE
    public static void switchSceneFixed(Stage stage, String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    SceneUtil.class.getResource(fxml)
            );
            Scene scene = new Scene(loader.load(), 800, 600);

            stage.setScene(scene);
            stage.setResizable(false); // optional
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
