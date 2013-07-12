package tp2.exo2.correction.ring;

public class Ring {

  private int id;
  private Ring previous, next;

  static private int cpt = 0;

  public Ring() {
    id = ++cpt;
  }

  public Ring(Ring before, Ring after) {
    this();
    this.previous = before;
    this.next = after;
  }

  public int getId() {
    return id;
  }
  
  public Ring getPrevious() {
    return this.previous;
  }

  public void setPrevious(Ring previous) {
    this.previous = previous;
  }

  public Ring getNext() {
    return this.next;
  }

  public void setNext(Ring next) {
    this.next = next;
  }
  
  public void sendMessage(String message, boolean toNext) {
    send(this, message, toNext);
  }
  
  public void receiveMessage(Ring sender, String message, boolean toNext) {
    // Si c'est lui-même l'expéditeur, on a fait le tour
    if(sender != this) {
      System.out.println(toString() + " : " + message);
      send(sender, message, toNext);
    } 
  }
  
  private void send(Ring sender, String message, boolean toNext) {
    if(toNext) {
      next.receiveMessage(sender, message, toNext);
    } else {
      previous.receiveMessage(sender, message, toNext);
    }
  }

  @Override
  public boolean equals(Object ob) {
    if (ob instanceof Ring) {
      Ring b = (Ring) ob;
      return b.id == id;
    }
    return false;
  }

  @Override
  public String toString() {
    return id + "";
  }
}
