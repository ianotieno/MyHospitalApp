package com.example.myhospitalapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FindDoctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_find_doctor);

        CardView exit = findViewById(R.id.cardFDBack);
        CardView familphysician=  findViewById(R.id.cardFamilyPysicians);
        CardView dietician=  findViewById(R.id.cardFDDietician);
        CardView dentist=  findViewById(R.id.cardFDDentist);
        CardView surgeon=  findViewById(R.id.cardFDSurgeon);
        CardView cardiologists=  findViewById(R.id.cardFDCardiologists);


        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FindDoctorActivity.this,HomeActivity.class));
            }
        });
        familphysician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                intent.putExtra("title", "Family Pysicians");
                startActivity(intent);
            }
        });
        dietician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                intent.putExtra("title", "Dietician");
                startActivity(intent);
            }
        });

       dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                intent.putExtra("title", "dentist");
                startActivity(intent);
            }
        });
        surgeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                intent.putExtra("title", "surgeon");
                startActivity(intent);
            }
        });
        cardiologists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                intent.putExtra("title", "cardiologists");
                startActivity(intent);
            }
        });
    }
}