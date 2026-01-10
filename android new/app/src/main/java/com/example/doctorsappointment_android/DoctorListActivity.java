package com.example.doctorsappointment_android;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class DoctorListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_list);

        TextView title = findViewById(R.id.doctorTitle);
        ListView listView = findViewById(R.id.doctorListView);

        String sector = getIntent().getStringExtra("sector");
        title.setText("Doctors - " + sector);

        HashMap<String, String[]> doctorMap = new HashMap<>();

        doctorMap.put("Orthopedic", new String[]{
                "Dr. Rajib Baishnob (MBBS, Ortho)"
        });

        doctorMap.put("Child Specialist", new String[]{
                "Dr. Nusrat Jahan (MBBS, Pediatrics)"
        });

        doctorMap.put("Surgeon", new String[]{
                "Dr. Ahmed Khan (MBBS, Surgery)"
        });

        doctorMap.put("Medicine Specialist", new String[]{
                "Dr. Farhana Islam (MBBS, Medicine)"
        });

        doctorMap.put("Neurology", new String[]{
                "Dr. Kamal Hossain (MBBS, Neurology)"
        });

        final String[] doctors;

        if (doctorMap.containsKey(sector)) {
            doctors = doctorMap.get(sector);
        } else {
            doctors = new String[]{"No doctors available"};
        }

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1,
                        doctors);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {

            if (doctors[position].equals("No doctors available")) return;

            Intent intent = new Intent(this, BookingActivity.class);
            intent.putExtra("doctor", doctors[position]);
            startActivity(intent);
        });
    }
}
