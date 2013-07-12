public class Exercice1 {

  private int value;
  
  public Exercice1(int val) {
    value = val;
  }
  
  public Exercice1 f(Exercice1 exo) {
    int n = exo.value * 3;
    value += (n - exo.value);
    return new Exercice1(value);
  }
  
  public static int compute(Exercice1 p, Exercice1 r, int k) {
    int n = (p.value % k) + r.value;
    p.value = n;
    r.value = n / 2;
    return (r.value + n);
  }

  public String toString() {
    return "" + value;
  }
  
  public static void main(String[] args) {
    int k = 3;
    Exercice1 a = new Exercice1(k);
    Exercice1 b = a.f(new Exercice1(5));
    int p = Exercice1.compute(a, b, 3);
    System.out.println(a);
    System.out.println(b);
    System.out.println(p);
  }

} 
