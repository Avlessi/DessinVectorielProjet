#Projet d'architecture logicielle - Un langage de dessin vectoriel

On souhaite définir un langage de dessin vectoriel, utilisable à partir d'une application écrite en Java. Un dessin vectoriel est d'abord produit dans un espace logique, euclidien, puis affiché dans un espace physique particulier, de nature matricielle, comme un écran formé de pixels. Voir Wikipedia et son entrée Image vectorielle pour une introduction au dessin vectoriel et une comparaison avec le dessin matriciel. L'objectif de ce projet est triple :
- la définition d'un langage simple pour dessiner logiquement,
- la définition d'interprétations des dessins logiques pour les afficher dans des espaces physiques,
- l'interfaçage du langage de dessin avec Java, permettant d'écrire directement un script de dessin en Java.
Le but du projet est donc de permettre de construire dans un programme en Java un script définissant un dessin logique, puis son interprétation permettant de représenter ce dessin en traduisant les instructions présentes dans le script en commandes associées à une interface graphique particulière.~


