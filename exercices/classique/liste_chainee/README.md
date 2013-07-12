Le but de cet exercice est de créer une liste doublement chaînée. Une liste doublement chaînée est composée d'éléments ayant une valeur, et connaissance 
des éléments suivants et précédents. 

Cette liste est circulaire et ressemble à cela :
1 <-> 2 <-> 3.

L'élément 1 a pour suivant 2 et pour précédent 3.
L'élément 2 a pour suivant 3 et pour précédent 1.
L'élément 3 a pour suivant 1 et pour précédent 2.

L'élément 1 est appelée la tête (head) et l'élément 3 est la queue (tail).

Première partie : Element

Complétez la classe Element de manière à ce que ses méthodes et constructeurs renvoient et modifient le précédent, le suivant et la valeur.
La méthode toString renvoie la valeur de l'élément.
La méthode equals vérifie que l'élément spécifié est identique à l'élément courant. Pour cela, il faut s'assurer que l'élément spécifié est la même valeur et les mêmes suivant et précédent. 

Seconde partie : Liste

L'exercice est considéré comme terminé dès lors que le lancement de la méthode main dans la classe Liste affiche : "La liste chainée est valide !". 
Sinon, la méthode erronée est affichée.

Le constructeur de la classe Liste crée un nouvel élément depuis la valeur spécifiée. Cet élément devient la tête et la queue de la liste.

Les méthodes getHead et getTail renvoient respectivement la tête et la queue de la liste chaînée.

La méthode addFirst crée un nouvel élément depuis la valeur spécifiée et l'insère en tête de la liste. 
Il faut donc que :
 - La nouvelle tête ait pour suivant l'ancienne tête
 - La nouvelle tête ait pour précédent la queue
 - L'ancienne tête ait pour précédent la nouvelle tête
 - La queue ait pour suivant la nouvelle tête

Exemple : Si la liste est [1, 2], l'ajout de 3 fera changer la liste de la manière suivante [3, 1, 2].

La méthode addLast crée un nouvel élément depuis la valeur spécifiée et l'insère en queue de la liste.
Il faut donc que :
 - La nouvelle queue ait pour suivant la tête
 - La nouvelle queue ait pour précédent l'ancienne queue
 - L'ancienne queue ait pour suivant la nouvelle queue
 - La tête est pour précédent la nouvelle queue

Exemple : Si la liste est [1, 2], l'ajout de 3 fera changer la liste de la manière suivante [1, 2, 3].

La méthode size renvoie le nombre d'éléments de la liste. Puisqu'il s'agit d'une liste chaînée, il faut donc itérer sur tous les éléments
et compter.

La méthode find recherche le premier élément donc la valeur est spécifiée. Si la tête ou la queue est cet élément, elle le renvoie sans itérer.
Si l'élément n'existe pas, cette méthode doit renvoyer null.

La méthode contains renvoie vraie si l'élément dont la valeur est spécifiée existe dans la liste chaînée. En soit, la façon de faire est identique à la méthode find.

La méthode removeFirst supprime et renvoie le premier élément de la liste, donc la tête. S'il ne reste plus qu'un élément dans la liste (donc que la queue et la tête sont identiques), cette méthode renvoie null. Nous partons du principe que la liste doit toujours contenir au moins un élément.
Il faut donc que :
  - Le suivant de la tête a pour précédent la queue
  - La queue a pour suivant le suivant de la tête
  - Le suivant de la tête devient la tête
  
Exemple : Si la liste est [1, 2], l'appel à cette méthode fera changer la liste de la manière suivante [2].

La méthode removeLast supprime et renvoie le dernier élément de la liste, donc la queue. S'il ne reste plus qu'un élément dans la liste (donc que la queue et la tête sont identiques), cette méthode renvoie null. Nous partons du principe que la liste doit toujours contenir au moins un élément.
Il faut donc que :
  - Le précédent de la queue a pour suivant la tête
  - La tête a pour précédent le précédent de la queue
  - Le précédent de la queue devient la queue
  
Exemple : Si la liste est [1, 2], l'appel à cette méthode fera changer la liste de la manière suivante [2].