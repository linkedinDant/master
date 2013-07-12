public class Chars {

  private char[] array;
  
  public Chars(int size) {
    this.array = new char[size];
  }
  
  public Chars(char[] a) {
    this.array = a;
  }
  
  public Chars(String s) {
    this(s.toCharArray());
  }
  
  public Chars(StringBuilder sb) {
    this(sb.toString());
  }
  
  public int length () {
    return array.length;
  }
  
  public boolean isEmpty () {
    return length() == 0;
  }
  
  public char charAt(int pos) {
    return array[pos];
  }
  
  public char setChar(char c, int pos) {
    char old = array[pos];
    array[pos] = c;
    return old;
  }
  
  public Chars getChars(int src, int end, Chars c, int dest) {
    for(int i = src ; i < end ; i++) {
      c.setChar(array[i], dest);
      dest++;
    }
    return this;
  }
  
  public int indexOf(char c) {
    for(int i = 0 ; i < length() ; i++) {
      if(array[i] == c) {
	return i;
      }
    }
    return -1;
  }
  
  
  public int lastIndexOf(char c) {
    for(int i = length() - 1 ; i >= 0 ; i--) {
      if(array[i] == c) {
	return i;
      }
    }
    return -1;
  }
  
  public Chars replace(char find, char c) {
    for(int i = 0 ; i < length() ; i++) {
      if(array[i] == find) {
	array[i] = c;
      }
    }
    return this;
  }
  
  public Chars subString(int end) {
    return subString(0, end);
  }
  
  public Chars subString(int from, int end) {
    Chars c = new Chars(end - from);
    for(int i = from; i < end ; i++) {
      c.setChar(array[i], i - from);
    }
    return c;
  }
  
  public Chars concat(String s) {
    return concat(new Chars(s));
  }
  
  public Chars concat(Chars s) {
    int length = length();
    char[] newArray = new char[length + s.length()];
    for(int i = 0 ; i < length ; i++) {
      newArray[i] = array[i];
    }
    for(int i = 0 ; i < s.length() ; i++) {
      newArray[i + length] = s.charAt(i);
    }
    array = newArray;
    return this;
  }
  
  public boolean equals(Object ob) {
    if(ob instanceof Chars) {
      Chars c = (Chars) ob;
      if(length() != c.length()) return false;
      
      for(int i = 0 ; i < length() ; i++) {
	if(array[i] != c.array[i]) return false;
      }
      return true;
    }
    return false;
  }
  
  public String toString() {
    return new String(array);
  }
}