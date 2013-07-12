Une pile est une structure de données permettant d'ajouter et de supprimer des éléments en LIFO. Le dernier arrivé dans la pile sera le premier sorti.
Ainsi si vous ajoutez successivement [1, 2, 3], vous récupérerez [3, 2, 1].

Créer une classe Stack (pile en anglais). Cette classe possède 2 variables d'instance, un tableau de Object qui va contenir les éléments de la pile et un entier servant de pointeur de pile. Ce-dernier
permet de connaître le nombre d'éléments se trouvant dans la pile. Il est donc incrémenté lors d'un ajout et décrémenté lors d'une suppression.

Créer un constructeur prenant en paramètre un entier "size" permettant de définir la taille de la pile.

Créer une méthode "public int size()" renvoyant le nombre d'éléménts de la pile

Créer une méthode "public boolean isEmpty()" renvoyant vrai si la pile est vide.

Créer une méthode "public boolean isFull()" renvoyant vrai si la pile est pleine.

Créer une méthode "public Object top()" renvoyant l'élément en haut de la pile SANS LE SUPPRIMER, ou null si la pile est vide.

Créer une méthode "public boolean push(Object ob)" qui ajoute l'élement dans la pile. Si la pile est pleine, cette méthode renvoie faux, et vrai si l'objet a bien été inséré.

Créer une méthode "public Object pop()" qui renvoie l'élément en haut de la pile et le supprime de la pile. Si la pile est vide, cette méthode renvoie null.


EXEMPLE D'UTILISATION :

Imaginons une pile contenant les éléments [1, 2, 3, 4] où le haut de la pile se situe à la fin (donc 4).

Etape			Pile
pop()			1, 2, 3
pop()			1, 2
push(5)			1, 2, 5
push(3)			1, 2, 5, 3
pop()			1, 2, 5
top()			1, 2, 5 (renverra 5)


