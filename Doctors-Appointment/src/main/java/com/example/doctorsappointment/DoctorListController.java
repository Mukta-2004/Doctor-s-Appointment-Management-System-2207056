package com.example.doctorsappointment;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

public class DoctorListController {

    @FXML
    private Text sectorTitle;

    @FXML
    private ListView<String> doctorList;

    @FXML
    public void initialize() {
        sectorTitle.setText("Doctors for " + DoctorData.selectedSector);
        doctorList.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) { // double click
                DoctorData.selectedDoctor = doctorList.getSelectionModel().getSelectedItem();
                SceneUtil.switchScene(
                        (Stage) doctorList.getScene().getWindow(),
                        "question.fxml"
                );
            }
        });

        switch (DoctorData.selectedSector) {

            case "Orthopedic":
                doctorList.getItems().addAll(
                        "Dr. Rahman\nMBBS (DMC)\nMS (Orthopedics)\nConsultant Orthopedic Surgeon\nBMDC: B204512",
                        "Dr. Tanvir Ahmed\nMBBS (CMC)\nFCPS (Orthopedics)\nAssociate Consultant\nBMDC: O332145",
                        "Dr. Shuvo Paul\nMBBS (RMC)\nD-Ortho\nOrthopedic Specialist\nBMDC: O441278"
                );
                break;

            case "Child Specialist":
                doctorList.getItems().addAll(
                        "Dr. Sana Ahmed\nMBBS (CMC)\nMD (Pediatrics)\nChild Specialist\nBMDC: C309876",
                        "Dr. Hasan Mahmud\nMBBS (RMC)\nDCH\nConsultant Pediatrician\nBMDC: C401223",
                        "Dr. Nafisa Rahman\nMBBS (SSMC)\nFCPS (Pediatrics)\nSenior Consultant\nBMDC: C552341",
                        "Dr. Arif Hossain\nMBBS (DMC)\nMD (Neonatology)\nNeonatal Specialist\nBMDC: C667812"
                );
                break;

            case "Surgeon":
                doctorList.getItems().addAll(
                        "Dr. Rajib Baishnob\nMBBS (Sylhet MAG Osmani)\nBCS (Health)\nMS (General Surgery)\nSenior Surgeon\nBMDC: A103083",
                        "Dr. Nayeem Islam\nMBBS (DMC)\nMS (Laparoscopy)\nConsultant Surgeon\nBMDC: S667821",
                        "Dr. Megha Roy\nMBBS (SSMC)\nMS (Cardiac Surgery)\nHeart Surgeon\nBMDC: S778912",
                        "Dr. Mohashweta Deb Sneha\nMBBS (Sylhet MAG Osmani)\nMS (Neuro Surgery)\nNeurosurgeon\nBMDC: S889324"
                );
                break;

            case "Medicine Specialist":
                doctorList.getItems().addAll(
                        "Dr. Akash Sen\nMBBS (MMC)\nMD (Medicine)\nMedicine Specialist\nBMDC: M889120",
                        "Dr. Rubel Khan\nMBBS (DMC)\nFCPS (Medicine)\nConsultant Physician\nBMDC: M990231",
                        "Dr. Shirin Akter\nMBBS (CMC)\nMD (Internal Medicine)\nSenior Consultant\nBMDC: M771234",
                        "Dr. Imran Hossain\nMBBS (RMC)\nFCPS (Medicine)\nAssistant Professor\nBMDC: M664321"
                );
                break;

            case "Dept of Hematology":
                doctorList.getItems().addAll(
                        "Dr. Kamal Uddin\nMBBS (DMC)\nMD (Hematology)\nConsultant Hematologist\nBMDC: H112233",
                        "Dr. Nusrat Jahan\nMBBS (CMC)\nFCPS (Hematology)\nSenior Consultant\nBMDC: H223344",
                        "Dr. Saiful Islam\nMBBS (RMC)\nMD (Clinical Hematology)\nSpecialist\nBMDC: H334455"
                );
                break;

            case "Dept of Gynae and Obs":
                doctorList.getItems().addAll(
                        "Dr. Farzana Akter\nMBBS (DMC)\nFCPS (Gynae)\nGynecologist\nBMDC: G445566",
                        "Dr. Nafisa Tabassum Raha\nMBBS (SSMC)\nMS (Obs & Gynae)\nConsultant\nBMDC: G556677",
                        "Dr. Ruma Chowdhury\nMBBS (CMC)\nDGO\nSenior Consultant\nBMDC: G667788",
                        "Dr. Anika Islam\nMBBS (RMC)\nFCPS (Obs)\nObstetrician\nBMDC: G778899"
                );
                break;

            case "Dept of Gastroenterology":
                doctorList.getItems().addAll(
                        "Dr. Mahmud Hasan\nMBBS (DMC)\nMD (Gastro)\nConsultant\nBMDC: GA112233",
                        "Dr. Rashed Khan\nMBBS (CMC)\nFCPS (Gastro)\nSpecialist\nBMDC: GA223344",
                        "Dr. Samira Noor\nMBBS (SSMC)\nMD (Hepatology)\nSenior Consultant\nBMDC: GA334455"
                );
                break;

            case "Dept of Urology":
                doctorList.getItems().addAll(
                        "Dr. Aminul Islam\nMBBS (DMC)\nMS (Urology)\nConsultant Urologist\nBMDC: U112233",
                        "Dr. Shahriar Rahman\nMBBS (CMC)\nFCPS (Urology)\nSenior Consultant\nBMDC: U223344",
                        "Dr. Imtiaz Hossain\nMBBS (RMC)\nMS (Urology)\nSpecialist\nBMDC: U334455"
                );
                break;

            case "Dept of Neurology":
                doctorList.getItems().addAll(
                        "Dr. Salman Ahmed\nMBBS (DMC)\nMD (Neurology)\nNeurologist\nBMDC: N112233",
                        "Dr. Ritu Saha\nMBBS (CMC)\nFCPS (Neurology)\nSenior Consultant\nBMDC: N223344",
                        "Dr. Hasan Mirza\nMBBS (SSMC)\nMD (Neuro Medicine)\nSpecialist\nBMDC: N334455"
                );
                break;

            case "Dept of Psychiatry":
                doctorList.getItems().addAll(
                        "Dr. Monirul Islam\nMBBS (DMC)\nMD (Psychiatry)\nConsultant Psychiatrist\nBMDC: P112233",
                        "Dr. Shaila Akter\nMBBS (CMC)\nFCPS (Psychiatry)\nSenior Consultant\nBMDC: P223344",
                        "Dr. Rafi Ahmed\nMBBS (RMC)\nMD (Mental Health)\nSpecialist\nBMDC: P334455"
                );
                break;

            case "Dept of Pathology":
                doctorList.getItems().addAll(
                        "Dr. Nasreen Sultana\nMBBS (DMC)\nMD (Pathology)\nConsultant Pathologist\nBMDC: PA112233",
                        "Dr. Kamrul Hasan\nMBBS (CMC)\nFCPS (Pathology)\nSenior Consultant\nBMDC: PA223344",
                        "Dr. Sumi Rahman\nMBBS (SSMC)\nMD (Histopathology)\nSpecialist\nBMDC: PA334455"
                );
                break;
        }
    }
}
