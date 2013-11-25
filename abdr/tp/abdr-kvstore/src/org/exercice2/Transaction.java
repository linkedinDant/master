package org.exercice2;

import java.util.ArrayList;
import java.util.List;

import oracle.kv.DurabilityException;
import oracle.kv.FaultException;
import oracle.kv.KVStore;
import oracle.kv.Key;
import oracle.kv.Operation;
import oracle.kv.OperationExecutionException;
import oracle.kv.OperationFactory;
import oracle.kv.ReturnValueVersion.Choice;
import oracle.kv.Value;
import oracle.kv.ValueVersion;
import oracle.kv.Version;

public class Transaction {

  private final KVStore store;
  private final int essai;

  public Transaction(KVStore store) {
    this(store, 1);
  }

  public Transaction(KVStore store, int essai) {
    this.store = store;
    this.essai = essai;
  }

  public void commit(int max, List<Key> keyList) throws DurabilityException, OperationExecutionException, FaultException {
    commit(max, keyList, 0);
  }

  private void commit(int max, List<Key> keyList, int nb) throws OperationExecutionException {
    OperationFactory factory = store.getOperationFactory();
    List<Operation> operations = new ArrayList<>(5);
    for (int i = 0; i < 5; i++) {
      ValueVersion valueVersion = store.get(keyList.get(i));
      Version lastVersion = valueVersion.getVersion();
      Operation operation = factory.createPutIfVersion(keyList.get(i), maxValue(max, valueVersion), lastVersion, Choice.NONE, true);
      operations.add(operation);
    }
    try {
      store.execute(operations);
    } catch (OperationExecutionException e) {
      if (nb < essai) {
        commit(max, keyList, ++nb);
      } else {
        throw e;
      }
    }
  }

  private Value maxValue(int max, ValueVersion val) {
    int subMax = Integer.parseInt(new String(val.getValue().getValue()));
    if (max > subMax) {
      return Value.createValue(Integer.toString(max).getBytes());
    }
    return val.getValue();
  }

}
