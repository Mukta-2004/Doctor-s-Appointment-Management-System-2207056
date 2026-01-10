package com.example.doctorsappointment_android;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class SectorListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sector_list);

        ListView listView = findViewById(R.id.sectorListView);

        String[] sectors = {
                "Orthopedic",
                "Child Specialist",
                "Surgeon",
                "Medicine Specialist",
                "Hematology",
                "Gynae and Obs",
                "Gastroenterology",
                "Urology",
                "Neurology",
                "Psychiatry",
                "Pathology"
        };


        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1,
                        sectors);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedSector = sectors[position];

            Intent intent = new Intent(this, DoctorListActivity.class);
            intent.putExtra("sector", selectedSector);
            startActivity(intent);
        });
    }
}
