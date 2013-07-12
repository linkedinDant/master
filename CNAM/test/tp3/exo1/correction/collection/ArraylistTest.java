package tp3.exo1.correction.collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import tp3.exo1.collection.Arraylist;

public class ArraylistTest {

  @Test
  public final void testIsEmpty() {
    Arraylist l = new Arraylist();
    assertTrue(l.isEmpty());
    l.add(5);
    assertFalse(l.isEmpty());
  }

  @Test
  public final void testSize() {
    Arraylist l = new Arraylist();
    assertEquals(l.size(), 0);
    l.add(5).add(3).add(7);
    assertEquals(l.size(), 3);
  }

  @Test
  public final void testAddObject() {
    Arraylist l = new Arraylist();
    l.add(5).add(3).add(7);
    assertEquals(l.get(0), 5);
    assertEquals(l.get(1), 3);
    assertEquals(l.get(2), 7);
  }

  @Test
  public final void testAddIntObject() {
    Arraylist l = new Arraylist();
    l.add(0, 5).add(0, 3).add(0, 7);
    assertEquals(l.get(0), 7);
    assertEquals(l.get(1), 3);
    assertEquals(l.get(2), 5);
  }

  @Test
  public final void testClear() {
    Arraylist l = new Arraylist();
    l.add(0, 5).add(0, 3).add(0, 7);
    assertEquals(l.size(), 3);
    l.clear();
    assertEquals(l.size(), 0);
  }

  @Test
  public final void testRemoveInt() {
    Arraylist l = new Arraylist();
    l.add(0, 5).add(0, 3).add(0, 7);
    Object ob = l.remove(0);
    assertEquals(l.size(), 2);
    assertEquals(ob, 7);
  }

  @Test
  public final void testRemoveObject() {
    Arraylist l = new Arraylist();
    l.add(0, 5).add(0, 3).add(0, 7);
    boolean res = l.remove(new Integer(7));
    assertEquals(l.size(), 2);
    assertTrue(res);
  }

  @Test
  public final void testSet() {
    Arraylist l = new Arraylist();
    l.add(0, 5).add(0, 3).add(0, 7);
    l.set(0, 18);
    assertEquals(l.size(), 3);
    assertEquals(l.get(0), 18);
  }

  @Test
  public final void testAddAll() {
    Arraylist l = new Arraylist();
    l.add(0, 5).add(0, 3).add(0, 7);
    Arraylist k = new Arraylist();
    k.add(0, 5).add(0, 3).add(0, 7);
    l.addAll(k);
    assertEquals(l.size(), 6);
    assertEquals(l.get(5), 5);
  }

  @Test
  public final void testIndexOf() {
    Arraylist l = new Arraylist();
    l.add(5).add(3).add(7).add(5);
    int res = l.indexOf(5);
    assertEquals(res, 0);
    res = l.indexOf(156);
    assertEquals(res, -1);
  }

  @Test
  public final void testLastIndexOf() {
    Arraylist l = new Arraylist();
    l.add(5).add(3).add(7).add(5);
    int res = l.lastIndexOf(5);
    assertEquals(res, 3);
    res = l.lastIndexOf(156);
    assertEquals(res, -1);
  }
  

  @Test
  public final void testToArray() {
    Arraylist l = new Arraylist();
    l.add(5).add(3).add(7).add(5);
    Object[] array = l.toArray();
    assertEquals(l, new Arraylist(array));
  }
  

  @Test
  public final void testSubList() {
    Arraylist l = new Arraylist();
    l.add(5).add(3).add(7).add(5);
    Arraylist subList = l.subList(1,  3);
    assertEquals(subList.size(), 2);
    assertEquals(subList, new Arraylist(new Object[]{3, 7}));
  }
}
