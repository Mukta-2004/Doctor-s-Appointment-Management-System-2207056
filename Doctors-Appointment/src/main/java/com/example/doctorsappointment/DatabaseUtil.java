package com.example.doctorsappointment;

import java.sql.*;

public class DatabaseUtil {

    private static final String URL = "jdbc:sqlite:appointments.db";

    static {
        try (Connection con = DriverManager.getConnection(URL);
             Statement st = con.createStatement()) {

            // EXISTING TABLE (keep it)
            st.execute("""
                CREATE TABLE IF NOT EXISTS appointments (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    doctor_name TEXT NOT NULL,
                    appointment_date TEXT NOT NULL,
                    slot_index INTEGER NOT NULL
                )
            """);

            // NEW: DOCTOR TABLE
            st.execute("""
                CREATE TABLE IF NOT EXISTS doctor (
                    doctor_id INTEGER PRIMARY KEY AUTOINCREMENT,
                    doctor_name TEXT NOT NULL,
                    doctor_email TEXT
                )
            """);

            // NEW: PATIENT TABLE
            st.execute("""
                CREATE TABLE IF NOT EXISTS patient (
                    patient_id INTEGER PRIMARY KEY AUTOINCREMENT,
                    patient_name TEXT NOT NULL,
                    phone TEXT
                )
            """);

            // NEW: LINKING TABLE
            st.execute("""
                CREATE TABLE IF NOT EXISTS appointment_details (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    doctor_id INTEGER,
                    patient_id INTEGER,
                    appointment_time TEXT
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
