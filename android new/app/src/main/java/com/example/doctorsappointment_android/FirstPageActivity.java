package com.example.doctorsappointment_android;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class FirstPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);

        Button btnDoctor = findViewById(R.id.btnDoctor);
        Button btnPatient = findViewById(R.id.btnPatient);

        btnPatient.setOnClickListener(v ->
                startActivity(new Intent(this, SectorListActivity.class))
        );

        btnDoctor.setOnClickListener(v ->
                startActivity(new Intent(this, DoctorLoginActivity.class))
        );
    }
}
