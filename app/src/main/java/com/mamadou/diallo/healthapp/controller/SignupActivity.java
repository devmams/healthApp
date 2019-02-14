package com.mamadou.diallo.healthapp.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mamadou.diallo.healthapp.R;
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
                if(user.add(getApplicationContext())){
                    Toast.makeText(getApplicationContext(), "Bonjour Monsieur "+user.getNom()+" "+user.getPrenom(),Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Désolé ",Toast.LENGTH_LONG).show();
                }
                //userbd.addUtilisateur(user);
                if(user != null){
                    Intent intent = new Intent(getApplicationContext(), HomePageActivity.class);
                    startActivity(intent);
                }
//                Toast.makeText(getApplicationContext(), "Bonjour Monsieur "+user.getNom()+" "+user.getPrenom(),Toast.LENGTH_LONG).show();
            }
        });

    }
}

