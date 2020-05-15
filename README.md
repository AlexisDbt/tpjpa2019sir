# Application doodle - Backend

## Prérequis

Utilisation de JPA pour la base de données

## Installation

Lancer la base à l'aide du fichier : 

**run-hsqldb-server.bat** présent à la racine du projet

puis :

**show-hsqldb.bat** en modifiant l'URL par : jdbc:hsqldb:hsql://localhost/

Ensuite dans un IDE, lancer **JPAtest.java** afin de préremplir la base avec quelques données.

Et enfin lancer le serveur à l'aide de la commande : **mvn tomcat7:run**

## Page d'accueil

Se dirigier vers l'URL : **localhost:8081**

Puis accéder aux fonctionnalités décrites dans le **readme** du répo front disponible ici : https://github.com/AlexisDbt/tpSIRFront
