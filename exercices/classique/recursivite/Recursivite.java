public class Recursivite {

  public static int fact(int n) {
    return 0;
  }

  public static int min(int[] tab, int min, int position) {
    return 0;
  }

  public static void main(String[] args) {
    int tab[] = new int[]{5, 3, 5, 10, 6, 23,  2, 78};
    if(24 != fact(4)) {
      System.out.println("La fonction fact devrait renvoyer 24 et elle renvoie " + fact(4)+". Elle est erronée." );return;
    }
    if(2 != min(tab, 100, 0)) {
      System.out.println("Le minimum dans le tableau " + java.util.Arrays.toString(tab) + " est 2 or la fonction min renvoie : " + min(tab, 100, 0) + ". Elle est erronée.");return;
    }
    System.out.println("Les fonctions sont valides !");
  }

}
