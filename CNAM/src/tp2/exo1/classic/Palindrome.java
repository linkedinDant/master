package tp2.exo1.classic;

public class Palindrome {

  public static void main(String[] args) {
    char[] palin = "kayakkayak".toCharArray();
    char[] notPalin = "salut".toCharArray();
    System.out.println(isPalindrome(palin)); // Doit renvoyer vrai
    System.out.println(isPalindrome(notPalin)); // Doit renvoyer faux
  }
  
  static public boolean isPalindrome(char[] palin) {
    return false;
  }

}
