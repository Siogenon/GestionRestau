package com.example.thomas.gestionrestau;

public class commande {

                  private int idC;
                  private String platC;// soit burger/panini/kebab/tacos
                  private String supplementC; // soit frite/nugget
                  private String nom; // nom du client passant commande
                  private float prixC; // prix total

     public commande (){};

     public commande (String platC, String supplementC, String nom, float prixC){ // constructeur pour l'ajout
         this.platC=platC;
         this.supplementC=supplementC;
         this.nom=nom;
         this.prixC=prixC;
     }
     // constructeur basique
     public commande (int idC, String platC, String supplementC, String nom, float prixC  )
     {

         this.idC = idC;
         this.platC=platC;
         this.supplementC=supplementC;
         this.nom=nom;
         this.prixC=prixC;
     }


     public int getId(){return idC;}
     public void setId(int idc){this.idC=idc;}

     public String getPlatc(){return platC;}
     public void  setPlatC(String platC){this.platC=platC;}

     public String getSupplementC(){return supplementC;}
     public void setSupplementC(String supplementC){this.supplementC=supplementC;}

     public String getNom(){return nom;}
     public void setNom(String nom){this.nom = nom;}

     public float getPrixC(){return prixC;}
     public void setPrixC(float prixC){this.prixC = prixC;}



    public String	toString(){
        return "Id :	"+	this.getId()	+",	plat :	" +	this.getPlatc()	+	", supplement : " +
                this.getSupplementC() + ", nom :  " + this.getNom() + ", prix :  " + this.getPrixC();
    }

}
