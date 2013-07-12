public class Element {

  private Element next;
  private int value;
  
  public Element(int value) {
    this.value = value;
  }
  
  public Element (int value, Element next) {
    this.value = value;
    this.next = next;
  }
  
  public int getValue() {
    return value;
  }
  
  public Element getNext() {
    return next;
  }
  
  public void setNext(Element next) {
    this.next = next;
  }
  
  public boolean equals(Object ob) {
    if(ob instanceof Element) {
      Element el = (Element) ob;
      return el.value == value && next == el.next;
    }
    return false;
  }

  public String toString() {
    return value + " -> ";
  }
  
}