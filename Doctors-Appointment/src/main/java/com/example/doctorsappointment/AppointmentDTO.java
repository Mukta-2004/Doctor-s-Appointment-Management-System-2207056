package com.example.doctorsappointment;

public class AppointmentDTO {
    private int appointmentId;
    private int doctorId;       // NEW FIELD
    private String patientName;
    private String phone;
    private String time;

    public AppointmentDTO(int appointmentId, int doctorId, String patientName, String phone, String time) {
        this.appointmentId = appointmentId;
        this.doctorId = doctorId;
        this.patientName = patientName;
        this.phone = phone;
        this.time = time;
    }

    public int getAppointmentId() { return appointmentId; }
    public int getDoctorId() { return doctorId; } // NEW GETTER
    public String getPatientName() { return patientName; }
    public String getPhone() { return phone; }
    public String getTime() { return time; }

    @Override
    public String toString() {
        return time + " - Patient: " + patientName;
    }
}
