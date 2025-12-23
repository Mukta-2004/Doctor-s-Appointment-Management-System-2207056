package com.example.doctorsappointment;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class firstpageController {

    @FXML
    private Button btnDoctor;

    @FXML
    public void initialize() {
        btnDoctor.setOnAction(e -> {
            Stage stage = (Stage) btnDoctor.getScene().getWindow();
            SceneUtil.switchScene(stage, "page2.fxml");
        });
    }

        private void goToDoctorPage() {
            try {
                Stage stage = (Stage) btnDoctor.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("page2.fxml"));
                stage.setScene(new Scene(loader.load()));
                stage.show();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

