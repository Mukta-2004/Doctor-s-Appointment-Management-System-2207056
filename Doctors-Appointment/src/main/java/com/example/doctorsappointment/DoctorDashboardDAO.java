package com.example.doctorsappointment;

import java.sql.*;
import java.util.*;

public class DoctorDashboardDAO {

    public static List<String> getPatients(String doctorName) {

        List<String> list = new ArrayList<>();

        try (Connection con = DatabaseUtil.getConnection()) {

            String sql = """
                SELECT p.patient_name, p.phone, a.appointment_time
                FROM appointment_details a
                JOIN doctor d ON a.doctor_id = d.doctor_id
                JOIN patient p ON a.patient_id = p.patient_id
                WHERE d.doctor_name = ?
            """;

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, doctorName);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(
                        rs.getString("appointment_time") +
                                " - " +
                                rs.getString("patient_name") +
                                " (" +
                                rs.getString("phone") +
                                ")"
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
