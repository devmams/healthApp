package com.mamadou.diallo.healthapp.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mamadou.diallo.healthapp.R;

public class MyAppointmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_appointment);

        final RecyclerView rv = (RecyclerView) findViewById(R.id.my_recycler_view);

        rv.setLayoutManager(new LinearLayoutManager(this));

        rv.setAdapter(new MyAdapter());
    }
}

