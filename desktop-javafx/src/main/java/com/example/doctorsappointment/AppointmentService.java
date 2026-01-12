package com.example.doctorsappointment;

import java.sql.*;
import java.time.LocalDate;

public class AppointmentService {

    public static int getNextAvailableSlot(String doctorName) {

        boolean[] booked = new boolean[16];
        String today = LocalDate.now().toString();

        try (Connection con = DatabaseUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "SELECT slot_index FROM appointments WHERE doctor_name=? AND appointment_date=?")) {

            ps.setString(1, doctorName);
            ps.setString(2, today);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                booked[rs.getInt("slot_index")] = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 16; i++) {
            if (!booked[i]) return i;
        }
        return -1; // no slot available
    }

    public static void bookAppointment(String doctorName, int slot) {
        String today = LocalDate.now().toString();

        try (Connection con = DatabaseUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "INSERT INTO appointments (doctor_name, appointment_date, slot_index) VALUES (?, ?, ?)")) {

            ps.setString(1, doctorName);
            ps.setString(2, today);
            ps.setInt(3, slot);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}