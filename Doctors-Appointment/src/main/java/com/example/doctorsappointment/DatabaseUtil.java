package com.example.doctorsappointment;

import java.sql.*;

public class DatabaseUtil {

    private static final String URL = "jdbc:sqlite:appointments.db";

    static {
        try (Connection con = DriverManager.getConnection(URL);
             Statement st = con.createStatement()) {

            st.execute("""
                CREATE TABLE IF NOT EXISTS doctor (
                    doctor_id INTEGER PRIMARY KEY AUTOINCREMENT,
                    doctor_name TEXT UNIQUE
                )
            """);

            st.execute("""
                CREATE TABLE IF NOT EXISTS patient (
                    patient_id INTEGER PRIMARY KEY AUTOINCREMENT,
                    patient_name TEXT,
                    phone TEXT
                )
            """);

            st.execute("""
                CREATE TABLE IF NOT EXISTS appointment_details (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    doctor_id INTEGER,
                    patient_id INTEGER,
                    appointment_time TEXT,
                    FOREIGN KEY (doctor_id) REFERENCES doctor(doctor_id),
                    FOREIGN KEY (patient_id) REFERENCES patient(patient_id)
                )
            """);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}
