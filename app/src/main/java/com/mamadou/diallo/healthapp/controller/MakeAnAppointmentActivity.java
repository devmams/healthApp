package com.mamadou.diallo.healthapp.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import com.mamadou.diallo.healthapp.R;
import com.mamadou.diallo.healthapp.model.Medecin;
import com.mamadou.diallo.healthapp.model.Specialite;

import java.util.List;

import static com.mamadou.diallo.healthapp.model.Medecin.getAllMedecin;
import static com.mamadou.diallo.healthapp.model.Specialite.getAllSpecialite;

public class MakeAnAppointmentActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

//    private List<String> listSpecialiteString = new ArrayList<String>();
    private List<String> listSpecialiteString;
//    private List<Specialite> listSpecialite = getAllSpecialite();
    private List<Specialite> listSpecialite;

//    private List<String> listMedecinString=new ArrayList<String>();
    private List<String> listMedecinString;
//    private List<Medecin> listMedecin=getAllMedecin();
    private List<Medecin> listMedecin;
    Spinner spinner_1,spinner_2;
    String medecinChoisi = "";

    int ps;

    ArrayAdapter<String> adapter_1;
    Button mHoraireBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_an_appointment);

        listSpecialiteString = new ArrayList<String>();
        listMedecinString=new ArrayList<String>();
        listSpecialite = getAllSpecialite();
        listMedecin = getAllMedecin();

        for (int i = 0; i < listSpecialite.size(); i++)
            listSpecialiteString.add(listSpecialite.get(i).getLibelleSpecialite());

        spinner_1 = (Spinner) findViewById(R.id.spinner1);
        spinner_1.setOnItemSelectedListener(this);
        spinner_2 = (Spinner) findViewById(R.id.spinner2);
        mHoraireBtn = (Button) findViewById(R.id.activity_make_an_appointment_horaire_btn);

        mHoraireBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                medecinChoisi = spinner_2.getSelectedItem().toString();
                Intent intent = new Intent(getApplicationContext(), DisponibilityActivity.class);
//                Toast.makeText(getApplicationContext(), "med : " + medecinChoisi, Toast.LENGTH_SHORT).show();
                intent.putExtra("medecin", medecinChoisi);
                startActivity(intent);
            }
        });


        Toast.makeText(getApplicationContext(), "med1 : " + listSpecialiteString.size(), Toast.LENGTH_SHORT).show();

//        listSpecialiteString.clear();

        Toast.makeText(getApplicationContext(), "med2 : " + listSpecialiteString.size(), Toast.LENGTH_SHORT).show();


        HashSet<String> hashSet = new HashSet<String>();
        hashSet.addAll(listSpecialiteString);
        listSpecialiteString.clear();
        listSpecialiteString.addAll(hashSet);
        Collections.sort(listSpecialiteString);

        // Create an ArrayAdapter using the string array and a default spinner layout
        adapter_1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, listSpecialiteString);



        // Specify the layout to use when the list of choices appears
        adapter_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner_1.setAdapter(adapter_1);

        adapter_1.notifyDataSetChanged();

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String sp1= String.valueOf(spinner_1.getSelectedItem());
        //Toast.makeText(this, sp1, Toast.LENGTH_SHORT).show();
        listMedecin = Medecin.getMedecinsBySpecialite(sp1);
        listMedecinString.clear();
        for(int i=0;i<listMedecin.size();i++){
            listMedecinString.add(listMedecin.get(i).getNomMedecin()+" "+listMedecin.get(i).getPrenomMedecin());
        }

        HashSet<String> hashSet = new HashSet<String>();
        hashSet.addAll(listMedecinString);
        listMedecinString.clear();
        listMedecinString.addAll(hashSet);
        Collections.sort(listMedecinString);

        ArrayAdapter<String> adapter_2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, listMedecinString);
        adapter_2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_2.notifyDataSetChanged();
        spinner_2.setAdapter(adapter_2);
//        Toast.makeText(this,""+ spinner_2.getSelectedItem(), Toast.LENGTH_SHORT).show();
        medecinChoisi= spinner_2.getSelectedItem().toString();
        adapter_2.notifyDataSetChanged();


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
