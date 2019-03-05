package com.mamadou.diallo.healthapp.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.mamadou.diallo.healthapp.R;
import com.mamadou.diallo.healthapp.model.Disponibilite;
import com.mamadou.diallo.healthapp.model.DisponibiliteHelper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ValidationRDVActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validation_rdv);
        Long date = getIntent().getExtras().getLong("dateValue");


        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String strDate = dateFormat.format(date);
        Toast.makeText(getApplicationContext(), strDate, Toast.LENGTH_LONG).show();



        DisponibiliteHelper disponibiliteHelper= new DisponibiliteHelper(this.getApplicationContext());

        for(Disponibilite disponibilite :disponibiliteHelper.getMedecinDisponibilite(1)) // pour avoir la liste des disponibilité du medecin
            Toast.makeText(getApplicationContext(), ""+disponibilite.getMedecin().getNomMedecin(),Toast.LENGTH_LONG).show();
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

    //disponibiliteHelper.ajouterDisponibilite(new Date(),1);

    //disponibiliteHelper.ajouterDisponibilite(new Date(),1);
    //disponibiliteHelper.ajouterDisponibilite(new Date(),1);
    //disponibiliteHelper.ajouterDisponibilite(new Date(),3);

    //disponibiliteHelper.prendreRendezVous(1,1); ici le second parametre correspond à l'identifiant de l'utilisateur connecté

    // Toast.makeText(getApplicationContext(), ""+disponibiliteHelper.getAllDisponibilite().get(0).getUtilisateur().getId(),Toast.LENGTH_LONG).show();


    //for(Disponibilite disponibilite :disponibiliteHelper.getNextUserDisponibilite(1)) pour avoir la liste des prochains rdv de l'utilisateur


    // for(Disponibilite disponibilite :disponibiliteHelper.getPreviousUserDisponibilite(1)) pour avoir la liste des precedent rdv de l'utilisateur

}
