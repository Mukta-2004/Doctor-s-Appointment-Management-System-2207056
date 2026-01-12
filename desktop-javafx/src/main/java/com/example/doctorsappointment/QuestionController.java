package com.example.doctorsappointment;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class QuestionController {

    @FXML
    private TextField txtPatientName;

    @FXML
    private TextField txtPhone;

    // Info from previous page
    private String doctorName;
    private String timeSlot;

    public void setDoctorInfo(String doctorName, String timeSlot) {
        this.doctorName = doctorName;
        this.timeSlot = timeSlot;
    }

    @FXML
    private void saveAppointment() {
        String patient = txtPatientName.getText().trim();
        String phone = txtPhone.getText().trim();

        if (patient.isEmpty() || phone.isEmpty()) {
            System.out.println("Patient name or phone is empty!");
            return;
        }

        // Save appointment → returns slot index or -1 if full
        int slotIndex = AppointmentDAO.saveAppointment(doctorName, patient, phone);

        Stage stage = (Stage) txtPatientName.getScene().getWindow();

        try {
            FXMLLoader loader;
            if (slotIndex == -1) {
                // No slots available → go to availability page
                loader = new FXMLLoader(getClass().getResource(
                        "/com/example/doctorsappointment/availability.fxml"));
                Scene scene = new Scene(loader.load());
                stage.setScene(scene);
            } else {
                // Go to confirmation page
                loader = new FXMLLoader(getClass().getResource(
                        "/com/example/doctorsappointment/confirmation.fxml"));
                Scene scene = new Scene(loader.load());

                // Pass patient info to confirmation controller
                ConfirmationController controller = loader.getController();
                if (controller != null) {
                    controller.setPatientInfo(patient, phone, slotIndex);
                }

                stage.setScene(scene);
            }

            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to load FXML. Check the path and fx:controller!");
        }
    }

    @FXML
    private void onNo() {
        // Example: go back to previous page (doctor list)
        Stage stage = (Stage) txtPatientName.getScene().getWindow();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/com/example/doctorsappointment/doctorlist.fxml"));
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
