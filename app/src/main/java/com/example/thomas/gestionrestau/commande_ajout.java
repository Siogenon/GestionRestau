package com.example.thomas.gestionrestau;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import android.widget.RadioButton;
import android.widget.Toast;

public class commande_ajout extends AppCompatActivity {

    public CheckBox chekKebab, ChekPanini, CheckTacos, CheckBurger, CheckFrite, CheckNugget;
    Button btsajout;
    EditText tbnom;
    gestionBD bdd = new gestionBD(this);
    String nom = "vide";
    String plats = "vide";
    String supp = "vide";
    int prix = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.commande_ajout);
        btsajout = (Button) findViewById(R.id.BtAjout);

        tbnom = findViewById(R.id.TbNomclient);
        chekKebab = findViewById(R.id.cbKebab);
        CheckBurger = findViewById(R.id.cbBurger);
        CheckTacos = findViewById(R.id.cbTacos);
        ChekPanini = findViewById(R.id.cbPanini);
        CheckFrite = findViewById(R.id.cbFrite);
        CheckNugget = findViewById(R.id.cbNugget);


        btsajout.setOnClickListener(new View.OnClickListener() {
            @Override


                public void onClick(View v) {

                 //plats
                if (chekKebab.isChecked()) { plats = "Kebab"; prix = prix + 4 ; }
                if (CheckBurger.isChecked()) { plats = "Burger"; prix = prix + 5 ;}
                if (ChekPanini.isChecked()) { plats = "Panini" ; prix = prix + 3; }
                if (CheckTacos.isChecked()) { plats = "Tacos" ; prix = prix + 7; }

                // Suppléments:
                if (CheckFrite.isChecked()) { supp = "Frite" ; prix = prix + 2 ; }
                if (CheckNugget.isChecked()) { supp = " Nugget" ; prix = prix + 3 ;}


                 nom = tbnom.getText().toString();

                   commande lacommande = new commande(plats, supp, nom, prix);

                    try {
                        boolean insertData = bdd.addCommande(lacommande); // un booleen pour vérifié que ça a fonctionné

                        if (insertData) {
                            toastMessage("Commande bien ajouté !");
                        } else {
                            toastMessage("Erreur lors de l'insertion");
                        }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }});




        }

    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }

    }


