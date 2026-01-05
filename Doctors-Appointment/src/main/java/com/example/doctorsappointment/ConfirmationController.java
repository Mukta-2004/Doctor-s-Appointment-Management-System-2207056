package com.example.doctorsappointment;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class ConfirmationController {

    @FXML
    private Text detailsText;

    @FXML
    public void initialize() {
        detailsText.setText(
                "Your serial number is: " + (DoctorData.slotIndex + 1) +
                        "\nAppointment time: " +
                        TimeUtil.getTimeFromSlot(DoctorData.slotIndex)
        );
    }
}
