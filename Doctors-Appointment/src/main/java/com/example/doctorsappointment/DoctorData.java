package com.example.doctorsappointment;
public class DoctorData {
    public static String selectedSector;
    public static String selectedDoctor;

    // mock data
    public static boolean doctorAvailable = Math.random() > 0.5;
    public static int serialNumber = (int)(Math.random() * 20 + 1);
    public static String appointmentTime = "5:30 PM";
}
