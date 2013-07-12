L'objectif de ce TP est de réaliser un outil de gestion de bibliothèque. Cet outil permettra de rechercher des livres selon différents critères (nom, auteur, année). 

Première partie : Book

Un livre possède un nom, un auteur et une année de parution. De plus, il contient un booléen permettant de savoir s'il est emprunté, ou non.
Implémentez toutes les méthodes de la classe Book.

Seconde partie : Library

La classe Library est l'outil permettant d'emprunter, de rendre et de rechercher des livres.
Pour tester votre code, vous pouvez lancer le main contenu dans la classe Library.

Une ArrayList est une classe standard Java permettant de stocker et de retrouver des objets. Les méthodes propres à la LinkedList sont aussi présentes dans la classe ArrayList (add, get, size, ...)

La méthode "size" renvoie le nombre de livres dans la bibliothèque.

La méthode "addBook" ajoute le livre spécifié dans la bibliothèque.

La méthode "rendre" rend le livre spécifié empruntable

La méthode "findByNom" recherche le premier ouvrage dont le nom est spécifié dans la liste et le retourne. Cette méthode retourne null si le livre n'existe pas.

La méthode "findByAuteur" retourne une nouvelle ArrayList contenant l'ensemble des livres ayant le même auteur. Cette méthode retourne une liste vide si aucun livre n'est trouvé.

La méthode "findByAnnee" retourne une nouvelle ArrayList contenant l'ensemble des livres ayant la même date d publication. Cette méthode retourne une liste vide si aucun livre n'est trouvé.

La méthode "emprunter" recherche l'ouvrage dont le nom est spécifié et le rend non empruntable. Si le livre n'existe pas ou qu'il est déjà emprunté, cette méthode retourne faux.

Quelques méthodes de la classe ArrayList

get -> Retourne l'objet à la position spécifiée.
size -> Retourne le nombre d'éléments de la liste
add -> Ajoute un élément dans la liste

