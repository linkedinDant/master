package tp2.exo1.classic;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;


public class StringReverseTest {

  @Test
  public void testReverse() {
    char[] value = "StringReverse".toCharArray();
    StringReverse.reverse(value);
    assertArrayEquals("esreveRgnirtS".toCharArray(), value);
  }
  
}
