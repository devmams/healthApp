package com.mamadou.diallo.healthapp.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

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
        simpleCalendarView = (CalendarView) findViewById(R.id.activity_make_an_appointment_calendar_btn); // get the reference of CalendarView

        Long min = calendar.getTime().getTime();
        simpleCalendarView.setMinDate(min);

        calendar.add(Calendar.MONTH, 2);

        int today = calendar.getActualMaximum(Calendar.DAY_OF_MONTH) - calendar.get(Calendar.DAY_OF_MONTH);
        calendar.add(Calendar.DAY_OF_MONTH, today);
        Long max = calendar.getTime().getTime();
        simpleCalendarView.setMaxDate(max);
    }
}
