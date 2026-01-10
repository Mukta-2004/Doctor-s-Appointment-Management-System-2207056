package com.example.doctorsappointment_android;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class ConfirmationActivity extends AppCompatActivity {

    // Temporary slot storage (doctor -> booked count)
    static HashMap<String, Integer> slotMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        TextView infoText = findViewById(R.id.confirmationText);
        Button okButton = findViewById(R.id.okButton);

        String doctor = getIntent().getStringExtra("doctor");
        String patient = getIntent().getStringExtra("patient");

        int booked = slotMap.getOrDefault(doctor, 0);

        if (booked >= 5) {
            Toast.makeText(this,
                    "Sorry no slot left, choose another doctor",
                    Toast.LENGTH_LONG).show();

            finish();
            return;
        }

        booked++;
        slotMap.put(doctor, booked);

        String time = (9 + booked) + ":00 AM";

        infoText.setText(
                "Appointment Confirmed!\n\n" +
                        "Doctor: " + doctor + "\n" +
                        "Patient: " + patient + "\n" +
                        "Serial No: " + booked + "\n" +
                        "Time: " + time
        );

        okButton.setOnClickListener(v -> finishAffinity());
    }
}
