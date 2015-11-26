#Projet d'architecture logicielle - Un langage de dessin vectoriel

On souhaite définir un langage de dessin vectoriel, utilisable à partir d'une application écrite en Java. Un dessin vectoriel est d'abord produit dans un espace logique, euclidien, puis affiché dans un espace physique particulier, de nature matricielle, comme un écran formé de pixels. Voir Wikipedia et son entrée Image vectorielle pour une introduction au dessin vectoriel et une comparaison avec le dessin matriciel. L'objectif de ce projet est triple :
- la définition d'un langage simple pour dessiner logiquement,
- la définition d'interprétations des dessins logiques pour les afficher dans des espaces physiques,
- l'interfaçage du langage de dessin avec Java, permettant d'écrire directement un script de dessin en Java.
Le but du projet est donc de permettre de construire dans un programme en Java un script définissant un dessin logique, puis son interprétation permettant de représenter ce dessin en traduisant les instructions présentes dans le script en commandes associées à une interface graphique particulière.

###Description des fonctionnalités

Une classe principale d’une application s’appelle Dessin. Toutes les requêtes de la création des objets graphiques vont être adressées à cette classe. On peut la considérer comme une classe manager. 
Les fonctions principales que cette classe fournit ce sont :

- draw(Chemin chemin) – permet de dessiner une figure
-label() – permet d’étiqueter une figure
-	fill(Chemin chemin, Color color) – permet de remplir une figure d’un couleur
-	insert(Chemin chemin, int x, int y, int width, int height) – permet de clipper une figure dans une zone carrée indiquée
   
Chemin c’est une classe des modèles des figures qui peuvent être dessinées. Pour créer des figures le client peut se servir des fonctions de Dessin suivantes :

-	Chemin createPoint(int x, int y) – créer un point
-	Chemin createLine(int x1, int y1, int x2, int y2) créer une ligne
-	Chemin createArc(int center_x, int center_y, int rx, int ry, int startAngle, int arcAngle) créer une arc
-	Chemin createEllipse(int center_x, int center_y, int rx, int ry) – créer un ellipse
-	Chemin createCircle(int center_x, int center_y, int r) – créer une circle
-	Chemin createRectangle(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) – créer un rectangle

Chaque figure peut avoir son propre couleur et ses paramètres de l’épaisseur. Ce paramétrage est fait à l’aide de la classe Crayon. A chaque figure on peut associer une instance de Crayon.
Pour créer un crayon, il faut se servir d’une fonction de Dessin correspondante :

-	Crayon createCrayon(Color color, int thickness) 
Pour associer un crayon avec une figure, il faut utiliser une fonction de Chemin 
-	setCrayon(Crayon crayon)

Si un crayon n’est pas associé explicitement, une figure va utiliser un crayon par défaut dont les paramètres c’est un couleur noir et une épaisseur d’une valeur 1.

Si un client veut obtenir une figure plus complexe, il peut se servir de fonctions de Chemin :
  
-	Chemin connectWithLine(Chemin chemin) – fonction permet d’obtenir une nouvelle figure qui se compose des deux figures jointes par une ligne
-	Chemin connectWithBezier(Chemin chemin, int x1, int y1, int x2, int y2) – fonction permet d’obtenir une nouvelle figure qui se compose des deux figures jointes par une courbe de Bézier. Ici x1, y1, x2, y2 ce sont des points de contrôle d’une courbe de Bézier cubique.

Dans le projet il y a deux implémentations de la représentation des dessins vectoriels – celle qui est basée sur la librairie awt de java et celle basée sur svg. Pour choisir une représentation que vous voulez, il faut fournir un paramètre correspondant à un constructeur de la classe Dessin.

###Usage

Voici un exemple d’utilisation des fonctionnalités décrites ci-dessus:

Créer un dessin et choisir une représentation svg
```Dessin d = new Dessin(DrawType.SVG); ```
 pour choisir une représentation awt il faut faire DrawType.AWT
			
Créer un crayon
```Crayon pen = d.createCrayon(Color.BLUE, 1);```

Créer un cercle en precisant le center (800, 800) et un radius (100) 
```Chemin cercle = d.createCircle(800, 800, 100);```
			
Associer un crayon à un cercle
```cercle.setCrayon(pen);```
			
Remplir un cercle d'un couleur jaune
```d.fill(cercle, Color.YELLOW);```
			
Dessiner un cercle
```d.draw(cercle);```
			
Ajouter un texte 
```d.label("Cool text", 800, 750);```

Clipper un cercle dans une zone carrée indiquée
```d.insert(cercle, 800, 800, 100, 100);```
			
Faire une mise a jour du dessin du cercle. Si on le fait explicitement,
la mise a jour n'est pas garantie
```d.draw(cercle);```

Créer une ligne
```Chemin ligne = d.createLine(5, 5, 5, 15);
ligne.setCrayon(crayon);
d.draw(ligne); ```

Créer une autre ligne
```Chemin ligne2 = d.createLine(500, 5, 500, 15);
d.draw(ligne2); ```

Joindre des lignes par une courbe be Bezier cubique. 
```Chemin path = ligne.connectWithBezier(ligne2, 200, 100, 400, 100);
d.draw(path); ```

Créer une nouvelle ligne
```Chemin ligne3 = d.createLine(600, 40, 650, 100);
d.draw(ligne3);	```

Joindre une ligne avec une figure complexe obtenu précedemment
```Chemin path2 = path.connectWithLine(ligne3);
d.draw(path2);```

Voir un svg généré dans le navigateur. Si un autre DrawType était choisi, la fonction va pas avoir un effet. 
```d.viewInBrowser();```
Egalement un fichier svg généré peut etre retrouvé dans le dossier 'output'.

Vous pouvez trouvez un exemple pareil dans le fichier Main.java qui est dans le package 'common'.
