package com.example.doctorsappointment;

import java.sql.*;

public class DatabaseUtil {

    private static final String URL = "jdbc:sqlite:appointments.db";

    static {
        try (Connection con = DriverManager.getConnection(URL);
             Statement st = con.createStatement()) {

            st.execute("""
                CREATE TABLE IF NOT EXISTS appointments (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    doctor_name TEXT NOT NULL,
                    appointment_date TEXT NOT NULL,
                    slot_index INTEGER NOT NULL
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
