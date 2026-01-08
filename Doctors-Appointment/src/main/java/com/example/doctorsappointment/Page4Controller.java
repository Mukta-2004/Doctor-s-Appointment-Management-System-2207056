package com.example.doctorsappointment;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.collections.ObservableList;

public class Page4Controller {

    @FXML private Button btnYes;
    @FXML private Button btnNo;

    private ObservableList<String> appointments;
    private String selectedAppointment;

    public void setData(ObservableList<String> appointments, String selectedAppointment) {
        this.appointments = appointments;
        this.selectedAppointment = selectedAppointment;
    }

    @FXML
    public void initialize() {

        btnYes.setOnAction(e -> {
            appointments.remove(selectedAppointment);
            goToPage5();
        });

        btnNo.setOnAction(e -> goBackToPage3());
    }

    private void goToPage5() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/example/doctorsappointment/page5.fxml")
            );

            Scene scene = new Scene(loader.load());
            Page5Controller controller = loader.getController();
            controller.setUpdatedAppointments(appointments);

            Stage stage = (Stage) btnYes.getScene().getWindow();
            stage.setScene(scene);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void goBackToPage3() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/example/doctorsappointment/page3.fxml")
            );

            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) btnNo.getScene().getWindow();
            stage.setScene(scene);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
