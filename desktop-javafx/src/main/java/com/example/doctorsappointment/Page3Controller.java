package com.example.doctorsappointment;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;

public class Page3Controller {

    @FXML private ListView<AppointmentDTO> listAppointments;
    @FXML private Text txtEmpty;

    private int doctorId;
    private String doctorName;

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
        loadDoctorData();
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public void loadDoctorData() {
        List<AppointmentDTO> data = DoctorDashboardDAO.getAppointments(doctorId);

        if (data.isEmpty()) {
            txtEmpty.setVisible(true);
            listAppointments.setVisible(false);
        } else {
            txtEmpty.setVisible(false);
            listAppointments.setVisible(true);

            ObservableList<AppointmentDTO> obsData = FXCollections.observableArrayList(data);
            listAppointments.setItems(obsData);

            listAppointments.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2) {
                    AppointmentDTO selected = listAppointments.getSelectionModel().getSelectedItem();
                    if (selected == null) return;

                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("page4.fxml"));
                        Scene scene = new Scene(loader.load());

                        Page4Controller controller = loader.getController();
                        controller.setAppointment(selected); // pass selected appointment

                        Stage stage = (Stage) listAppointments.getScene().getWindow();
                        stage.setScene(scene);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}