package com.mamadou.diallo.healthapp.controller;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mamadou.diallo.healthapp.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import static android.widget.Toast.LENGTH_LONG;

public class ChoisirCreneauActivity extends AppCompatActivity {

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
        mButton10 = (Button) findViewById(R.id.activity_choisir_creneau_10);
        mButton11 = (Button) findViewById(R.id.activity_choisir_creneau_11);
        mButton14 = (Button) findViewById(R.id.activity_choisir_creneau_14);
        mButton15 = (Button) findViewById(R.id.activity_choisir_creneau_15);
        mButton16 = (Button) findViewById(R.id.activity_choisir_creneau_16);
        mButton17 = (Button) findViewById(R.id.activity_choisir_creneau_17);


        final int year = getIntent().getExtras().getInt("yearValue");
        final int month = (getIntent().getExtras().getInt("monthValue")+1);
        final int day = getIntent().getExtras().getInt("dayValue");

        if(false){
            mButton09.setBackgroundResource(R.drawable.red_button);
            mButton09.setEnabled(false);
        }
        if(true){
            mButton10.setBackgroundResource(R.drawable.red_button);
            mButton10.setEnabled(false);
        }
        if(false){
            mButton11.setBackgroundResource(R.drawable.red_button);
            mButton11.setEnabled(false);
        }
        if(false){
            mButton14.setBackgroundResource(R.drawable.red_button);
            mButton14.setEnabled(false);
        }
        if(false){
            mButton15.setBackgroundResource(R.drawable.red_button);
            mButton15.setEnabled(false);
        }
        if(true){
            mButton16.setBackgroundResource(R.drawable.red_button);
            mButton16.setEnabled(false);
        }
        if(false){
            mButton17.setBackgroundResource(R.drawable.red_button);
            mButton17.setEnabled(false);
        }


        mButton09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                cal.set(year,month,day,9,00);
                Long date = cal.getTimeInMillis();
                Intent intent = new Intent(getApplicationContext(), ValidationRDVActivity.class);
                intent.putExtra("dateValue", date);
                startActivity(intent);
            }
        });

        mButton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                cal.set(year,month,day,10,00);
                Long date = cal.getTimeInMillis();
                Intent intent = new Intent(getApplicationContext(), ValidationRDVActivity.class);
                intent.putExtra("dateValue", date);
                startActivity(intent);
            }
        });

        mButton11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                cal.set(year,month,day,11,00);
                Long date = cal.getTimeInMillis();
                Intent intent = new Intent(getApplicationContext(), ValidationRDVActivity.class);
                intent.putExtra("dateValue", date);
                startActivity(intent);
            }
        });

        mButton14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                cal.set(year,month,day,14,00);
                Long date = cal.getTimeInMillis();
                Intent intent = new Intent(getApplicationContext(), ValidationRDVActivity.class);
                intent.putExtra("dateValue", date);
                startActivity(intent);
            }
        });

        mButton15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                cal.set(year,month,day,15,00);
                Long date = cal.getTimeInMillis();
                Intent intent = new Intent(getApplicationContext(), ValidationRDVActivity.class);
                intent.putExtra("dateValue", date);
                startActivity(intent);
            }
        });

        mButton16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                cal.set(year,month,day,16,00);
                Long date = cal.getTimeInMillis();
                Intent intent = new Intent(getApplicationContext(), ValidationRDVActivity.class);
                intent.putExtra("dateValue", date);
                startActivity(intent);
            }
        });

        mButton17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                cal.set(year,month,day,17,00);
                Long date = cal.getTimeInMillis();
                Intent intent = new Intent(getApplicationContext(), ValidationRDVActivity.class);
                intent.putExtra("dateValue", date);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onRestart() {
        super.onRestart();  // Always call the superclass method first
        recreate();
    }

    private void language_setting(){
        Intent intent = new Intent(getApplicationContext(),SettingLanguageActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //ajoute les entrées de menu_test à l'ActionBar
        getMenuInflater().inflate(R.menu.menu_app, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_language:
                language_setting();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
