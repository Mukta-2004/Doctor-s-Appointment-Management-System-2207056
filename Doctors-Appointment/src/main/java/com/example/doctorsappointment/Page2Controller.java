package com.example.doctorsappointment;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class Page2Controller {

    @FXML private TextField txtName;
    @FXML private TextField txtEmail;
    @FXML private TextField txtID;
    @FXML private Button btnSubmit;

    @FXML
    public void initialize() {
        btnSubmit.setOnAction(e -> openAppointmentsPage());
    }

    private void openAppointmentsPage() {
        try {
            Stage stage = (Stage) btnSubmit.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("page3.fxml"));
            stage.setScene(new Scene(loader.load()));
            stage.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
