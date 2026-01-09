package com.example.doctorsappointment;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

public class QuestionController {

    @FXML private TextField txtPatientName;
    @FXML private TextField txtPhone;

    // set from previous page
    private String doctorName;
    private String timeSlot;

    public void setDoctorInfo(String doctorName, String timeSlot) {
        this.doctorName = doctorName;
        this.timeSlot = timeSlot;
    }
    @FXML
    private void saveAppointment() {

        String patient = txtPatientName.getText();
        String phone = txtPhone.getText();

        if (patient.isEmpty() || phone.isEmpty()) return;

        // Save appointment and get assigned slot
        int slotIndex = AppointmentDAO.saveAppointment(doctorName, patient, phone);

        Stage stage = (Stage) txtPatientName.getScene().getWindow();

        try {
            if (slotIndex == -1) {
                // No slots → Availability page
                SceneUtil.switchScene(stage, "availability.fxml");
            } else {
                // Navigate to confirmation page
                FXMLLoader loader = new FXMLLoader(getClass().getResource("confirmation.fxml"));
                Scene scene = new Scene(loader.load());

                ConfirmationController controller = loader.getController();
                controller.setPatientInfo(patient, phone, slotIndex);

                stage.setScene(scene);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onNo() {
        // go back / close / navigate
    }
}
