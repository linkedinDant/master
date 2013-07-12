package tp3.exo1.collection;

import java.util.Arrays;

public class Arraylist implements IList {

  private Object[] elementData;
  private int pointer;

  public Arraylist() {
    // Initialise le tableau à 16 éléments
  }

  public Arraylist(int size) {
    // Initialise le tableau avec size éléments
  }

  public Arraylist(Object[] ob) {
    // Copie le tableau spécifié dans elementData et met à jour la variable pointer
    // Utiliser la méthode Arrays.copyOf
  }

  @Override
  public boolean isEmpty() {
    return true;
  }

  @Override
  public int size() {
    return -1;
  }

  @Override
  public Arraylist add(Object ob) {
    return null;
  }

  @Override
  public Object get(int pos) {
    return null;
  }

  @Override
  public Arraylist add(int pos, Object ob) {
    return null;
  }

  @Override
  public Object remove(int pos) {
    return null;
  }

  @Override
  public boolean remove(Object ob) {
    return false;
  }

  @Override
  public int indexOf(Object ob) {
    return -1;
  }

  @Override
  public int lastIndexOf(Object ob) {
    return -1;
  }

  @Override
  public boolean contains(Object ob) {
    return false;
  }

  @Override
  public void clear() {
  }

  @Override
  public Arraylist set(int pos, Object ob) {
    return null;
  }

  @Override
  public Arraylist addAll(IList a) {
    return null;
  }

  @Override
  public Object[] toArray() {
    return null;
  }

  @Override
  public Arraylist subList(int from, int end) {
    return null;
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
