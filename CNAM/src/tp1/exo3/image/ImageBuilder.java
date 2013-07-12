package tp1.exo3.image;

import java.awt.Color;

public class ImageBuilder {

  public static char[] conversion = { '.', 'g', 'b', 'o', 'r', 'w', '*', '!', 'm' };

  public static Color[] convColor = { Color.gray, Color.green, Color.blue, Color.black, Color.red, Color.white, Color.cyan, Color.cyan,
      new Color(200, 150, 128) };

  private Color[][] terrain;
  private int longueur, hauteur;

  /**
   * Cette méthode a pour but d'initialiser les variables d'instance. Elle lit le fichier spécifié en paramètre et génère un tableau de Colors. 
   * La hauteur correspond au nombre maximum de lignes, la longueur à la taille maximale de celles-ci. 
   * Description de l'algorithme à écrire :
   *  - Lire le fichier dont le nom est passé en paramètre grâce à la classe TrackReader et sa méthode read. Cette méthode renvoie un tableau de String correspondant aux lignes du fichier.
   *  - Les deux premières lignes de chaque fichier contient les dimensions de l'image, il faut donc initialiser longueur / hauteur avec ces valeurs. Pour convertir un String en int, il faut utiliser Integer.parseInt(String s)
   *    Exemple : int c = Integer.parseInt("5"); la variable c vaudra 5.
   *  - Initialiser la matrice bidemensionnelle. Cette matrice est de la forme "terrain[longueur][hauteur]".
   *  - On parcourt "hauteur fois" le tableau en partant de 2 jusqu'à hauteur + 2 (car les 2 premières lignes contiennent respectivement la longueur et la hauteur)
   *    - On parcourt "longueur fois" le tableau
   *        - On récupère le caractère de la ligne. Récupérer le caractère "i" d'un String se fait avec la méthode charAt de ce-dernier. 
   *          Exemple : char c = "Salut".charAt(2) renverra "l". La description de la méthode est ici -> http://docs.oracle.com/javase/7/docs/api/java/lang/String.html#charAt(int)
   *        - On transforme le caractère récupéré en Color grâce à la méthode conversion qui est à réaliser plus bas.
   *        - On insère la couleur dans la matrice AU BON ENDROIT (attention il y a un piège avec le bon endroit)
   *       
   */
  public void read(String filename) {
      //TODO : A compléter
  }

  /**
   * Transforme le caractère spécifié en couleur. Il existe une concordance entre les deux tableaux static de cette classe, grâce à l'indice. L'indice d'un caractère dans le premier tableau
   * correspond à la couleur équivalente dans l'autre tableau.
   * Exemple : Le caractère 'g' du tableau "conversion" est à l'indice 1, donc sa couleur est à l'indice 1 du tableau "convColor"
   */
  private Color conversion(char carac) {
    //TODO : A compléter
    return null;
  }

  public Color[][] getColors() {
    return this.terrain;
  }

  public int getLongueur() {
    return this.longueur;
  }

  public int getHauteur() {
    return this.hauteur;
  }

}
