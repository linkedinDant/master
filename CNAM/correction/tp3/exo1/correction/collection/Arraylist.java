package tp3.exo1.correction.collection;

import java.util.Arrays;

public class Arraylist implements IList {

  private Object[] elementData;
  private int pointer;

  public Arraylist() {
    this(16);
  }

  public Arraylist(int size) {
    elementData = new Object[size];
    pointer = 0;
  }

  public Arraylist(Object[] ob) {
    elementData = Arrays.copyOf(ob, ob.length);
    pointer = ob.length;
  }

  @Override
  public boolean isEmpty() {
    return pointer == 0;
  }

  @Override
  public int size() {
    return pointer;
  }

  @Override
  public Arraylist add(Object ob) {
    growUp();
    elementData[pointer] = ob;
    pointer++;
    return this;
  }

  @Override
  public Arraylist add(int pos, Object ob) {
    growUp();
    for (int i = pointer; i > pos; i--) {
      elementData[i] = elementData[i - 1];
    }
    elementData[pos] = ob;
    pointer++;
    return this;
  }

  @Override
  public Object remove(int pos) {
    Object old = elementData[pos];
    elementData[pos] = null;
    for (int i = pos + 1; i < pointer; i++) {
      elementData[i - 1] = elementData[i];
    }
    pointer--;
    elementData[pointer] = null;
    return old;
  }

  @Override
  public boolean remove(Object ob) {
    int pos = indexOf(ob);
    if (pos == -1)
      return false;

    return null != remove(pos);
  }

  @Override
  public Arraylist set(int pos, Object ob) {
    elementData[pos] = ob;
    return this;
  }

  @Override
  public Arraylist addAll(IList a) {
    for (int i = 0; i < a.size(); i++) {
      add(a.get(i));
    }
    return this;
  }

  @Override
  public Object[] toArray() {
    return Arrays.copyOf(elementData, elementData.length);
  }

  @Override
  public Arraylist subList(int from, int end) {
    Object[] ob = new Object[end - from];
    int pos = 0;
    for (int i = from; i < end; i++) {
      ob[pos] = elementData[i];
      ++pos;
    }
    return new Arraylist(ob);
  }

  @Override
  public int indexOf(Object ob) {
    for (int i = 0; i < pointer; i++) {
      if (elementData[i].equals(ob)) {
        return i;
      }
    }
    return -1;
  }

  @Override
  public int lastIndexOf(Object ob) {
    for (int i = pointer - 1; i >= 0; i--) {
      if (elementData[i].equals(ob)) {
        return i;
      }
    }
    return -1;
  }

  @Override
  public boolean contains(Object ob) {
    return -1 != indexOf(ob);
  }

  @Override
  public Object get(int pos) {
    return elementData[pos];
  }

  @Override
  public void clear() {
    for (int i = 0; i < pointer; i++) {
      elementData[i] = null;
    }
    pointer = 0;
  }

  @Override
  public boolean equals(Object ob) {
    if (ob instanceof Arraylist) {
      Arraylist a = (Arraylist) ob;
      return Arrays.deepEquals(elementData, a.elementData);
    }
    return false;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for (int i = 0; i < pointer - 1; i++) {
      sb.append(elementData[i]).append(", ");
    }
    if (pointer > 0)
      sb.append(elementData[pointer - 1]);
    sb.append("]");
    return sb.toString();
  }

  private void growUp() {
    if (pointer >= elementData.length) {
      elementData = Arrays.copyOf(elementData, elementData.length * 2);
    }
  }
}
