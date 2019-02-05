package com.mamadou.diallo.healthapp.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mamadou.diallo.healthapp.R;

public class HomePageActivity extends AppCompatActivity {

    private Button mMakeAnAppointment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        mMakeAnAppointment = (Button) findViewById(R.id.activity_home_page_make_an_appointment_btn);

        mMakeAnAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MakeAnAppointmentActivity.class);
                startActivity(intent);
            }
        });



    }
}
