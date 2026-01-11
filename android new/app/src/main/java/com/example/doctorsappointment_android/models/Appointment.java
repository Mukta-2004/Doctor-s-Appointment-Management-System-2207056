package com.example.doctorsappointment_android.models;

public class Appointment {
    public String patient_name;
    public String patient_phone;
    public int serial;

    public Appointment() {} // Required for Firebase

    public Appointment(String patient_name, String patient_phone, int serial) {
        this.patient_name = patient_name;
        this.patient_phone = patient_phone;
        this.serial = serial;
    }
}
