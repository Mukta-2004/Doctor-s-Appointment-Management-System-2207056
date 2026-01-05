package com.example.doctorsappointment;

import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class AvailabilityController {

    public void goBack(ActionEvent event) {
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource())
                .getScene().getWindow();
        SceneUtil.switchScene(stage, "doctorlist.fxml");
    }

    public void exit() {
        System.exit(0);
    }
}
