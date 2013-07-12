public class VisiteAvecNuit extends Visite {

  int nombreDeNuit;
  
  public VisiteAvecNuit(String nom, double distance, double duree, int nombreDeNuit) {
    super(nom, distance, duree);
    
    this.nombreDeNuit = nombreDeNuit;
  }
  
  public double cout() {
    return (0.1 * distance) + (30 * nombreDeNuit);
  }

}
