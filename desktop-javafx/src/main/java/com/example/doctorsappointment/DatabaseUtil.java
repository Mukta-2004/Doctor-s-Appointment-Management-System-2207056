package com.example.doctorsappointment;

import java.sql.*;

public class DatabaseUtil {

    private static final String DB_URL = "jdbc:sqlite:appointment.db";

    static {
        try (Connection con = getConnection();
             Statement st = con.createStatement()) {

            st.execute("""
                CREATE TABLE IF NOT EXISTS doctor (
                    doctor_id INTEGER PRIMARY KEY AUTOINCREMENT,
                    doctor_name TEXT NOT NULL,
                    email TEXT NOT NULL
                )
            """);

            st.execute("""
                CREATE TABLE IF NOT EXISTS patient (
                    patient_id INTEGER PRIMARY KEY AUTOINCREMENT,
                    patient_name TEXT NOT NULL,
                    phone TEXT NOT NULL
                )
            """);

            st.execute("""
                CREATE TABLE IF NOT EXISTS appointment (
                    appointment_id INTEGER PRIMARY KEY AUTOINCREMENT,
                    doctor_id INTEGER,
                    patient_id INTEGER,
                    slot_time TEXT,
                    serial_no INTEGER,
                    FOREIGN KEY (doctor_id) REFERENCES doctor(doctor_id),
                    FOREIGN KEY (patient_id) REFERENCES patient(patient_id)
                )
            """);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }
}
