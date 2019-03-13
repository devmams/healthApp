package com.mamadou.diallo.healthapp.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mamadou.diallo.healthapp.R;
import com.mamadou.diallo.healthapp.model.DisponibiliteHelper;
import com.mamadou.diallo.healthapp.model.Utilisateur;
import com.mamadou.diallo.healthapp.model.UtilisateurHelper;

public class SignupActivity extends AppCompatActivity {

    private EditText mFirstNameTxt;
    private EditText mLastNameTxt;
    private EditText mEmailTxt;
    private EditText mPasswordTxt;
    private EditText mConfirmPasswordTxt;
    private Button mSignupBtn;
    private Utilisateur user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mFirstNameTxt = (EditText) findViewById(R.id.activity_signup_first_name_txt);
        mLastNameTxt = (EditText) findViewById(R.id.activity_signup_last_name_txt);
        mEmailTxt = (EditText) findViewById(R.id.activity_signup_email_txt);
        mPasswordTxt = (EditText) findViewById(R.id.activity_signup_password_txt);
        mConfirmPasswordTxt = (EditText) findViewById(R.id.activity_login_password_txt);
        mSignupBtn = (Button) findViewById(R.id.activity_signup_signup_btn);

        mSignupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //UtilisateurHelper userbd = new UtilisateurHelper(getApplicationContext());
                user = new Utilisateur(mLastNameTxt.getText().toString(), mFirstNameTxt.getText().toString(), mEmailTxt.getText().toString(), mPasswordTxt.getText().toString());
                if(Utilisateur.getAllUser(getApplicationContext()).size()==0){
                    DisponibiliteHelper disponibiliteHelper = new DisponibiliteHelper(getApplicationContext());
                    disponibiliteHelper.initialize();

                }

                if(user.add(getApplicationContext())){
                    Toast.makeText(getApplicationContext(), "Bonjour Monsieur "+user.getNom()+" "+user.getPrenom(),Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Désolé ",Toast.LENGTH_LONG).show();
                }
                //userbd.addUtilisateur(user);
                if(user != null){
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
//                Toast.makeText(getApplicationContext(), "Bonjour Monsieur "+user.getNom()+" "+user.getPrenom(),Toast.LENGTH_LONG).show();
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

