package com.example.doctorsappointment;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class SectorListController {

    private void goToDoctorList(ActionEvent event, String sector) {
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource())
                .getScene().getWindow();
        DoctorData.selectedSector = sector;
        SceneUtil.switchScene(stage, "doctorlist.fxml");
    }

    @FXML
    void openOrthopedic(ActionEvent event) {
        goToDoctorList(event, "Orthopedic");
    }

    @FXML
    void openChild(ActionEvent event) {
        goToDoctorList(event, "Child Specialist");
    }

    @FXML
    void openSurgeon(ActionEvent event) {
        goToDoctorList(event, "Surgeon");
    }

    @FXML
    void openMedicine(ActionEvent event) {
        goToDoctorList(event, "Medicine Specialist");
    }
}
