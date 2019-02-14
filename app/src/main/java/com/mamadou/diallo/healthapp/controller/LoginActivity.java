package com.mamadou.diallo.healthapp.controller;

import android.annotation.SuppressLint;
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

public class LoginActivity extends AppCompatActivity {

    private EditText mEmailTxt;
    private EditText mPasswordTxt;
    private Button mLogInLogInBtn;
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
                user = null;
                UtilisateurHelper userbd = new UtilisateurHelper(getApplicationContext());
                user= userbd.getUser(mEmailTxt.getText().toString(),mPasswordTxt.getText().toString());

//                if(user!=null) {
//                    Toast.makeText(getApplicationContext(), "Bonjour Monsieur " + user.getNom() + " " + user.getPrenom(), Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), HomePageActivity.class);
                    startActivity(intent);
//                }
//                else {
//                    Toast.makeText(getApplicationContext(), "désolé, cet identifiant n'est pas dans la base ",Toast.LENGTH_LONG).show();
//                }




            }
        });


    }


  /*
  test de connexion d'un nouvel user

      Utilisateur user=null;


    user= userbd.getUser("olive","olive");
        if(user!=null)
            Toast.makeText(getApplicationContext(), "Bonjour Monsieur "+user.getNom()+" "+user.getPrenom(),
    Toast.LENGTH_LONG).show();
        else
                Toast.makeText(getApplicationContext(), "désolé, cet identifiant n'est pas dans la base ",
    Toast.LENGTH_LONG).show();


*/
}
