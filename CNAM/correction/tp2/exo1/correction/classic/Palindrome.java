package tp2.exo1.correction.classic;

public class Palindrome {

  public static void main(String[] args) {
    char[] palin = "kayakkayak".toCharArray();
    char[] notPalin = "salut".toCharArray();
    System.out.println(isPalindrome(palin)); // Doit renvoyer vrai
    System.out.println(isPalindrome(notPalin)); // Doit renvoyer faux
  }
  
  static public boolean isPalindrome(char[] palin) {
    for(int i = 0 ; i < palin.length / 2 ; i++) {
      int endPos = palin.length - i - 1;
      if(palin[i] != palin[endPos]) {
        return false;
      }
    }
    return true;
  }

}
