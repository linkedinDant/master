Exercice : Graphe

Le but de cet exercice est de créer un simple graphe. Un noeud est composé d'un nom et d'une liste de voisins, eux-mêmes des noeuds. On peut ainsi imaginer qu'il s'agit de stations de métros.

Créer une classe Node ayant deux variables d'instance représentant le nom et la liste des voisins du noeud.

Créer un constructeur de la forme "Node(String name)" initialisant toutes les variables d'instance.

Créer la méthode "String getName()" qui renvoie le nom du noeud appelant.

Créer les méthodes "int size()" et "boolean isEmpty()" qui renvoient, respectivement, le nombre de voisins du noeud appelant et vrai si le noeud n'a pas de voisins.

Créer la méthode "boolean equals(Object ob)" qui renvoie vrai si deux noeuds sont identiques. On considère que deux noeuds sont identiques s'ils ont le même nom.

Créer la méthode "String toString()" qui renvoie le nom du noeud appelant.

Créer les méthodes "boolean addNode(Node n)", "boolean removeNode(Node n)" et "Node getNode(int i)" qui, respectivement, ajoute un voisin, enlève un voisin et renvoie le voisin à l'indice spécifié.

Créer la méthode "Node getNode(String name)" qui renvoie le noeud dont le nom est spécifié, null s'il n'existe pas.

Créer la méthode "Node addNode(String name)" qui crée un nouveau noeud avec le nom spécifié et l'ajoute dans les voisins du noeud appelant. Si l'ajout échoue, cette méthode doit renvoyer null, sinon le noeud nouvellement créé.

Créer la méthode "void send(String dest, String message)" qui envoie un message à tous les voisins du noeud appelant. Si ce-dernier est le destinataire du message, il l'affiche sous la forme "[<name>] : <message>" où name est le nom du noeud appelant et message le message à afficher.

