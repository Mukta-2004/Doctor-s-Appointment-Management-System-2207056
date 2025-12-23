package com.example.doctorsappointment;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class firstpageController {

    @FXML
    private Button btnDoctor;

    @FXML
    private Button btnPatient;

    @FXML
    public void initialize() {

        // Doctor button → Doctor login/info page
        btnDoctor.setOnAction(e -> {
            Stage stage = (Stage) btnDoctor.getScene().getWindow();
            SceneUtil.switchScene(stage, "page2.fxml");
        });

        // Patient button → Sector list page
        btnPatient.setOnAction(e -> {
            Stage stage = (Stage) btnPatient.getScene().getWindow();
            SceneUtil.switchScene(stage, "sectorlist.fxml");
        });
    }
}
