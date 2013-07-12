import java.util.*;

public class Node {

  private List<Node> voisins;
  private String name;
  
  public Node(String name) {
    this.name = name;
    voisins = new ArrayList<Node>();
  }
  
  public String getName() {
    return name;
  }
  
  public int size() {
    return voisins.size();
  }
  
  public boolean isEmpty() {
    return voisins.isEmpty();
  }
  
  public Node getNode(int i) {
    return voisins.get(i);
  }
  
  public boolean addNode(Node n) {
    return voisins.add(n);
  }
  
  public boolean removeNode(Node n) {
    return voisins.remove(n);
  }
  
  public Node addNode(String name) {
    Node n = new Node(name);
    if(addNode(n)) {
      return n;
    } 
    return null;
  }
  
  public Node getNode(String name) {
    for(int i = 0 ; i < size() ; i++) {
      Node cur = getNode(i);
      if(cur.name.equals(name)) {
        return cur;
      }
    }
    return null;
  }
  
  public void send(String dest, String message) {
    if(dest.equals(name)) {
      System.out.println("[" + dest + "] : " + message);
    } else {
      for(int i = 0 ; i < size() ; i++) {
        Node n = getNode(i);
        n.send(dest, message);
      }
    }
  }
  
  @Override
  public boolean equals(Object ob) {
    if(ob instanceof Node) {
      Node n = (Node) ob;
      return n.name.equals(name);
    }
    return false;
  }
  
  @Override
  public String toString() {
    return getName();
  }

  public static void main(String[] args) {
    Node a = new Node("a");
    Node b = new Node("b");
    a.addNode(b);
    a.addNode("c").addNode("d");
    a.send("d", "Je suis d !!!");
  }
  
}