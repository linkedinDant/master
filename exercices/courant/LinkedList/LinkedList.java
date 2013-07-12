public class LinkedList {

  private Element head;
  
  public LinkedList(Element head) {
    this.head = head;
  }
  
  public boolean isEmpty() {
    return head == null;
  }
  
  public void add(int val) {
    if(isEmpty()) {
      head = new Element(val);
      return;
    }
    Element p = head;
    while(p.getNext() != null) {
      p = p.getNext();
    }
    p.setNext(new Element(val));
  }
  
  public void addAll(int[] values) {
    int start = 0;
    if(isEmpty()) {
      head = new Element(values[0]);
      start++;
    }
    Element p = head;
    while(p.getNext() != null) {
      p = p.getNext();
    }
    for(int i = start ; i < values.length ; i++) {
      p.setNext(new Element(values[i]));
      p = p.getNext();
    }
  }
  
  public Element remove(int val) {
    if(isEmpty()) {
      return null;
    }
    Element p = head;
    Element next = head.getNext();
    if(p.getValue() == val) { 
      // Si on veut supprimer la tête 
      head = next;
      p.setNext(null);
      return p;
    }
    while(next != null) {
      if(next.getValue() == val) {
	p.setNext(next.getNext());
	next.setNext(null);
	return next;
      }
      // On itère
      p = next;
      next = next.getNext();
    }
    // Le nombre n'existe pas
    return null; 
  }
  
  public int size() {
    int size = 0;
    Element p = head;
    while(p != null) {
      size++;
      p = p.getNext();
    }
    return size;
  }
  
  public String toString() {
    StringBuffer buffer = new StringBuffer();
    Element p = head;
    while(p != null) {
      buffer.append(p);
      p = p.getNext();
    }
    return buffer.toString();
  }
  
  public static void main(String[] args) {
    LinkedList l = new LinkedList(new Element(1));
    l.add(2);
    l.add(3);
    l.add(4);
    l.addAll(new int[] {5, 6, 7});
    System.out.println(l);
    System.out.println(l.size());
    l.remove(5);
    l.remove(2);
    System.out.println(l);
  }

}