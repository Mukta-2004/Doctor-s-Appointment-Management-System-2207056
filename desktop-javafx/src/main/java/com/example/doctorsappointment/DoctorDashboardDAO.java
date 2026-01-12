package com.example.doctorsappointment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DoctorDashboardDAO {

    // Fetch existing doctor by name/email or create a new one
    public static int getOrCreateDoctorId(String name, String email) {
        try (Connection con = DatabaseUtil.getConnection()) {

            // Make sure the doctor table has an email column
            Statement stmt = con.createStatement();
            stmt.execute("""
                CREATE TABLE IF NOT EXISTS doctor (
                    doctor_id INTEGER PRIMARY KEY AUTOINCREMENT,
                    doctor_name TEXT UNIQUE,
                    email TEXT
                )
            """);

            // Check if doctor exists
            String query = "SELECT doctor_id FROM doctor WHERE doctor_name = ? AND email = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, email);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("doctor_id"); // exists → return id
            }

            // Doctor not found → insert
            ps = con.prepareStatement("INSERT INTO doctor (doctor_name, email) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }

            return -1; // failed to create
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }

    }
    public static List<AppointmentDTO> getAppointments(int doctorId) {
        List<AppointmentDTO> list = new ArrayList<>();

        String sql = """
        SELECT 
            ad.id,
            ad.doctor_id,
            p.patient_name,
            p.phone,
            ad.appointment_time
        FROM appointment_details ad
        JOIN patient p ON ad.patient_id = p.patient_id
        WHERE ad.doctor_id = ?
    """;

        try (Connection con = DatabaseUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, doctorId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new AppointmentDTO(
                        rs.getInt("id"),
                        rs.getInt("doctor_id"),
                        rs.getString("patient_name"),
                        rs.getString("phone"),
                        rs.getString("appointment_time")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }


}