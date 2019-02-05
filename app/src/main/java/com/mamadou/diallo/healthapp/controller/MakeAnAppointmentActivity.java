package com.mamadou.diallo.healthapp.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;

import com.mamadou.diallo.healthapp.R;

import java.util.Calendar;

public class MakeAnAppointmentActivity extends AppCompatActivity {

    private CalendarView simpleCalendarView;
    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_an_appointment);

        calendar = Calendar.getInstance();
        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        simpleCalendarView = (CalendarView) findViewById(R.id.activity_make_an_appointment_calendar_btn); // get the reference of CalendarView
        simpleCalendarView.setMaxDate(daysInMonth);

    }
}