package com.example.thomas.gestionrestau;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btseco;  // On déclare les boutons
    EditText username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btseco = (Button)findViewById(R.id.Btco);
         username = (EditText) findViewById(R.id.TbPseudo);
         password = (EditText) findViewById(R.id.TBpass);

     btseco.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
                 Intent intent = new Intent(MainActivity.this, commande_activity.class);
                 startActivity(intent);  // On démarre l'activité si les mot de pass et pseudos tapés correspondent a ceux ci-dessus

             } else {
                 Toast.makeText(getApplicationContext(), "Mauvais identifiants", Toast.LENGTH_SHORT).show();

             }
         }
     });}}

