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

            scene.getStylesheets().add(
                    SceneUtil.class.getResource("app.css").toExternalForm()
            );

            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void switchSceneFixed(Stage stage, String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    SceneUtil.class.getResource(fxml)
            );

            Scene scene = new Scene(loader.load(), 800, 600);

            scene.getStylesheets().add(
                    SceneUtil.class.getResource("app.css").toExternalForm()
            );

            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
