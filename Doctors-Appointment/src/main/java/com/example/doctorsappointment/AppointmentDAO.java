package com.example.doctorsappointment;

import java.sql.*;

public class AppointmentDAO {

    public static void saveAppointment(
            String doctorName,
            String doctorEmail,
            String patientName,
            String phone,
            String time
    ) {

        try (Connection con = DatabaseUtil.getConnection()) {

            // Insert doctor
            PreparedStatement psDoctor = con.prepareStatement(
                    "INSERT INTO doctor (doctor_name, doctor_email) VALUES (?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            psDoctor.setString(1, doctorName);
            psDoctor.setString(2, doctorEmail);
            psDoctor.executeUpdate();

            ResultSet dr = psDoctor.getGeneratedKeys();
            dr.next();
            int doctorId = dr.getInt(1);

            //  Insert patient
            PreparedStatement psPatient = con.prepareStatement(
                    "INSERT INTO patient (patient_name, phone) VALUES (?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            psPatient.setString(1, patientName);
            psPatient.setString(2, phone);
            psPatient.executeUpdate();

            ResultSet pt = psPatient.getGeneratedKeys();
            pt.next();
            int patientId = pt.getInt(1);

            // Link them
            PreparedStatement psApp = con.prepareStatement(
                    "INSERT INTO appointment_details (doctor_id, patient_id, appointment_time) VALUES (?, ?, ?)"
            );
            psApp.setInt(1, doctorId);
            psApp.setInt(2, patientId);
            psApp.setString(3, time);
            psApp.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
