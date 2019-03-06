package com.mamadou.diallo.healthapp.controller;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mamadou.diallo.healthapp.R;
import com.mamadou.diallo.healthapp.model.Specialite;
import com.mamadou.diallo.healthapp.model.Utilisateur;
import com.mamadou.diallo.healthapp.model.UtilisateurHelper;

public class LoginActivity extends AppCompatActivity {

    private EditText mEmailTxt;
    private EditText mPasswordTxt;
    private Button mLogInLogInBtn;
    private static Utilisateur userConnecter ;
    Utilisateur user;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmailTxt = (EditText) findViewById(R.id.activity_login_email_txt);
        mPasswordTxt = (EditText) findViewById(R.id.activity_login_password_txt);
        mLogInLogInBtn = (Button) findViewById(R.id.activity_login_login_btn);

        mLogInLogInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // user = null;
                user=new Utilisateur(mEmailTxt.getText().toString(),mPasswordTxt.getText().toString());
                user=user.login(getApplicationContext());
                if(user!=null){
                    Intent intent = new Intent(getApplicationContext(), HomePageActivity.class);
                    userConnecter=user;
                    intent.putExtra("utilisateur", user);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "désolé, cet identifiant n'est pas dans la base ",Toast.LENGTH_LONG).show();
                }

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


    public static Utilisateur getUserConnecter() {
        return userConnecter;
    }
}
