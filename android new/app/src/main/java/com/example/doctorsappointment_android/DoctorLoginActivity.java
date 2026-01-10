package com.example.doctorsappointment_android;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DoctorLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_login);

        EditText name = findViewById(R.id.doctorName);
        EditText email = findViewById(R.id.doctorEmail);
        EditText id = findViewById(R.id.doctorId);
        Button submit = findViewById(R.id.submitDoctor);

        submit.setOnClickListener(v -> {

            if (name.getText().toString().isEmpty() ||
                    email.getText().toString().isEmpty() ||
                    id.getText().toString().isEmpty()) {

                Toast.makeText(this,
                        "Please fill all fields",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            startActivity(new Intent(this, DoctorPatientListActivity.class));
        });
    }
}
