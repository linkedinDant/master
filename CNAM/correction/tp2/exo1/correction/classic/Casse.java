package tp2.exo1.correction.classic;

public class Casse {

  public static void main(String[] args) {
    char[] count = "AazeGfdfsfFDGfgfgdfFFDdFdgFGdDgfGFgf".toCharArray();
    System.out.println(countUppercase(count)); // 14
    System.out.println(countLowercase(count)); // 22
  }

  static public int countUppercase(char[] val) {
    int cpt = 0;
    for(int i = 0 ; i < val.length ; i++) {
      if(Character.isUpperCase(val[i])) {
        cpt++;
      }
    }
    return cpt;
  }

  static public int countLowercase(char[] val) {
    int cpt = 0;
    for(int i = 0 ; i < val.length ; i++) {
      if(Character.isLowerCase(val[i])) {
        cpt++;
      }
    }
    return cpt;
    // Sinon la manière la plus simple de faire est : 
    // return val.length - countUppercase(val); 
    // Le nombre minuscules = nombre de caractères - nombre de majuscules.
  }

}
