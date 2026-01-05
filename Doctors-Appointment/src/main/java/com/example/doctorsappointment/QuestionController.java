package com.example.doctorsappointment;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class QuestionController {

    @FXML
    private Text questionText;

    @FXML
    public void initialize() {
        questionText.setText(
                "Doctor is available from 10:00 AM to 8:00 PM.\n" +
                        "Do you want to confirm appointment?"
        );
    }

    @FXML
    void onYes() {
        Stage stage = (Stage) questionText.getScene().getWindow();

        int slot = AppointmentService.getNextAvailableSlot(
                DoctorData.selectedDoctor);

        if (slot == -1) {
            SceneUtil.switchScene(stage, "availability.fxml");
        } else {
            DoctorData.slotIndex = slot;
            AppointmentService.bookAppointment(
                    DoctorData.selectedDoctor, slot);
            SceneUtil.switchScene(stage, "confirmation.fxml");
        }
    }

    @FXML
    void onNo() {
        System.exit(0);
    }
}
