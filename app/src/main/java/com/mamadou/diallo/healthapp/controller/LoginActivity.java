package com.mamadou.diallo.healthapp.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.mamadou.diallo.healthapp.R;

public class LoginActivity extends AppCompatActivity {

    private Button mLogInTrueBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mLogInTrueBtn = (Button) findViewById(R.id.activity_login_true_btn);

        mLogInTrueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),HomePageActivity.class);
                startActivity(intent);
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
