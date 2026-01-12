package com.example.doctorsappointment_android;
import android.content.Intent;
import android.os.Bundle; import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
public class DoctorPatientListActivity extends AppCompatActivity {
    static ArrayList<String> patients = new ArrayList<>();
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_patient_list);
        TextView title = findViewById(R.id.patientTitle);
        ListView listView = findViewById(R.id.patientListView);
        title.setText("Patient List");
       /* if (patients.isEmpty()) {
            patients.add("No patient yet");
        }*/
        if (patients.isEmpty()) {
            patients.add("Serial 1 - Rahim (10:00 - 10:30)");
            patients.add("Serial 2 - Maria(10:30 - 11:00)");
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, patients);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((p, v, pos, id) -> { if (patients.get(pos).equals("No patient yet")) return;
            Intent intent = new Intent(this, CancelAppointmentActivity.class);
            intent.putExtra("index", pos); startActivity(intent);
        });
    }
}