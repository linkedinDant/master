package tp1.exo3.correction.image;

import java.awt.Color;

import tp1.exo3.file.TrackReader;


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
   *  - On parcourt "hauteur fois" le tableau en partant de 2 jusqu'à hauteur + 2 (car les 2 premières lignes contiennent respectivement la longueur et la hauteur). 
   *  Les fichiers ont 770 lignes, les 2 premières contiennent les dimensions, les 768 autres l'image
   *    - On parcourt "longueur fois" le tableau
   *        - On récupère le caractère de la ligne. Récupérer le caractère "i" d'un String se fait avec la méthode charAt de ce-dernier. 
   *          Exemple : char c = "Salut".charAt(2) renverra "l". La description de la méthode est ici -> http://docs.oracle.com/javase/7/docs/api/java/lang/String.html#charAt(int)
   *        - On transforme le caractère récupéré en Color grâce à la méthode conversion qui est à réaliser plus bas.
   *        - On insère la couleur dans la matrice AU BON ENDROIT (attention il y a un piège avec le bon endroit)
   *       
   */
  public void read(String filename) {
    String[] read = new TrackReader().read(filename); // On récupère le contenu du fichier. 
    longueur = Integer.parseInt(read[0]); // On initialise la longueur
    hauteur = Integer.parseInt(read[1]); // On initialise la hauteur
    terrain = new Color[longueur][hauteur]; // On crée la matrice avec le format spécifié dans la documentation ci-dessus
    for (int i = 2; i < hauteur + 2; i++) { // On part de 2 et on s'arrête à hauteur + 2, comme dit dans la documentation. Il y a 
      String line = read[i]; // On récupère la ligne
      for (int j = 0; j < longueur; j++) { // On parcourt tout les caractères 
        char pixel = line.charAt(j); // On récupère le caractère 
        // On insère la couleur. Le tableau est de la forme [longueur][hauteur], donc on doit insérer [j][i - 2] car j correspond à la longueur et i à la hauteur. Vu qu'on a ajouté
        // 2 dans le parcours de la boucle pour ignorer les 2 premières lignes, on enlève 2 lors de l'ajout dans la matrice afin de pas tout décaler. Par exemple, pour la premier parcours
        // i = 2, or on veut insérer la couleur à la position 0 de la matrice (comme on le fait normalement) donc on retranche 2.
        terrain[j][i - 2] = conversion(pixel);
      }
    }
  }

  private Color conversion(char carac) {
    // On cherche le caractère spécifié dans le tableau "conversion"
    for (int i = 0; i < conversion.length; i++) {
      // On vérifie que c'est le bon caractère
      if (conversion[i] == carac) {
        // Si c'est le bon caractère, on renvoie la couleur associée. Celle-ci a le même indice.
        return convColor[i];
      }
    }
    // On ne doit JAMAIS arriver la, car les fichiers ne contiennent pas des caractères non gérés.
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
