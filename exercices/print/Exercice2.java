public class Exercice2 {

  public static void main(String[] args) {
    int p = 1;
    boolean b = false;
    for(int i = 0 ; i < 6 ; p++) {
      b = (p % 2) == 1;
      if(b) {
        System.out.println("abc");
        b = false;
      } else {
        System.out.println("def");
        p += 1;
      }
      i++;
    }
  }

}