package tp1.exo1.math;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import tp1.exo1.math.Maths;


public class MathsTest {

  @Test
  public final void testPow() {
    assertEquals(Maths.pow(3, 4), 81);
    assertEquals(Maths.pow(2, 6), 64);
    assertEquals(Maths.pow(-2, 6), 64);
    assertEquals(Maths.pow(-2, 5), -32);
    assertEquals(Maths.pow(3, 1), 3);
    assertEquals(Maths.pow(10, 0), 1);
  }
  
  @Test
  public final void testPowIteratif() {
    assertEquals(Maths.powIteratif(3, 4), 81);
    assertEquals(Maths.powIteratif(2, 6), 64);
    assertEquals(Maths.powIteratif(-2, 6), 64);
    assertEquals(Maths.powIteratif(-2, 5), -32);
    assertEquals(Maths.powIteratif(3, 1), 3);
    assertEquals(Maths.powIteratif(10, 0), 1);
  }
  
  
  @Test
  public final void testFact() {
    assertEquals(Maths.fact(3), 6);
    assertEquals(Maths.fact(1), 1);
    assertEquals(Maths.fact(0), 1);
    assertEquals(Maths.fact(5), 120);
  }

  @Test
  public final void testFactIteratif() {
    assertEquals(Maths.factIteratif(3), 6);
    assertEquals(Maths.factIteratif(1), 1);
    assertEquals(Maths.factIteratif(0), 1);
    assertEquals(Maths.factIteratif(5), 120);
  }

  @Test
  public final void testAbs() {
    assertEquals(Maths.abs(5), 5);
    assertEquals(Maths.abs(0), 0);
    assertEquals(Maths.abs(-5), 5);
  }

  @Test
  public final void testMin() {
    assertEquals(Maths.min(5, 3), 3);
    assertEquals(Maths.min(3, 5), 3);
    assertEquals(Maths.min(5, -3), -3);
  }

  @Test
  public final void testMax() {
    assertEquals(Maths.max(5, 3), 5);
    assertEquals(Maths.max(3, 5), 5);
    assertEquals(Maths.max(5, -3), 5);
  }

}
