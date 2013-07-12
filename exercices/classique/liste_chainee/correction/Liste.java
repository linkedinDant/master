public class Liste {

  private Element head;
  private Element tail;
  
  public Liste(int value) {
    head = new Element(value);
    tail = head;
  }
  
  public Element getHead() {
    return head;
  }
  
  public Element getTail() {
    return tail;
  }
  
  public void addLast(int value) {
    Element el = new Element(value);
    el.setPrevious(tail);
    tail.setNext(el);
    head.setPrevious(el);
    tail = el;
  }
  
  public void addFirst(int value) {
    Element el = new Element(value);
    head.setPrevious(el);
    el.setNext(head);
    tail.setNext(el);
    head = el;
  }
  
  public Element find(int value) {
    if(head.getValue() == value) {
      return head;
    }
    if(tail.getValue() == value) {
      return tail;
    }
    // On peut ne pas tester la tête, on l'a fait précédemment
    Element p = head.getNext();
    while(p != tail) {
      if(p.getValue() == value) {
	return p;
      }
      p = p.getNext();
    }
    
    return null;
  }
  
  public Element removeFirst() {
    if(head == tail) {
      // On ne peut pas supprimer le premier élément
      return null;
    }
    Element next = head.getNext();
    next.setPrevious(tail);
    tail.setNext(next);
    Element oldHead = head;
    head = next;
    return oldHead;
  }
  
  public Element removeLast() {
    if(head == tail) {
      // On ne peut pas supprimer le premier élément
      return null;
    }
    Element p = tail.getPrevious();
    p.setNext(head);
    head.setPrevious(p);
    Element oldTail = tail;
    tail = p;
    return oldTail;
  }

  public boolean contains(int value) {
    return find(value) != null;
  }
  
  public int size() {
    if(head == tail) {
      return 1;
    }
    Element p = head;
    int cpt = 0;
    while(p != tail) {
      ++cpt;
      p = p.getNext();
    }
    // Il faut compter la queue
    ++cpt;
    return cpt;
  }
  
  public String toString() {
    if(head == tail) {
      return head.toString();
    }
    Element p = head;
    StringBuilder b = new StringBuilder();
    while(p != tail) {
      b.append(p).append(" -> ");
      p = p.getNext();
    }
    b.append(tail);
    return b.toString();
  }
  
  public static void main(String[] args) {
    Liste l = new Liste(3);
    l.addFirst(2);    
    l.addFirst(1);    
    if(l.size() != 3) {
      System.out.println("Erreur lors de l'ajout en tête. Il devrait y avoir 3 éléments dans la liste : " + l);
      return;
    }
    l.addLast(4);
    l.addLast(5);
    if(l.size() != 5) {
      System.out.println("Erreur lors de l'ajout en fin. Il devrait y avoir 5 éléments dans la liste : " + l);
      return;
    }
    Element res = l.find(3);
    if(res == null) {
      System.out.println("Erreur dans la méthode find. La liste : " + l + " doit contenir l'élément 3, mais la méthode ne le trouve pas.");
      return;
    }
    res = l.find(10);
    if(res != null) {
      System.out.println("Erreur dans la méthode find. La liste : " + l + " ne doit pas contenir l'élément 10, pourtant la méthode find trouve un élément.");
      return;
    }    
    boolean contains = l.contains(3);
    if(contains == false) {
      System.out.println("Erreur dans la méthode contains. La liste : " + l + " doit contenir l'élément 3, mais la méthode ne le trouve pas.");
      return;
    }
    contains = l.contains(10);
    if(contains) {
      System.out.println("Erreur dans la méthode contains. La liste : " + l + " ne doit pas contenir l'élément 10, pourtant la méthode contains trouve un élément.");
      return;
    }
    l.removeFirst();
    l.removeFirst();
    if(l.size() != 3) {
      System.out.println("Erreur lors de la suppression au début. Il devrait y avoir 3 éléments dans la liste : " + l);
      return;
    }
    l.removeLast();
    l.removeLast();
    if(l.size() != 1) {
      System.out.println("Erreur lors de la suppression en fin. Il devrait y avoir 1 élément dans la liste : " + l);
      return;
    }
    System.out.println("La liste chainée est valide !");
  }  
}