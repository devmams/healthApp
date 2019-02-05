package com.mamadou.diallo.healthapp.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mamadou.diallo.healthapp.R;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }
}


  /* test de creation d'utilisateur
    UtilisateurHelper userbd=new UtilisateurHelper(this);
    Utilisateur user1=new Utilisateur(1,"DOVII", "Olive",72000, "olive", "",   "","","olive");
    Utilisateur user2=new Utilisateur(2,"DOVII", "Mawussi",72000, "mawussi", "",   "","","mawussi");

    //userbd.addUtilisateur(user1);
    //userbd.addUtilisateur(user2);


    */