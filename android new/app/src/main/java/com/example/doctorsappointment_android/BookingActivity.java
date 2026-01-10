package com.example.doctorsappointment_android;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BookingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        TextView doctorNameText = findViewById(R.id.doctorNameText);
        EditText patientName = findViewById(R.id.patientNameInput);
        EditText patientPhone = findViewById(R.id.patientPhoneInput);
        Button yesBtn = findViewById(R.id.yesButton);
        Button noBtn = findViewById(R.id.noButton);

        String doctor = getIntent().getStringExtra("doctor");
        doctorNameText.setText("Doctor: " + doctor);

        yesBtn.setOnClickListener(v -> {
            String name = patientName.getText().toString().trim();
            String phone = patientPhone.getText().toString().trim();

            if (name.isEmpty() || phone.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(this, ConfirmationActivity.class);
            intent.putExtra("doctor", doctor);
            intent.putExtra("patient", name);
            startActivity(intent);
        });

        noBtn.setOnClickListener(v -> finishAffinity());
    }
}
