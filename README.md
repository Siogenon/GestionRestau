# gestionRestau
Application mobile 

Android studio : Réalisation d'une application permettant l'ajout et la gestion de commandes.

- Les classes sont directements accecibles cliquant ici :
https://github.com/Siogenon/gestionRestau/tree/master/app/src/main/java/com/example/thomas/gestionrestau 


* Cliquez-ici pour la démo vidéo :
[![Démo vidéo](https://img.youtube.com/vi/rLzL5IhYaaE/0.jpg)](https://www.youtube.com/watch?v=rLzL5IhYaaE)


= > Fonctionnalités :

- Login ( sans utilisation de la base de donnée SQLite ) 

- Ajout de commandes (Base de données SQLite)

- Affichage de toute les commandes ( Base de données SQLite)

- Modifications d'une commande en saisissant le nom du titulaire de la commande ( Base de données Sqlite)

- Suppression  d'une commande en saisissant le nom du titulaire de la commande ( Base de données SQlite)

- Prix calculé en fonction des options choisis. ( Base de données SQlite )


<img height="200" src = http://image.noelshack.com/fichiers/2018/23/4/1528352640-acceuil.png /> Acceuil (main_activity.xml)


<img height="200" src = http://image.noelshack.com/fichiers/2018/23/4/1528352644-ajout.png /> Ajout (ajout_activity.xml)


<img height="200" src = http://image.noelshack.com/fichiers/2018/23/4/1528352644-recherchemodifsupp.png /> Recherche/modification/delete (modify_activity.xml)


<img height="200" src = http://image.noelshack.com/fichiers/2018/23/4/1528352645-afficher.png /> Affichage ( afficher_activity.xml)


<img height="200" src =  http://image.noelshack.com/fichiers/2018/23/4/1528352640-choix.png /> Choix ( activit_commande.xml)





=> 1 table 
Commande ( id : int, plat text, supplement text, nom text, prix float
   id : clé primaire ) 

=> 5 Layout ( XML fournis)
=> 7 classes ( disponible sur le lien ci-dessus ) 


-GestionBD.java : Gestion des requêtes et de la base de données
-Commande.java : Classe commande basique avec ses accecceurs.

-Commande_activity.java : Fenêtre d'activité de choix entre ajout, gestion, suppression

-Commande_ajout.java : Fenêtre d'activité pour ajouté une commande (plats, suppléments, nom, prix calculé )

-Afficher_activité.java : Fenêtre d'activité affichant une listview contenant toutes les commandes 

-Modifier_activité.java : Fenêtre d'activité permettant, en indiquant le nom de la commande, de l'afficher, et par la même, la modifier, voir la supprimé.





