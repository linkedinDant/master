package tp2.exo1.classic;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class PalindromeTest {

  @Test
  public void testIsPalindrome() {
    assertTrue(Palindrome.isPalindrome("kayakkayak".toCharArray()));
    assertFalse(Palindrome.isPalindrome("salut".toCharArray()));
  }
  
}
