Exercices

Exercice 1 : Liste chaînée

Le but de cet exercice est de créer notre propre liste chaînée. Une liste chaînée est un ensemble dont les éléments sont reliés les uns aux autres, de manière unidirectionnel.

1.1°) 

Créer une classe "Element" possédant une valeur de type int et un Element suivant, représentant le prochain élément de la liste.

Créer deux constructeurs de la forme "Element (int value)" et "Element (int value, Element next)".

Ecrire les méthodes "int getValue()", "Element getNext()" et "void setNext(Element next)" qui sont les accesseurs et modifieurs de la classe Element.

Ecrire la méthode "boolean equals (Object obj)" qui vérifie que deux éléments sont identiques. On considère que deux éléments sont égaux si leur valeur et LA REFERENCE du prochain élément est identique. On fera particulièment attention de ne pas appeler la méthode "equals" de Element pour tester que les suivants sont identiques.

Ecrire la méthode "String toString()" qui renvoie une chaîne de la forme "<valeur> ->" où <valeur> est la valeur de l'élément courant.

1.2°) 

Créer une classe "LinkedList" possédant une référence vers la tête de la file. Cette référence doit toujours être conservée et modifiée uniquement si l'on doit changer la tête. 

Créer un constructeur de la forme "LinkedList(Element head)".

Ecrire la méthode "boolean isEmpty()" qui renvoie vrai s'il n'y a aucun élément dans la liste.

Ecrire la méthode "int size()" qui renvoie le nombre d'éléments de la liste chainée.

Ecrire la méthode "String toString()" qui affiche les éléments de la liste chaînée. Cette méthode doit utiliser un StringBuffer.

Ecrire la méthode "void add(int val)" qui ajoute un nouvel élément à la fin de la liste dont la valeur est spécifiée. Si la liste est vide, ce nouvel élément devient alors la tête de la liste.

Ecrire la méthode "void addAll(int[] values)" qui ajoute l'ensemble des éléments du tableau à la fin de la liste, dans l'ordre dans lequel le tableau est donné. Si la liste et vide, la tête est donc le premier élément du tableau. CETTE METHODE NE DOIT PAS APPELER LA METHODE ADD PRECEDEMMENT REALISEE.

Exemple : Si la liste vaut 1 -> 2 et que le tableau a les valeurs [1,4,7], le résultat sera 1 -> 2 -> 1 -> 4 -> 7.

Ecrire la méthode ""Element remove(int val)" qui supprime le premier élément dont la valeur est spécifiée , et le retourne. Si la liste est vide ou que l'élément n'est pas trouvée, cette méthode renvoie null.

Exemple : Si la liste vaut 1 -> 2 -> 1 -> 2 et que l'on supprime 2, alors le résultat sera 1 -> 1 -> 2.

Tester votre programme avec le main suivant qui sera dans la classe LinkedList :

  public static void main(String[] args) {
    LinkedList l = new LinkedList(new Element(1));
    l.add(2);
    l.add(3);
    l.add(4);
    l.addAll(new int[] {5, 6, 7});
    System.out.println(l);
    System.out.println(l.size());
    l.remove(5);
    l.remove(2);
    System.out.println(l);
  }

