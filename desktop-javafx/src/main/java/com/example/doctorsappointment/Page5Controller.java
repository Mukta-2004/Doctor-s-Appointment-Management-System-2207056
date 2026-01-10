package com.example.doctorsappointment;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class Page5Controller {

    @FXML private ListView<AppointmentDTO> updatedSchedule;
    @FXML private Button btnBack;
    @FXML private Button btnExit;

    private int doctorId;

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
        loadUpdatedAppointments();
    }

    @FXML
    public void initialize() {
        btnBack.setOnAction(e -> goBackToPage3());
        btnExit.setOnAction(e -> Platform.exit());
    }

    private void loadUpdatedAppointments() {
        if (doctorId == -1) return;

        List<AppointmentDTO> appointments = DoctorDashboardDAO.getAppointments(doctorId);
        ObservableList<AppointmentDTO> obs = FXCollections.observableArrayList(appointments);
        updatedSchedule.setItems(obs);
    }

    private void goBackToPage3() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("page3.fxml"));
            Scene scene = new Scene(loader.load());

            Page3Controller controller = loader.getController();
            controller.setDoctorId(doctorId);  // reload this doctor’s list

            Stage stage = (Stage) btnBack.getScene().getWindow();
            stage.setScene(scene);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
