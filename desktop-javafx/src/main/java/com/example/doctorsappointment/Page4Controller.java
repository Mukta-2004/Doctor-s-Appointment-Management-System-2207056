package com.example.doctorsappointment;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Page4Controller {

    @FXML private Button btnYes;
    @FXML private Button btnNo;

    private AppointmentDTO appointment;  // selected appointment
    private int doctorId;               // needed to reload Page5

    public void setAppointment(AppointmentDTO appointment) {
        this.appointment = appointment;
        this.doctorId = appointment != null ? appointment.getDoctorId() : -1;
    }

    @FXML
    public void initialize() {
        btnYes.setOnAction(e -> cancelAppointmentAndGoToPage5());
        btnNo.setOnAction(e -> goBackToPage3());
    }

    private void cancelAppointmentAndGoToPage5() {
        if (appointment != null) {
            // Remove from database
            AppointmentDAO.cancelAppointment(appointment.getAppointmentId());
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("page5.fxml"));
            Scene scene = new Scene(loader.load());

            Page5Controller controller = loader.getController();
            controller.setDoctorId(doctorId);  // pass doctor_id to reload list

            Stage stage = (Stage) btnYes.getScene().getWindow();
            stage.setScene(scene);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void goBackToPage3() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("page3.fxml"));
            Scene scene = new Scene(loader.load());

            Page3Controller controller = loader.getController();
            controller.setDoctorId(doctorId);  // reload doctor’s own appointments

            Stage stage = (Stage) btnNo.getScene().getWindow();
            stage.setScene(scene);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
