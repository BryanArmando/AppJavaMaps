package com.example.projectjavaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }



    public void IrLoginAct(View view){
        Intent irLog = new Intent(this, NewActivity.class);
        startActivity(irLog);
    }

    public void IrTabs(View view){
        Intent iniciarTabs = new Intent(this, GeolocActivity.class);
        startActivity(iniciarTabs);
    }
}