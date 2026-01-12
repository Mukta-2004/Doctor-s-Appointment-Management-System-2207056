package com.example.doctorsappointment;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class ConfirmationController {

    @FXML
    private Text detailsText;

    private String patientName;
    private String phone;
    private int slotIndex;

    // Called from QuestionController
    public void setPatientInfo(String patientName, String phone, int slotIndex) {
        this.patientName = patientName;
        this.phone = phone;
        this.slotIndex = slotIndex;

        detailsText.setText(
                "Your serial number is: " + (slotIndex + 1) +
                        "\nAppointment time: " + TimeUtil.getTimeFromSlot(slotIndex)
        );
    }

    @FXML
    private void onOk() {
        // Go back to doctor list page
        Stage stage = (Stage) detailsText.getScene().getWindow();
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
