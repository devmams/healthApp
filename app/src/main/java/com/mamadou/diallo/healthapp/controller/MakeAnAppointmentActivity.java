package com.mamadou.diallo.healthapp.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import java.util.List;

import com.mamadou.diallo.healthapp.R;
import com.mamadou.diallo.healthapp.model.Specialite;

import java.util.List;

public class MakeAnAppointmentActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_an_appointment);

        Spinner spinner_1 = (Spinner) findViewById(R.id.spinner1);
        spinner_1.setOnItemSelectedListener(this);


        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter_1 = ArrayAdapter.createFromResource(this,
                R.array.speciality_array, android.R.layout.simple_spinner_item);



        // Specify the layout to use when the list of choices appears
        adapter_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner_1.setAdapter(adapter_1);


        Spinner spinner_2 = (Spinner) findViewById(R.id.spinner2);
        spinner_2.setOnItemSelectedListener(this);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter_2 = ArrayAdapter.createFromResource(this,
                R.array.speciality_array, android.R.layout.simple_spinner_item);



        // Specify the layout to use when the list of choices appears
        adapter_2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner_2.setAdapter(adapter_2);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

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
