package com.example.projectjavaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

    //método para redirigir a los tabs

    public void IniciarSesion(View view){
        Intent iniciar = new Intent(this, TabsActivity.class);
        startActivity(iniciar);
    }

    //redirigir al registro
    public void IrRegistro(View view){
        Intent irRegistro = new Intent(this, RegisterActivity.class);
        startActivity(irRegistro);
    }
}