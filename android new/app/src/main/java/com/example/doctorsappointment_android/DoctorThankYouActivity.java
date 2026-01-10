package com.example.doctorsappointment_android;


import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DoctorThankYouActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_thank_you);

        TextView text = findViewById(R.id.thankYouText);
        text.setText("Thank you!\nAppointment updated.");
    }
}

