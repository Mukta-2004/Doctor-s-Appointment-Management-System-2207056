package com.example.doctorsappointment;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class QuestionController {

    @FXML
    private Text questionText;

    @FXML
    private TextField nameField;

    @FXML
    private TextField phoneField;

    @FXML
    public void initialize() {
        questionText.setText(
                "Doctor is available from 10:00 AM to 8:00 PM.\n" +
                        "Do you want to confirm appointment?"
        );
    }

    @FXML
    void onYes() {
        String name = nameField.getText().trim();
        String phone = phoneField.getText().trim();

        if (name.isEmpty() || phone.isEmpty()) {
            questionText.setText(
                    "Please enter patient name and phone number.\n" +
                            "Do you want to confirm appointment?"
            );
            return;
        }

        DoctorData.patientName = name;
        DoctorData.patientPhone = phone;

        Stage stage = (Stage) questionText.getScene().getWindow();

        int slot = AppointmentService.getNextAvailableSlot(
                DoctorData.selectedDoctor
        );

        if (slot == -1) {
            SceneUtil.switchScene(stage, "availability.fxml");
        } else {
            DoctorData.slotIndex = slot;
            AppointmentService.bookAppointment(
                    DoctorData.selectedDoctor, slot
            );
            SceneUtil.switchScene(stage, "confirmation.fxml");
        }
    }

    @FXML
    void onNo() {
        System.exit(0);
    }
}
