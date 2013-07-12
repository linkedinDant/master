package tp1.exo2.correction.store;

public class AppStore {

  private Application[] store;
  private int position;

  public AppStore() {
    store = new Application[200];
    position = 0;
  }
  
  public int size() {
    return position;
  }

  public boolean isFull() {
    return position >= store.length;
  }

  public boolean addApplication(Application app) {
    if (isFull())
      return false;
    store[position] = app;
    position++;
    return true;
  }

  public boolean removeApplication(Application app) {
    int pos = indexOfApplication(app);
    if (pos == -1)
      return false;

    store[pos] = null;
    position--;
    for (int i = pos + 1; i < store.length; i++) {
      store[i - 1] = store[i];
    }
    return true;
  }

  public int indexOfApplication(Application app) {
    for (int i = 0; i < position; i++) {
      if (store[i].equals(app)) {
        return i;
      }
    }
    return -1;
  }

  public Application find(String name) {
    for (int i = 0; i < position; i++) {
      if (store[i].getName().equals(name)) {
        return store[i];
      }
    }
    return null;
  }

  public Application find(int id) {
    for (int i = 0; i < position; i++) {
      if (store[i].getId() == id) {
        return store[i];
      }
    }
    return null;
  }
}
