Exercice : Gestion de blog

Le but de cet exercice est de créer le squelette de base d'un blog. Un ensemble d'utilisateurs peut poster des messages sur un blog.

I°) La classe Post

Créer une classe Post comprenant un nom d'auteur, un message, et une date de publication (représentée par un "long").

Créer un constructeur vide et un constructeur de la fome "Post(String auteur, String message, long date)" qui initialise toutes les variables d'instance.

Créer tous les accesseurs / modificateurs (6 méthodes en tout).

Créer la méthode "boolean equals(Object ob)" qui vérifie que deux posts sont égaux. On considère que deux posts sont égaux si toutes les variables d'instance ont les mêmes valeurs.

Créer la méthode "String toString()" qui renvoie le message du post.

II°) La classe Blog

Créer une classe Blog comprenant la liste de tous les posts publiés, ainsi qu'un constructeur vide initialisant l'instance.

Créer les méthodes "List<Post> getPosts()",  "Post getPost(int i)" qui renvoie respectivement la liste des posts publiés, le post à l'indice spécifié.

Créer la méthode "boolean removePost(Post p)" qui supprime le post spécifié des posts publiés.

Créer la méthode "boolean publish(String auteur, String message)" qui publie un nouveau post. Pour récupérer la date courant, vous pouvez utiliser l'appel suivant "System.currentTimeMillis()".

Créer la méthode "List<Post> getPostsFrom(String auteur)" qui renvoie la liste des posts publiés par l'auteur spécifié.

Créer les méthodes "List<Post> getPostsAfter(long date)" et "List<Post> getPostsBefore(long date)" qui renvoie respectivement la liste de tous les posts publiés après la date spécifié et la liste de tous les posts publiés avant la date spécifié.

III°) La classe BlogManager

Créer une classe BlogManager qui contient un blog et une liste de noms d'utilisateurs, représentant tous les auteurs du blog.

Créer un constructeur de la forme "BlogManager(Blog blog)" qui initialise les variables d'instance. Créer un constructeur vide qui crée directement un nouveau blog. Ce constructeur DOIT faire appel au constructeur prenant un paramètre, et donc lui passer un nouveau blog.

Créer la méthode "void addUser(String user)" qui ajoute un nouvel auteur.

Créer la méthode "List<Post> getPosts()" qui renvoie la liste des posts publiés sur le blog géré par le BlogManager appelant.

Créer la méthode "boolean publish(String user, String message)" qui publie un nouveau post dans le blog. Si l'utilisateur spécifié n'est pas dans la liste des auteurs connus, cette méthode renvoie faux et ne publie rien. Sinon elle publie le post.  
