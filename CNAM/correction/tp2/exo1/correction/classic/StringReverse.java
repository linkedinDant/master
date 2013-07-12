package tp2.exo1.correction.classic;

public class StringReverse {

  public static void main(String[] args) {
    char[] value = "StringReverse".toCharArray();
    reverse(value);
    System.out.println(value);
    // Doit afficher : esreveRgnirtS
  }
  
  static public void reverse(char[] value) {
    for(int i = 0 ; i < value.length / 2 ; i++) {
      int endPos = value.length - i - 1;
      char tmp = value[i];
      value[i] = value[endPos];
      value[endPos] = tmp;
    }
  }

}
