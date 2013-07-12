package tp2.exo3.correction.proc;


public class Element {

  private Processus processus;
  private Element next;
  private Element previous;
  
  public Element(Processus p) {
    this.processus = p;
  }

  public Processus getProcessus() {
    return this.processus;
  }

  public Element getNext() {
    return this.next;
  }

  public void setNext(Element next) {
    this.next = next;
  }

  public Element getPrevious() {
    return this.previous;
  }

  public void setPrevious(Element previous) {
    this.previous = previous;
  }
  
  

}
