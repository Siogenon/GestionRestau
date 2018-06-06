package com.example.thomas.gestionrestau;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class modifier_activity  extends AppCompatActivity {
    Button btRecherche;
    Button btModifier;
    Button btSupprimer;
    EditText TBlenom, lePlat, leSupp, lePrix, tbNom;
    gestionBD bdd = new gestionBD(this);

    private String getnom;
    private String getplats;
    private String getSupp;
    private String getprix;
    private String lenomR;
    private float lebonprix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {  // On déclare tout les bouttons/edittext
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modif);
        btRecherche = (Button) findViewById(R.id.btRecherche);
        btModifier = (Button) findViewById(R.id.btModif);
        btSupprimer = (Button) findViewById(R.id.btDelete);
        TBlenom = (EditText) findViewById(R.id.tbRNom);
        tbNom = (EditText) findViewById(R.id.TbNom);
        lePlat = (EditText) findViewById(R.id.tbPlats);
        leSupp = (EditText) findViewById(R.id.tbSupp);
        lePrix = (EditText) findViewById(R.id.tbPrix);

        btRecherche.setOnClickListener(new View.OnClickListener() { //  CLIQUE BOUTON RECHERCHE
            @Override
            public void onClick(View v) {
                lenomR = TBlenom.getText().toString(); // on récupère la valeur saisie pour la recherche
                String name = lenomR;

                Cursor data = bdd.getunecommande(name); // curseur encore

                while (data.moveToNext()) {  // on parcours

                    lePlat.setText(data.getString(1)); // on attributs a chaque textbox la valeur adéquate
                    leSupp.setText(data.getString(2));
                    tbNom.setText(data.getString(3));
                    lePrix.setText(String.valueOf(data.getFloat(4)));
                    toastMessage("Effectué");
                }
            }
        });
        btModifier.setOnClickListener(new View.OnClickListener() { // CLIQUE DE MODIFICATION
            @Override
            public void onClick(View v) {
                String anciensnom = TBlenom.getText().toString();
                getnom = tbNom.getText().toString();   // On attribut le contenu des textbox dans des variables
                getplats = lePlat.getText().toString();
                getSupp = leSupp.getText().toString();
                getprix = lePrix.getText().toString();

                lebonprix = Float.parseFloat(getprix); // on convertie en float sinon ça bug
                try {
                    bdd.modifiercommande(anciensnom,getplats, getSupp, getnom, lebonprix); // On envoie tout ça en paramètre
                    toastMessage("La commande a bien été modifié ");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        btSupprimer.setOnClickListener(new View.OnClickListener() { // BOUTTON DE SUPPRESSION
            @Override
            public void onClick(View v) {

                lenomR = TBlenom.getText().toString();

                Cursor data = bdd.getidcommande(lenomR); // curseur pour récupéré la requête

                while (data.moveToNext()) { // on cherche a travers le resultat via curseur

                    int leid = (data.getInt(0)); // on récupère l'id de nom tapé dans la recherche
                    bdd.supprimerUnecommande(leid); // leid a bien reçu l'id, on le met en paramère pour le delete.
                    Toast.makeText(getApplicationContext(), "Commande bien supprimé, id : " + leid, Toast.LENGTH_LONG).show();
                }
                   }
    });
}


    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }

}