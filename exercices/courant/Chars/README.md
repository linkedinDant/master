Exercice : La classe Chars

L'objectif de cet exercice est de réécrire la classe String. Cette-dernière ne permet pas de modifier ses variables d'instances, et recréer des instances dès qu'elle le peut. Ainsi on appelle cette classe, une classe immutable. Pour cette raison, nous allons créer une variante mutable. La majorité des méthodes à implémenter est reprise de la classe String dont la documentation est ci-dessous.

La documentation de la classe String est ici : http://docs.oracle.com/javase/7/docs/api/java/lang/String.html

Créer la classe Chars ne contenant qu'un tableau de caractères.

Créer les constructeurs "Chars(int size)", "Chars(char[] array)", "Chars(String s)", "Chars(StringBuilder sb)" qui initialise les variables d'instance. Le premier constructeur ne fait que créer un tableau vide dont la taille est fixée. 

Créer les méthodes "int length()" et "boolean isEmpty()" qui renvoie respectivement le nombre de caractères et vrai si le Chars est vide.

Créer la méthode "boolean equals(Object ob)" qui renvoie vrai si deux Chars sont identiques. Ceux-ci sont identiques si leurs caractères sont identiques.

Créer la méthode "String toString()" qui convertit le tableau de caractères en String.

Créer les méthodes "char charAt(int pos)" et "char setChar(char c, int pos)" qui, respectivement, renvoie le caractère à la position pos et modifie le caractère à la position pos en le remplaçant par le nouveau caractère. L'ancien caractère contenu à la même position est alors renvoyé.

Créer la méthode "Chars getChars(int src, int end, Chars c, int dest)" qui copie les caractères de "src" inclus à "end" exclus dans le Chars c à partir de la position pos. Cette méthode renvoie l'instance appelante. Exemple : Si on a les Chars "Salut" et "Bonjour" et que l'on appelle le Chars "Salut".getChars(1, 4, "Bonjour", 2) cela modifiera le Chars "Bonjour" qui vaudra --> "Boaluur".

Créer la méthode "int indexOf(char c)" qui renvoie la position du premier char c dans le Chars appelant et -1 s'il n'existe pas. 

Créer la méthode "int lastIndexOf(char c)" qui renvoie la position du dernier char c dans le Chars appelant et -1 s'il n'existe pas. 

Créer la méthode "Chars replace(char find, char c)" qui remplace tous les caractères "find" par "c" et renvoie l'instance courante. Exemple : "Anaconda" et find = 'a' et c = 'r', le Chars appelant vaudra : "Anrcondr" (on prend en compte la casse).

Créer les méthodes "Chars subString(int end)", "Chars subString(int from, int end)" qui renvoie la sous-chaine comprise est from et end. La première méthode part du postulat que le début est 0. Exemple : "Télévision".subString(3, 7) renverra "évis".

Créer les méthodes "Chars concat(String s)", "Chars concat(Chars s)" qui concatène la chaine de caractère passé en paramètre dans le Chars appelant. Exemple : Si le Chars appelant valait "123" et qu'on lui passe un Chars qui vaut "456" alors le Chars appelant vaudra "123456".