public class Liste {

  private Element head;
  private Element tail;
  
  public Liste(int value) {
    
  }
  
  public Element getHead() {
    return null;
  }
  
  public Element getTail() {
    return null;
  }
  
  public void addLast(int value) {
    
  }
  
  public void addFirst(int value) {
    
  }
  
  public Element find(int value) {
    return null;
  }
  
  public Element removeFirst() {
    return null;
  }
  
  public Element removeLast() {
    return null;
  }

  public boolean contains(int value) {
    return false;
  }
  
  public int size() {
    return -1;
  }
  
  public String toString() {
    return "";
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