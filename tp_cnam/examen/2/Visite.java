public class Visite {

  String nom;
  double distance,duree;
  
  public Visite(String nom, double distance, double duree) {
    this.nom = nom;
    this.distance = distance;
    this.duree = duree;
  }
  
  public void affiche() {
    System.out.println("nom : " + nom);
    System.out.println("distance = " + distance);
    System.out.println("duree = " + duree);
  }
  
  public double cout() {
    return 0.1 * distance;
  }

}