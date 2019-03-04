package com.mamadou.diallo.healthapp.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.mamadou.diallo.healthapp.R;

import static android.widget.Toast.LENGTH_LONG;

public class ChoisirCreneau extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choisir_creneau);

        int year = getIntent().getExtras().getInt("yearValue");
        int month = getIntent().getExtras().getInt("monthValue");
        int day = getIntent().getExtras().getInt("dayValue");
        Toast.makeText(getApplicationContext(), "Year=" + year + " Month=" + month + " Day=" + day, Toast.LENGTH_LONG).show();

    }
}
