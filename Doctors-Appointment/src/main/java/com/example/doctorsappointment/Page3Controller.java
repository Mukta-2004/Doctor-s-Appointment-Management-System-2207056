package com.example.doctorsappointment;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.collections.FXCollections;

public class Page3Controller {

    @FXML private ListView<String> listAppointments;

    @FXML
    public void initialize() {
        // SAMPLE DATA FOR NOW
        listAppointments.setItems(FXCollections.observableArrayList(
                "10:00 AM - Patient: Noman",
                "10:30 AM - Patient: Moumia",
                "11:00 AM - Patient: Rahim",
                "12:00 PM - Patient: Mou"
        ));
    }
}
