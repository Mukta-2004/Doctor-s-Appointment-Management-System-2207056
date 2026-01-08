package com.example.doctorsappointment;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Platform;

public class Page5Controller {

    @FXML private ListView<String> updatedSchedule;
    @FXML private Button btnBack;
    @FXML private Button btnExit;

    private ObservableList<String> appointments;

    public void setUpdatedAppointments(ObservableList<String> appointments) {
        this.appointments = appointments;
        updatedSchedule.setItems(appointments);
    }

    @FXML
    public void initialize() {

        btnBack.setOnAction(e -> goBackToPage3());
        btnExit.setOnAction(e -> Platform.exit());
    }

    private void goBackToPage3() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/example/doctorsappointment/page3.fxml")
            );

            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) btnBack.getScene().getWindow();
            stage.setScene(scene);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
