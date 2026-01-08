package com.example.doctorsappointment;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Page3Controller {

    @FXML
    private ListView<String> listAppointments;

    @FXML
    public void initialize() {
        listAppointments.setItems(FXCollections.observableArrayList(
                "10:00 AM - Patient: Noman",
                "10:30 AM - Patient: Moumia",
                "11:00 AM - Patient: Rahim",
                "12:00 PM - Patient: Mou"
        ));

        listAppointments.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {

                String selected = listAppointments.getSelectionModel().getSelectedItem();
                if (selected == null) return;

                try {
                    FXMLLoader loader = new FXMLLoader(
                            getClass().getResource("page4.fxml")
                    );

                    Scene scene = new Scene(loader.load());
                    Page4Controller controller = loader.getController();

                    controller.setData(
                            listAppointments.getItems(),
                            selected
                    );

                    Stage stage = (Stage) listAppointments.getScene().getWindow();
                    stage.setScene(scene);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
