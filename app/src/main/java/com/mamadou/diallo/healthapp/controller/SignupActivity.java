package com.mamadou.diallo.healthapp.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.mamadou.diallo.healthapp.R;
import com.mamadou.diallo.healthapp.model.Utilisateur;
import com.mamadou.diallo.healthapp.model.UtilisateurHelper;

public class SignupActivity extends AppCompatActivity {

    private EditText mFirstNameTxt;
    private EditText mLastNameTxt;
    private EditText mEmailTxt;
    private EditText mPasswordTxt;
    private EditText mConfirmPasswordTxt;
    private Utilisateur user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mFirstNameTxt = (EditText) findViewById(R.id.activity_signup_first_name_txt);
        mLastNameTxt = (EditText) findViewById(R.id.activity_signup_last_name_txt);
        mEmailTxt = (EditText) findViewById(R.id.activity_signup_email_txt);
        mPasswordTxt = (EditText) findViewById(R.id.activity_login_password_txt);
        mConfirmPasswordTxt = (EditText) findViewById(R.id.activity_login_password_txt);


        UtilisateurHelper userbd = new UtilisateurHelper(this);

        user = new Utilisateur(1,mLastNameTxt.toString(), mFirstNameTxt.toString(), mEmailTxt.toString(), mPasswordTxt.toString());
        userbd.addUtilisateur(user);

    }
}

