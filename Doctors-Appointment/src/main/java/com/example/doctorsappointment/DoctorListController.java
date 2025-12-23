package com.example.doctorsappointment;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

public class DoctorListController {

    @FXML
    private Text sectorTitle;

    @FXML
    private ListView<String> doctorList;

    @FXML
    public void initialize() {
        sectorTitle.setText("Doctors for " + DoctorData.selectedSector);

        switch (DoctorData.selectedSector) {
            case "Orthopedic":
                doctorList.getItems().addAll(
                        "Dr. Rahman – Orthopedic",
                        "Dr. Ali – Bone Specialist"
                );
                break;

            case "Child Specialist":
                doctorList.getItems().addAll(
                        "Dr. Sana – Pediatrician",
                        "Dr. Hasan – Child Care"
                );
                break;

            case "Surgeon":
                doctorList.getItems().addAll(
                        "Dr. Karim – General Surgeon",
                        "Dr. Nayeem – Laparoscopic Surgeon"
                );
                break;

            case "Medicine Specialist":
                doctorList.getItems().addAll(
                        "Dr. Akash – Medicine",
                        "Dr. Rubel – Internal Medicine"
                );
                break;
        }
    }
}
