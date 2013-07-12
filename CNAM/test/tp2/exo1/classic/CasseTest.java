package tp2.exo1.classic;

import static org.junit.Assert.*;

import org.junit.Test;
public class CasseTest {

  @Test
  public void testCountUpperCase() {
    assertEquals(3, Casse.countUppercase("SaLuT".toCharArray()));
    assertEquals(0, Casse.countUppercase("salut".toCharArray()));
    assertEquals(11, Casse.countUppercase("bonjoursava".toUpperCase().toCharArray()));
  }
  

  @Test
  public void testCountLowerCase() {
    assertEquals(2, Casse.countLowercase("SaLuT".toCharArray()));
    assertEquals(5, Casse.countLowercase("salut".toCharArray()));
    assertEquals(11, Casse.countLowercase("bonjoursava".toCharArray()));
  }
  
  
}
