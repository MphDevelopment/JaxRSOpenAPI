# TP2 TAA

### Architecture du projet
Le projet contient trois packages dao, domain, rest ; ainsi que 2 classes permettant d'executer le projet TestApplication.java
et RestServer.java

1. Comme pour le tp1, le package domain contient les classes métiers et le package dao contient les classes DAO.
2. le package rest contient les ressources REST offrant une API pour interragir avec la base de données en passant pas les DAO. (Contient uniquement la resource pour la class métier *Employee*)
3. Le dossier `src/webapp/` contient les ressources web, notamment pour Swagger.

### Exécution du projet
1. Comme pour le tp1 il faut ouvrir la base de données hsql
2. Exécuter la classe RestServer.java pour mettre le serveur en ligne

### Utilisation
Cette implémentation couvre uniquement la classe métier Employee.java. L'API interagissant avec cette classe métier est disponible à l'addresse http://localhost:8080/employee avec différentes utilisations :
- La racine de la ressource ([/employee](http://localhost:8080/employee)) permet de lister les employees existant dans la base de données
- l'addresse `/employee/{id}` permet de retourner les informations de l'employee ayant pour id `{id}`
- La racine de la ressource permet aussi d'insérer un employee à l'aide de la méthode POST en passant un objet JSON respectant la construction de la classe métier.
Il est possible de poster en utilisant par exemple curl, ou l'application Postman.

J'ai aussi essayé d'intégrer swagger à l'addresse http://localhost:8080/api mais il ne semble pas détecter les informations des APIs disponible malgré la présence du fichier openapi.json, il charge cependant correctement son fichier index.html.
