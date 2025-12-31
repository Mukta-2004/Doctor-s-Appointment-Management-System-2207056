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

    @FXML void openOrthopedic(ActionEvent event) {
        goToDoctorList(event, "Orthopedic");
    }

    @FXML void openChild(ActionEvent event) {
        goToDoctorList(event, "Child Specialist");
    }

    @FXML void openSurgeon(ActionEvent event) {
        goToDoctorList(event, "Surgeon");
    }

    @FXML void openMedicine(ActionEvent event) {
        goToDoctorList(event, "Medicine Specialist");
    }

    @FXML void openHematology(ActionEvent event) {
        goToDoctorList(event, "Dept of Hematology");
    }

    @FXML void openGynae(ActionEvent event) {
        goToDoctorList(event, "Dept of Gynae and Obs");
    }

    @FXML void openGastro(ActionEvent event) {
        goToDoctorList(event, "Dept of Gastroenterology");
    }

    @FXML void openUrology(ActionEvent event) {
        goToDoctorList(event, "Dept of Urology");
    }

    @FXML void openNeurology(ActionEvent event) {
        goToDoctorList(event, "Dept of Neurology");
    }

    @FXML void openPsychiatry(ActionEvent event) {
        goToDoctorList(event, "Dept of Psychiatry");
    }

    @FXML void openPathology(ActionEvent event) {
        goToDoctorList(event, "Dept of Pathology");
    }
}
