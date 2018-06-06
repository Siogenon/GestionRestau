package com.example.thomas.gestionrestau;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import android.view.View;


public class commande_activity extends AppCompatActivity {

    Button btAffiche;
    Button btajout;
    Button btModif;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.commande_activity);
        btAffiche = (Button) findViewById(R.id.BtAffiche);
        btajout = (Button) findViewById(R.id.btajout);
        btModif = (Button) findViewById(R.id.btModif);

        btajout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(commande_activity.this, commande_ajout.class);
                startActivity(intent);
            }});

        btAffiche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(commande_activity.this, afficher_activity.class);
                startActivity(intent);
            }});

        btModif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(commande_activity.this, modifier_activity.class);
                startActivity(intent);
            }});

    }}
