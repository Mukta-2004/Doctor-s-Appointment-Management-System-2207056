package com.example.doctorsappointment;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class ConfirmationController {

    @FXML
    private Text detailsText;

    private String patientName;
    private String phone;
    private int slotIndex;

    // This method will be called from QuestionController
    public void setPatientInfo(String patientName, String phone, int slotIndex) {
        this.patientName = patientName;
        this.phone = phone;
        this.slotIndex = slotIndex;

        detailsText.setText(
                "Your serial number is: " + (slotIndex + 1) +
                        "\nAppointment time: " + TimeUtil.getTimeFromSlot(slotIndex)
        );
    }
}
