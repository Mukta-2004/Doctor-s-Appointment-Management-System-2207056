package com.example.doctorsappointment;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class AvailabilityController {

    public void goBack(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneUtil.switchScene(stage, "doctorlist.fxml");
    }

    public void exit(ActionEvent event) {
        System.exit(0);
    }
}
