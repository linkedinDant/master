package org.exercice2;

import java.util.ArrayList;
import java.util.List;

import oracle.kv.KVStore;
import oracle.kv.Key;
import oracle.kv.Value;

import org.util.AbstractExercice;
import org.util.Exercice;

public class M2 extends AbstractExercice {

  private List<Key> keys;

  public M2(KVStore store) {
    super(store);
  }

  @Override
  public Exercice populate() {
    keys = new ArrayList<>(10);
    for (int i = 1; i <= 10; i++) {
      keys.add(Key.createKey("C1", "P" + i));
    }
    if (isPopulate()) {
      for (int i = 0; i < 10; i++) {
        store.put(keys.get(i), Value.createValue("0".getBytes()));
      }
    }
    return super.populate();
  }

  @Override
  public Exercice go() throws Exception {
    int max = 0;
    for (int i = 0; i < 1000; i++) {
      max = max(max);
      new Transaction(store).commit(max, keys);
    }
    for (int i = 0; i < 5; i++) {
      System.out.println(new String(store.get(keys.get(i)).getValue().getValue()));
    }
    return this;
  }

  private int max(int max) {
    for (int i = 0; i < 5; i++) {
      int tmpMax = Integer.parseInt(new String(store.get(keys.get(0)).getValue().getValue()));
      if (tmpMax > max)
        max = tmpMax;
    }
    return max + 1;
  }

}
