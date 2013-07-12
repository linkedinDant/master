public class Stack {

  private Object[] stack;
  private int sp;
  
  public Stack(int size) {
    stack = new Object[size];
    sp = 0;
  }

  public int size() {
    return sp;
  }
  
  public boolean isEmpty() {
    return sp == 0;
  }
  
  public boolean isFull() {
    return sp >= stack.length;
  }
  
  public boolean push(Object ob) {
    // Si la pile est pleine on ne peut rien ajouter
    if(isFull()) {
      return false;
    }
    // On ajoute l'element dans la pile et on incrémente le compteur
    stack[sp] = ob;
    sp++;
    return true;
  }
  
  public Object pop() {
    // Si la pile est vide, on retourne null
    if(isEmpty()) {
      return null;
    }
    sp--;
    Object ob = stack[sp];    
    stack[sp] = null;
    return ob;
  }

  public Object top() {
    if(isEmpty()) {
	return null;
    }
    return stack[sp -1];
  }

} 
