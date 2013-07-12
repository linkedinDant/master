public class Element {

  private int value;
  private Element next;
  private Element previous;
  
  public Element(int value) {
    this.value = value;
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
  
  public Element getPrevious() {
    return previous;
  }
  
  public void setPrevious(Element previous) {
    this.previous = previous;
  }
  
  public String toString() {
    return value + "";
  }
  
  public boolean equals(Object ob) {
    if(ob instanceof Element) {
      Element e = (Element) ob;
      return e.value == value && next == e.next && previous == e.previous;
    }
    return false;
  }

}