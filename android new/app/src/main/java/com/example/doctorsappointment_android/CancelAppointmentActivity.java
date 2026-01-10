package com.example.doctorsappointment_android;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CancelAppointmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel);

        int index = getIntent().getIntExtra("index", -1);

        TextView text = findViewById(R.id.cancelText);
        Button yes = findViewById(R.id.yesCancel);
        Button no = findViewById(R.id.noCancel);

        text.setText("Do you want to cancel this appointment?");

        yes.setOnClickListener(v -> {
            if (index >= 0 &&
                    !DoctorPatientListActivity.patients.isEmpty()) {

                DoctorPatientListActivity.patients.remove(index);
            }

            startActivity(new Intent(this, DoctorThankYouActivity.class));
        });

        no.setOnClickListener(v -> finish());
    }
}

