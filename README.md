# gestionRestau
Application mobile 

Android studio : Réalisation d'une application permettant l'ajout et la gestion de commandes.

https://www.youtube.com/watch?v=rLzL5IhYaaE Démo vidéo.


*Les classes sont directements accecibles cliquant ici :
https://github.com/Siogenon/gestionRestau/tree/master/app/src/main/java/com/example/thomas/gestionrestau 


= > Fonctionnalités :

- Login ( non sqlite ) 

- Ajout de commande 

- Affichage de toute les commandes 

- Modifications d'une commande en saisissant le nom du titulaire de la commande

- Suppression  d'une commande en saisissant le nom du titulaire de la commande

- Prix calculé en fonction des options choisis.

=> 1 table 
Commande ( id : int, plat text, supplement text, nom text, prix float
   id : clé primaire ) 

=> 5 Layout 
=> 7 classes ( disponible sur le lien ci-dessus ) 


-GestionBD.java : Gestion des requêtes et de la base de données
-Commande.java : Classe commande basique avec ses accecceurs.

-Commande_activity.java : Fenêtre d'activité de choix entre ajout, gestion, suppression

-Commande_ajout.java : Fenêtre d'activité pour ajouté une commande (plats, suppléments, nom, prix calculé )

-Afficher_activité.java : Fenêtre d'activité affichant une listview contenant toutes les commandes 

-Modifier_activité.java : Fenêtre d'activité permettant, en indiquant le nom de la commande, de l'afficher, et par la même, la modifier, voir la supprimé.





