package tp1.exo2.correction.store;

public class Main {

  public static void main(String[] args) {
    AppStore app = new AppStore();
    for(int i = 0 ; i < 30 ; i++) {
      app.addApplication(new Application(i + "", i + "")); // Les noms / description seront 1, 2, 3, ... pour chaque appli
    }
    System.out.println(app.indexOfApplication(app.find("22"))); // Doit être 22
    System.out.println(app.removeApplication(app.find("25"))); // Doit être true
    System.out.println(app.removeApplication(app.find("test"))); // Doit être false
    System.out.println(app.find("22")); // Doit renvoyer 22
    System.out.println(app.find(22)); // Idem
  }

}