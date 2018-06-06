package com.example.thomas.gestionrestau;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.util.List;

public class afficher_activity extends AppCompatActivity {

    gestionBD bdd = new gestionBD(this);
    public ListView laliste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afficher);
        laliste = (ListView) findViewById(R.id.LvAffiche); // on déclare la listview
        List<commande> lesCommandes = bdd.getLesCommandes(); // On crée une liste qui récupère une collection de commandes
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lesCommandes); // On utilise un adaptateur pour lui assigné la collection
        laliste.setAdapter(adapter); // on assigne la collection de l'adaptateur dans la liste view
    }

        };




















