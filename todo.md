##Le langage

Pour la définition du langage, nous nous inspirons du langage Asymptote. Pour dessiner logiquement, on retient quatre commandes fondamentales, dont voici la description : 
- dessiner : Cette commande permet de dessiner à l'intérieur d'un dessin un chemin en utilisant un crayon.
- remplir : Cette commande permet de remplir au sein d'un dessin l'intérieur d'une figure délimitée par un circuit (un chemin fermé) en utilisant un crayon.
- insérer : Cette commande permet d'insérer un dessin limité par un contour à l'intérieur d'un autre dessin.
- étiqueter : Cette commande permet de placer une étiquette à une position donnée à l'intérieur d'un dessin.

Le langage, qui est typé, contient les types suivants.
- Chemin : On peut définir un chemin de différentes manières, par exemple par un polygone ou une courbe de Bézier.
- Crayon : Un crayon se caractérise par une épaisseur de trait et une couleur. Il doit être possible de déclarer des variables avec l'un des types puis de modifier leur valeur. Enfin, pour contrôler l'exécution des instructions, on doit disposer d'opérateurs de contrôle, tels que ceux qui suivent. 
- Séquence : Cet opérateur permet d'exécuter une première instruction, puis une seconde.
- Alternative : Cet opérateur permet de choisir des instructions à exécuter suivant une condition booléenne. Il correspond à l'instruction classique if … then … else ….
- Boucle : Cet opérateur permet de répéter un certain nombre de fois des instructions. Le nombre peut être fixé a priori (for) ou déterminé a posteriori par une condition (boucles while).

##L'interprétation

Une fois que le langage est défini, il est nécessaire de définir son interprétation. Alors qu'un script écrit dans le langage permet de définir logiquement un dessin vectoriel, l'interprétation permet de produire physiquement le dessin pour l'afficher. Une interprétation est constituée de deux phases, une phase de traduction pendant laquelle un script écrit dans le langage est traduit dans un autre langage dédié au rendu physique, et d'une phase d'exécution pendant laquelle un moteur de rendu produit le dessin physique à partir de la traduction du script. Plusieurs sortes d'interprétations sont envisageables, puisque différentes traductions et différents moteurs de rendu sont envisageables.

La traduction produit une représentation du script dans un autre langage. Cette représentation est alors interprétée par le moteur de rendu qui est externe à l'application Java. Par exemple, la traduction produit une version affichable ou imprimable du script de dessin vectoriel : le moteur ne le dessine pas alors mais l'affiche ou l'imprime dans ce cas. Autre exemple, plus effectif, la traduction produit un script écrit dans le langage SVG ("Scalable Vector Graphics", cf. Wikipedia et son entrée SVG), qui peut être interprété par un navigateur. Cette interprétation correspond alors à la traduction d'un langage de haut niveau vers un langage de plus bas niveau.
La traduction produit des instructions en Java. On parle alors de langage embarqué. L'interprétation de ses instructions est définie par leur implémentation, typiquement regroupée dans une bibliothèque. Par exemple, la traduction pourrait s'appuyer sur la classe java.awt.image.Raster, qui fournit les fonctionnalités utiles pour le dessin matriciel ("raster graphics"). Plus simplement, elle pourrait s'appuyer sur la classe (abstraite) java.awt.Graphics2D, qui fournit des fonctionnalités utiles pour le dessin vectoriel ("vector graphics").
Au final, au moins deux interprétations doivent être réalisées. L'une des interprétations doit correspondre à la production d'un fichier au format SVG.

##Modularité

L'implémentation du langage de dessin et de son interprétation doit être ouverte aux extensions suivantes, tout en étant fermée aux modifications.

L'extension du langage par une nouvelle commande ou une nouvelle structure de contrôle
L'ajout d'une nouvelle interprétation
Agenda et livrables

Projet à mener en deux sprints de quinze jours
Rendu intermédiaire : 2 novembre, 20 heures
Rendu final : 16 novembre, 20 heures
Utilisation pour le code source d'un dépôt public avec un gestionnaire de version
Recommandé : Github
Me fournir l'adresse du dépôt à sa création.
Pour chaque rendu, code commenté et documenté
Commentaires pour faciliter la compréhension du code
Documentation au format Javadoc (au moins pour les interfaces publiques)
Prévoir un fichier "readme".
Définir une fonction principale permettant de tester les capacités de dessin et décrire son appel dans le fichier "readme".
Pour chaque rendu, rapport de présentation de l'application présentant les points suivants - Quatre à six pages
- La définition du langage de dessin
- L'interprétation du langage (ou les interprétations)
- L'architecture logicielle
- Schéma général
- Principes modulaires suivis, patrons de conception utilisés, accompagnés des motivations pour les choix réalisés
- Méthode pour étendre le langage et ajouter une interprétation
- Un guide d'utilisation

##Commentaires

Voici quelques remarques, conseils et suggestions en vrac.

Il est recommandé d'utiliser des hiérarchies pour les interfaces.
L'architecture comporte deux couche : une couche haute correspondant au langage à concevoir, une couche basse correspondant au moteur de rendu.
Certains patrons de conception ("design patterns") semblent particulièrement adaptés pour ce projet (attention : certains choix peuvent être exclusifs).
Composite : pour représenter les scripts du langage
Interpréteur : pour représenter une interprétation
Visitor : pour représenter une fonction appliquée à un script (comme une interprétation)
Méthode modèle : pour représenter un script puis son interprétation
Etc.
Comment représenter un script? On peut le représenter par un texte dans un fichier, puis l'analyser pour produire un arbre de syntaxe abstraite. Un arbre de syntaxe abstraite représente le script sous une forme structurée, arborescente, faisant abstraction des détails syntaxiques. Il s'implémente typiquement par une structure de données de type Arbre en Java. Il n'est pas demandé de suivre cette voie, correspondant à une compilation, pour réaliser ce projet. Il est plutôt recommandé d'embarquer directement le langage de dessin dans le langage Java, ce qui permet d'éviter les phases d'analyse lexicale et syntaxique des scripts textuels. On représente alors directement le script par du code Java, suivant une architecture à définir, par exemple par un arbre, ou par une fonction paramétrée par les primitives de dessin. On pourra s'inspirer de la méthode décrite dans l'article Embedded Typesafe Domain Specific Languages for Java (2008).