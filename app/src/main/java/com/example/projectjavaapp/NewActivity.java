package com.example.projectjavaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class NewActivity extends AppCompatActivity {

    private EditText email;
    private EditText password;

    private Button btnIniciarsesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        email=(EditText) findViewById(R.id.editTextTextEmailAddress);
        password=(EditText) findViewById(R.id.editTextTextPassword);
        btnIniciarsesion= findViewById(R.id.button);
    }
}