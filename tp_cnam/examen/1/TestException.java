public class TestException {

  static String plusZ(String x) throws Exp {
    if(x == null) {
      throw new Exp();
    } else {
      return "Z" + x;
    }
  }
  
  public static void main(String[] args) {
    String s;
    String[] t = new String[10];
    t[0] = "A0";
    t[1] = "A1";
    t[2] = "A2";
    t[9] = "A9";
    System.out.println("1ERE BOUCLE");
    try {
      for(int i = 0 ; i < t.length ; i++) {
	s = t[i];
	System.out.println(plusZ(t[i]));
      }
    } catch(Exp e1) {
	System.out.println("Exception 1");
    }
    System.out.println("2EME BOUCLE");
      for(int i = 0 ; i < t.length ; i++) {
	s = t[i];
	try {	  
	  System.out.println(plusZ(t[i]));
	} catch(Exp e2) {
	  System.out.println("Exception 2");
	}
      }
  }

}
