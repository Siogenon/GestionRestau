package com.example.thomas.gestionrestau;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;


public class gestionBD extends SQLiteOpenHelper {

    private static final String TABLE_NAME = "commande";
    private static final String KEY = "id";
    private static final String PLAT = "plat";
    private static final String SUPP = "supplement";
    private static final String NOM = "nom";
    private static final String PRIX = "prix";
    protected final static int VERSION = 3;
    protected final static String NOM_DB = "restau.db";

    public gestionBD(Context context) { // constructeur
        super(context, NOM_DB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase	db)	{ // Permet de créée la base de données au démarrage de l'application
        String	CREATE_COMMANDE_TABLE	= "CREATE TABLE " + TABLE_NAME + " (" + KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " + PLAT + " TEXT, " + SUPP + " TEXT," + NOM + " TEXT, " + PRIX + " FLOAT " + " );";
        db.execSQL(CREATE_COMMANDE_TABLE);
        db.execSQL("INSERT INTO commande (plat, supplement, nom, prix)	"+ " VALUES ('panini', 'frite', 'genon', '04')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase	db,	int oldVersion,	int newVersion)	{
        //	On supprime l'ancienne table si elle existe
        db.execSQL("DROP	TABLE	IF	EXISTS	" +	TABLE_NAME);
        //	Et on la recrée
        onCreate(db);
    }

    public boolean  addCommande(commande	unecommande) { // Fonction pour ajouter une commande via objet commande
        SQLiteDatabase db = this.getWritableDatabase();//On ouvre la base
        ContentValues values = new ContentValues();
        values.put(PLAT, unecommande.getPlatc());
        values.put(SUPP, unecommande.getSupplementC());
        values.put(NOM, unecommande.getNom());
        values.put(PRIX, unecommande.getPrixC());
       long resultat = db.insert(TABLE_NAME, null, values);
        db.close();

        if (resultat == -1) {  // si le resultat est vide on retourne faux, permet de vérifié le bon déroulement de la requpete
            return false;
        } else {
            return true;
        }
    }

    public List<commande> getLesCommandes()	{ // On retourne toute les commandes dans une List
        List<commande>	lescommandes	=	new ArrayList<commande>();

        String	selectQuery	=	"SELECT		*	FROM	" +	TABLE_NAME;
        SQLiteDatabase	db	=	this.getReadableDatabase();
        Cursor	cursor	=	db.rawQuery(selectQuery,	null);
        if (cursor.moveToFirst())	{
            do {
                commande	unecommande	=	new commande();
                unecommande.setId(Integer.parseInt(cursor.getString(0)));
                unecommande.setPlatC(cursor.getString(1));
                unecommande.setSupplementC(cursor.getString(2));
                unecommande.setNom(cursor.getString(3));
                unecommande.setPrixC(Integer.parseInt(cursor.getString(4)));
                lescommandes.add(unecommande);
            }	while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return lescommandes;
    }


    public Cursor getunecommande(String name) { // Pour récupéré une seul commande ( pour la recherche)
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT  *  " + " FROM " + TABLE_NAME +
                " WHERE " + NOM + " = '" + name + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public void modifiercommande(String _oldNom, String _plats,  String _supp, String _nom, Float _prix)	{
        SQLiteDatabase	db	=	this.getWritableDatabase();
  // Modifie une commande via le nom
        ContentValues	values	=	new ContentValues();
        String query = "UPDATE " + TABLE_NAME + " SET " + PLAT +
                " = '" + _plats + "' , "
                + SUPP +  " =  '" + _supp  + "' , "
                + NOM  +  " =  '" + _nom   +  "' ,  "
                + PRIX +  " =  '" + _prix  + "' WHERE " + NOM + " = '" + _oldNom + "'";
        db.execSQL(query);
        db.close();
    }

    public Cursor getidcommande(String name) { // Récupération de l'id d'une commande, je le convertie après de curseur a int
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + KEY + " FROM " + TABLE_NAME +
                " WHERE " + NOM + " = '" + name + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public void supprimerUnecommande(int id)	{ // suppression d'une commande.
        SQLiteDatabase	db	=	this.getWritableDatabase();
        db.delete(TABLE_NAME,	KEY +	"	=	?",
                new String[]	{	String.valueOf(id)	});
        db.close();
      }
    }
