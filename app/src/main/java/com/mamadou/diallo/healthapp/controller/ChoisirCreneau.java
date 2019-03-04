package com.mamadou.diallo.healthapp.controller;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mamadou.diallo.healthapp.R;

import static android.widget.Toast.LENGTH_LONG;

public class ChoisirCreneau extends AppCompatActivity {

    private Button mButton09;
    private Button mButton10;
    private Button mButton11;
    private Button mButton14;
    private Button mButton15;
    private Button mButton16;
    private Button mButton17;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choisir_creneau);

        mButton09 = (Button) findViewById(R.id.activity_choisir_creneau_09);

//        mButton09.setBackgroundResource(R.drawable.red_button);

        mButton09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        int year = getIntent().getExtras().getInt("yearValue");
        int month = getIntent().getExtras().getInt("monthValue");
        int day = getIntent().getExtras().getInt("dayValue");
        Toast.makeText(getApplicationContext(), "Year=" + year + " Month=" + month + " Day=" + day, Toast.LENGTH_LONG).show();

    }
}
