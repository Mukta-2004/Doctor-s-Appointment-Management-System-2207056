package com.example.doctorsappointment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO {

    public static final int TOTAL_SLOTS = 16;

    // Save appointment and return slot index assigned, -1 if no slot
    public static int saveAppointment(String doctorName, String patientName, String phone) {

        try (Connection con = DatabaseUtil.getConnection()) {

            // Insert doctor if not exists
            int doctorId = getDoctorId(con, doctorName);

            //  Insert patient if not exists
            int patientId = getPatientId(con, patientName, phone);

            //  Check booked slots for this doctor
            List<Integer> bookedSlots = getBookedSlots(con, doctorId);
            int slotIndex = -1;
            for (int i = 0; i < TOTAL_SLOTS; i++) {
                if (!bookedSlots.contains(i)) {
                    slotIndex = i;
                    break;
                }
            }

            if (slotIndex == -1) {
                // No slots available
                return -1;
            }

            // Insert appointment
            String time = TimeUtil.getTimeFromSlot(slotIndex);
            String sql = "INSERT INTO appointment_details (doctor_id, patient_id, appointment_time) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, doctorId);
            ps.setInt(2, patientId);
            ps.setString(3, time);
            ps.executeUpdate();

            return slotIndex;

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    private static int getDoctorId(Connection con, String doctorName) throws SQLException {
        String query = "SELECT doctor_id FROM doctor WHERE doctor_name = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, doctorName);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) return rs.getInt("doctor_id");

        // Insert new doctor
        ps = con.prepareStatement("INSERT INTO doctor (doctor_name) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, doctorName);
        ps.executeUpdate();
        rs = ps.getGeneratedKeys();
        rs.next();
        return rs.getInt(1);
    }

    private static int getPatientId(Connection con, String patientName, String phone) throws SQLException {
        String query = "SELECT patient_id FROM patient WHERE patient_name = ? AND phone = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, patientName);
        ps.setString(2, phone);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) return rs.getInt("patient_id");

        // Insert new patient
        ps = con.prepareStatement("INSERT INTO patient (patient_name, phone) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, patientName);
        ps.setString(2, phone);
        ps.executeUpdate();
        rs = ps.getGeneratedKeys();
        rs.next();
        return rs.getInt(1);
    }

    private static List<Integer> getBookedSlots(Connection con, int doctorId) throws SQLException {
        List<Integer> slots = new ArrayList<>();
        String query = "SELECT appointment_time FROM appointment_details WHERE doctor_id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, doctorId);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String time = rs.getString("appointment_time");
            slots.add(TimeUtil.getSlotFromTime(time));
        }
        return slots;
    }

    public static void cancelAppointment(int appointmentId) {
        try (Connection con = DatabaseUtil.getConnection()) {
            String sql = "DELETE FROM appointment_details WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, appointmentId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
