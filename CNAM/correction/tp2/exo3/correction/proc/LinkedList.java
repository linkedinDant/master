package tp2.exo3.correction.proc;


public class LinkedList {

  private Element head;

  public LinkedList() {
  }

  public boolean isEmpty() {
    return head == null;
  }

  public Processus get(int pos) {
    if (isEmpty())
      return null;

    if (pos == 0)
      return head.getProcessus();

    Element p = head;
    while (p != head.getPrevious()) {
      if (pos == 0) {
        return p.getProcessus();
      }
      // On décrémente la position pour trouver la bonne.
      // Si la position est de 5, alors on itère 5 fois, en decrémentant 5 fois. Dès qu'on arrive à 0, on a trouvé le bon.
      pos--; 
      p = p.getNext();
    }
    // Si pos vaut 0, alors on voulait le dernier élément (la queue). En effet, on sort du while dès qu'on atteint la queue, mais
    // peut être que c'était le processus désiré.
    if (pos == 0) {
      return p.getProcessus();
    }
    // On a dépassé les bornes, donc on a fait une boucle
    return null;
  }

  public Processus search(long pid) {
    if (isEmpty())
      return null;

    Element p = head;
    while (p != head.getPrevious()) {
      // Si le processus p a le pid recherché, on le renvoie, sinon on passe au suivant
      if (p.getProcessus().getPid() == pid) {
        return p.getProcessus();
      }
      p = p.getNext();
    }
    // Si on arrive ici, on teste la queue
    if (p.getProcessus().getPid() == pid) {
      return p.getProcessus();
    }
    return null;
  }

  public int size() {
    if (isEmpty())
      return 0;
    Element p = head;
    int size = 0;
    while (p != head.getPrevious()) {
      size++;
      p = p.getNext();
    }
    // On est sorti du while car p == queue. Donc on n'a pas incrémenté pour compter la queue
    // On incrémente maintenant.
    size++;
    return size;
  }

  public void addLast(Processus processus) {
    Element p = new Element(processus);
    if (head == null) {
      head = p;
      head.setPrevious(head);
      head.setNext(head);
      return;
    }
    Element last = head.getPrevious();
    last.setNext(p);
    head.setPrevious(p);
    p.setNext(head);
    p.setPrevious(last);
  }

  public void addFirst(Processus processus) {
    Element p = new Element(processus);
    if (head == null) {
      head = p;
      head.setPrevious(head);
      head.setNext(head);
      return;
    }
    p.setNext(head);
    p.setPrevious(head.getPrevious());
    head.getPrevious().setNext(p);
    head.setPrevious(p);
    head = p;
  }

  public Processus getLast() {
    if (head == null)
      return null;
    return head.getPrevious().getProcessus();
  }

  public Processus getFirst() {
    if (head == null)
      return null;
    return head.getProcessus();
  }

  public Processus removeFirst() {
    if (head == null)
      return null;

    Element p = head;
    head.getPrevious().setNext(head.getNext());
    head.getNext().setPrevious(head.getPrevious());
    head = head.getNext();
    return p.getProcessus();
  }

  public Processus removeLast() {
    if (head == null)
      return null;

    Element p = head.getPrevious();
    p.getPrevious().setNext(head);
    head.setPrevious(p.getPrevious());
    return p.getProcessus();
  }

  public boolean remove(Processus processus) {
    if (head == null)
      return false;
    
    Element p = head;
    while(p != head.getPrevious()) {
      if(p.getProcessus().equals(processus)) {
        p.getPrevious().setNext(p.getNext());
        p.getNext().setPrevious(p.getPrevious());
        return true;
      }
      p = p.getNext();
    }
    if(p.getProcessus().equals(processus)) {
      p.getPrevious().setNext(p.getNext());
      p.getNext().setPrevious(p.getPrevious());
      return true;
    }
    return false;
  }

  @Override
  public String toString() {
    if(isEmpty()) return null;
    
    StringBuilder b = new StringBuilder();
    Element p = head;
    b.append("[");
    while(p != head.getPrevious()) {
      b.append(p.getProcessus()).append(", ");
      p = p.getNext();
    }
    b.append(p.getProcessus()).append("]");
    return b.toString();
  }
  
}
