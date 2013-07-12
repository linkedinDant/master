public class TestListe {

  public static void main(String[] args) {
    ListeGateau liste = new ListeGateau();
    System.out.println(liste.poids()); // Doit afficher 0
    liste.ajouterAuDebut(new Gateau(1, "", 2.0));
    liste.ajouterAuDebut(new Gateau(2, "", 4.0));
    liste.ajouterAuDebut(new Gateau(3, "", 3.3));
    System.out.println(liste.poids()); // Doit afficher 9.3
  }

}