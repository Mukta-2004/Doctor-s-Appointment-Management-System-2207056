package com.example.doctorsappointment_android.models;

public class PatientAppointment {
    public String doctor_id;
    public String doctor_name;
    public int slot;
    public String time;

    public PatientAppointment() {}

    public PatientAppointment(String doctor_id, String doctor_name, int slot, String time) {
        this.doctor_id = doctor_id;
        this.doctor_name = doctor_name;
        this.slot = slot;
        this.time = time;
    }
}
