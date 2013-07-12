import java.util.Arrays;

public class Exercice3 {

  static void eval(int[] tab, int from, int end) {
    for(;from < end ; from++) {
      int tmp = tab[from];
      tab[from] = tab[from + 1];
      tab[from + 1] = tab[from];
    }
  }

  static int f(int[] tab) {
    int p = tab[0];
    for(int i = 1 ; i < tab.length ; i++) {
      if(p < tab[i]) {
        p = tab[i];
      }
    }
    if(p % 2 == 0) {
      tab[tab.length - 1] = p * 2;
      tab[0] = tab.length - 1;
    }
    return p + 3;
  }
  
  static void r(String k, int p) {
    k += p;
    p++;
  }
  
  public static void main(String[] args) {
    String ch = "123";
    int[] tab = {3, 2, 5, 6, 1};
    eval(tab, 0, tab.length - 1);
    System.out.println(Arrays.toString(tab));
    int p = f(tab);
    p++;
    r(ch, p);
    System.out.println(Arrays.toString(tab));
    System.out.println(p);
    System.out.println(ch);
  }

}