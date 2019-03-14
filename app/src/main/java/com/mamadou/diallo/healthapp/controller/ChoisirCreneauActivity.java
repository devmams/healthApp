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
import com.mamadou.diallo.healthapp.model.Disponibilite;
import com.mamadou.diallo.healthapp.model.DisponibiliteHelper;
import com.mamadou.diallo.healthapp.model.Medecin;
import com.mamadou.diallo.healthapp.model.Specialite;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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
    int medecin = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choisir_creneau);
        medecin = Medecin.getMedecinIdByName(getIntent().getExtras().getString("medecin"));

        mButton09 = (Button) findViewById(R.id.activity_choisir_creneau_09);
        mButton10 = (Button) findViewById(R.id.activity_choisir_creneau_10);
        mButton11 = (Button) findViewById(R.id.activity_choisir_creneau_11);
        mButton14 = (Button) findViewById(R.id.activity_choisir_creneau_14);
        mButton15 = (Button) findViewById(R.id.activity_choisir_creneau_15);
        mButton16 = (Button) findViewById(R.id.activity_choisir_creneau_16);
        mButton17 = (Button) findViewById(R.id.activity_choisir_creneau_17);
        int  idBouton;
        final int year = getIntent().getExtras().getInt("yearValue");
        final int month = (getIntent().getExtras().getInt("monthValue")+1);
        final int day = getIntent().getExtras().getInt("dayValue");

        Calendar cal = Calendar.getInstance();


        cal.set(year,month,day,9,00);

        Date date9 = cal.getTime();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String strDate = dateFormat.format(date9);

        DisponibiliteHelper disponibiliteHelper= new DisponibiliteHelper(this.getApplicationContext());


       // disponibiliteHelper.ajouterDisponibilite(date9,1);

        List<Disponibilite>  disponibilites =disponibiliteHelper.getMedecinDisponibilite(medecin);

        if(!verifierDisponibilite(disponibiliteHelper.getMedecinDisponibilite(medecin),cal.getTime())){
            mButton09.setBackgroundResource(R.drawable.red_button);
            mButton09.setEnabled(false);
        }else{
            mButton09.setEnabled(true);
            mButton09.setId(getDiponibiliteID(disponibiliteHelper.getMedecinDisponibilite(medecin),cal.getTime()));
        }
        cal.set(year,month,day,10,00);
        if(!verifierDisponibilite(disponibiliteHelper.getMedecinDisponibilite(medecin),cal.getTime())){
            mButton10.setBackgroundResource(R.drawable.red_button);
            mButton10.setEnabled(false);
        }else{
            mButton10.setEnabled(true);
            mButton10.setId(getDiponibiliteID(disponibiliteHelper.getMedecinDisponibilite(1),cal.getTime()));
        }
        cal.set(year,month,day,11,00);
        if(!verifierDisponibilite(disponibiliteHelper.getMedecinDisponibilite(medecin),cal.getTime())){
            mButton11.setBackgroundResource(R.drawable.red_button);
            mButton11.setEnabled(false);
        }else{
            mButton11.setEnabled(true);
            mButton11.setId(getDiponibiliteID(disponibiliteHelper.getMedecinDisponibilite(medecin),cal.getTime()));
        }
        cal.set(year,month,day,14,00);
        if(!verifierDisponibilite(disponibiliteHelper.getMedecinDisponibilite(medecin),cal.getTime())){
            mButton14.setBackgroundResource(R.drawable.red_button);
            mButton14.setEnabled(false);
        }else{
            mButton14.setEnabled(true);
            mButton14.setId(getDiponibiliteID(disponibiliteHelper.getMedecinDisponibilite(medecin),cal.getTime()));
        }
        cal.set(year,month,day,15,00);
        if(!verifierDisponibilite(disponibiliteHelper.getMedecinDisponibilite(medecin),cal.getTime())){
            mButton15.setBackgroundResource(R.drawable.red_button);
            mButton15.setEnabled(false);
        }else{
            mButton15.setEnabled(true);
            mButton15.setId(getDiponibiliteID(disponibiliteHelper.getMedecinDisponibilite(medecin),cal.getTime()));
        }
        cal.set(year,month,day,16,00);
        if(!verifierDisponibilite(disponibiliteHelper.getMedecinDisponibilite(medecin),cal.getTime())){
            mButton16.setBackgroundResource(R.drawable.red_button);
            mButton16.setEnabled(false);
        }else{
            mButton16.setEnabled(true);
            mButton16.setId(getDiponibiliteID(disponibiliteHelper.getMedecinDisponibilite(medecin),cal.getTime()));
        }
        cal.set(year,month,day,17,00);
        if(!verifierDisponibilite(disponibiliteHelper.getMedecinDisponibilite(medecin),cal.getTime())){
            mButton17.setBackgroundResource(R.drawable.red_button);
            mButton17.setEnabled(false);
        }else{
            mButton17.setEnabled(true);
            mButton17.setId(getDiponibiliteID(disponibiliteHelper.getMedecinDisponibilite(medecin),cal.getTime()));
        }


        mButton09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar cal = Calendar.getInstance();
                cal.set(year,month,day,9,00);
                Date date = cal.getTime();
                valider(date,mButton09.getId());
            }
        });

        mButton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                cal.set(year,month,day,10,00);
                Date date = cal.getTime();
                valider(date,mButton10.getId());
            }
        });

        mButton11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                cal.set(year,month,day,11,00);
                Date date = cal.getTime();
                valider(date,mButton11.getId());
            }
        });

        mButton14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                cal.set(year,month,day,14,00);
                Date date = cal.getTime();
                valider(date,mButton14.getId());
            }
        });

        mButton15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                cal.set(year,month,day,15,00);
                Date date = cal.getTime();
                valider(date,mButton15.getId());
            }
        });

        mButton16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                cal.set(year,month,day,16,00);
                Date date = cal.getTime();
                valider(date,mButton16.getId());
            }
        });

        mButton17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                cal.set(year,month,day,17,00);
                Date date = cal.getTime();

                valider(date,mButton17.getId());

            }
        });


    }

    boolean verifierDisponibilite(List<Disponibilite> disponibilites, Date date){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        //Date date1 = new Date();
       // Toast.makeText(this, "Date "+disponibilites.get(0).getDate(), Toast.LENGTH_SHORT).show();

        for(Disponibilite disponibilite:disponibilites){

            if( dateFormat.format(disponibilite.getDate()).equals(dateFormat.format(date.getTime())) ){
                return true;
            }
        }
        return false;

    }

    public int getDiponibiliteID(List<Disponibilite> disponibilites, Date date){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        for(Disponibilite disponibilite:disponibilites){

            if( dateFormat.format(disponibilite.getDate()).equals(dateFormat.format(date.getTime())) ){

                return disponibilite.getId();
            }
        }
        return 0;
    }

    void valider(Date date,int idDisponibilite){
        Intent intent = new Intent(getApplicationContext(), ValidationRDVActivity.class);

        if(medecin==0){
            Toast.makeText(this, "Vous n'avez pas selectionné de medecin", Toast.LENGTH_SHORT).show();

        }else{
            getIntent().getExtras().getString("medecin");
            intent.putExtra("medecin", medecin); // le 1 correspond à l'id du medecin
            intent.putExtra("idDisponibilite", idDisponibilite);
            intent.putExtra("dateValue", date.getTime());

            startActivity(intent);
        }

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