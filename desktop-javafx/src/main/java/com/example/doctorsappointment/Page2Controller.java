package com.example.doctorsappointment;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class Page2Controller {

    public TextField txtName;
    @FXML private TextField txtDoctorName;
    @FXML private TextField txtEmail;
    @FXML private TextField txtID; // optional, not used in DB
    @FXML private Button btnSubmit;

    @FXML
    private void initialize() {
        if (btnSubmit != null) {
            btnSubmit.setOnAction(e -> loginDoctor());
        } else {
            System.out.println("btnSubmit is null! Check your FXML fx:id");
        }
    }

    private void loginDoctor() {
        try {
            String name = txtName.getText().trim();
            String email = txtEmail.getText().trim();
            String id = txtID.getText().trim(); // can be ignored

            if (name.isEmpty() || email.isEmpty() || id.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all fields!");
                alert.showAndWait();
                return;
            }

            // Fetch or create doctor in DB
            int doctorId = DoctorDashboardDAO.getOrCreateDoctorId(name, email);

            if (doctorId == -1) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Unable to login doctor. Check DB!");
                alert.showAndWait();
                return;
            }

            // Load Page3
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/doctorsappointment/page3.fxml"));
            Scene scene = new Scene(loader.load());

            Page3Controller controller = loader.getController();
            controller.setDoctorId(doctorId); // pass doctor id
            controller.setDoctorName(name);   // optional display

            Stage stage = (Stage) btnSubmit.getScene().getWindow();
            stage.setScene(scene);

        } catch (Exception ex) {
            ex.printStackTrace(); // show the real error in console
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Something went wrong! Check console for details.");
            alert.showAndWait();
        }
    }
}