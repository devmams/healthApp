package com.mamadou.diallo.healthapp.controller;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.mamadou.diallo.healthapp.R;

public class MainActivity extends AppCompatActivity {

    private Button mLogInBtn;
    private Button mSignUpBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLogInBtn = (Button) findViewById(R.id.activity_main_login_btn);
        mSignUpBtn = (Button) findViewById(R.id.activity_main_signup_btn);

        mLogInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });

        mSignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SignupActivity.class);
                startActivity(intent);
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
