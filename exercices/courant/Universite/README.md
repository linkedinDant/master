Exercices

Exercice 2 : Gestion d'une université.

2.1°) Etudiant

Créer une classe "Etudiant" contenant un numéro d'étudiant, de type int, et les nom et prénom de l'étudiant.

Créer un constructeur vide qui initialise le numéro d'étudiant. On utilisera le code suivant pour générer un numéro d'étudiant : "(int) (Math.random() * 10000000);"

Créer un constructeur prenant un nom et un prénom, et qui initialise l'ensemble des variables d'instance.

Ecrire les méthodes "String getNom()", "String getPrenom()", "void setNom(String nom)","void setPrenom(String prenom)","int getNumero()".

Ecrire la méthode "boolean equals(Object ob)" qui renvoie si deux étudiants sont égaux. Deux étudiants sont égaux si leurs numéros d'étudiants sont les mêmes.

Ecrire la méthode "String toString()" qui renvoie le numéro d'étudiant.

2.2°) Enseignant

Créer une classe "Enseignant" contenant le nom du professeur.

Créer un constructeur prenant un nom et qui initialise l'ensemble des variables d'instance de la classe.

Ecrire les méthodes "String getNom()", "void setNom(String nom)".

Ecrire la méthode "boolean equals(Object ob)" qui renvoie si deux enseignants sont égaux. Deux enseignants sont égaux si leurs noms sont les mêmes.

Ecrire la méthode "String toString()" qui renvoie le nom de l'enseignant.

2.3°) Module

Créer une classe "Module" qui représente une UE de l'université. 
Un module possède une ArrayList<Etudiant> qui est la liste des étudiants inscrits à l'UE, un enseignant qui donne le cours, et un nom.

Créer un constructeur "Module(String nom, Enseignant prof)" qui initialise l'ensemble des variables d'instance. 

Ecrire les méthodes "String getNom()", "Enseignant getProf()",  "ArrayList<Etudiant> getInscrits()" qui sont les accesseurs de la classe.

Ecrire la méthode "String toString" qui renvoie le nom du module.

Ecrire la méthode "boolean equals(Object ob)" qui renvoie vrai si deux modules sont égaux. Deux modules sont égaux si leurs noms sont identiques.

Ecrire les méthodes "void inscrireEtudiant(Etudiant etu)", "void desinscrireEtudiant(Etudiant etu)" qui respectivement ajoutent et suppriment un étudiant du module.

Ecrire les méthodes "int nombreEtudiant()", "boolean estInscrit(Etudiant etu)" qui renvoient respectivement le nombre d'étudiants du module, et vérifie qu'un étudiant est bien inscrit dans le module.

2.4°) Universite

Créer une classe "Universite" contenant un nom et 3 ArrayList de type Etudiant, Enseignant, Module (ArrayList<Etudiant<, ...) qui représentent respectivement l'ensemble des étudiants, enseignants et modules de l'universite.

Créer un constructeur de la forme "Universite(String nom)" qui initialise toutes les variables d'instance.

Ecrire les méthodes "String getNom()" et "String toString()" qui renvoient le nom de l'université.

Ecrire les méthodes "boolean inscrireEtudiant(String nom, String prenom)", "boolean inscrireEnseignant(String nom)" qui ajoutent respectivement un nouvel étudiant et un nouveau professeur dans l'université. Pour le type de retour, utilisez le type de retour des méthodes d'ajout de l'ArrayList.

Ecrire la méthode "boolean ajouterModule(String module, String prof)" qui ajoute le module dont l'enseignant est spécifié. Si le professeur n'est pas inscrit dans l'université, cette méthode renvoie false. Sinon, elle ajoute le module avec l'enseignant dans la liste des modules disponibles.

Ecrire la méthode "void addEtudiantOnModule(Module module, Etudiant etu)" qui ajoute l'étudiant spécifié dans le module spécifié. Si l'étudiant n'est pas inscrit à l'université, cette méthode l'inscrit automatiquement.

Ecrire la méthode "ArrayList<Etudiant> getEtudiantsFromModule(String module)" qui renvoie la liste des étudiants du module spécifié. Si le module n'existe pas, cette méthode renvoie null.
  


  
  
