package tp3.exo3.correction.examens;

public class CharSequence {

  public static void main(String[] args) {
    int nb = 0;
    char previous = ' ';
    for(int i = 0 ; i < 50 ; i++) {
      char val = auSort();
      // Si le précédent est identique, on incrémente le nombre
      if(previous == val) {
        nb++;
      } else if(nb == 0){ // Les deux ne sont pas identiques, on doit afficher le caractère
        System.out.print(val);
      } else {
        // Pas identiques, on affiche avec le nombre de caractères affichés
        System.out.print(val + "" + nb);
        nb = 0;
      }
      previous = val;
    }
  }
  
  public static char auSort() {
    return (char) (65 + Math.random() * 3);
  }

}
