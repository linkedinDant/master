public class GateauListe {

  private Gateau g;
  private GateauListe suivant;
  
  public GateauListe(Gateau g, GateauListe suivant) {
    this.g = g;
    this.suivant = suivant;
  }
  
  public GateauListe(Gateau g) {
    this.g = g;
    this.suivant = null;
  }
  
  // Getters / setters
  
  public GateauListe getSuivant() {
    return suivant;
  }
  
  public void setSuivant(GateauListe g) {
    suivant = g;
  }
  
  public Gateau getGateau() {
    return g;
  }
  
  public void setValeur(Gateau g) {
    this.g = g;
  }
  
  public double poids() {
    return g.getPoids();
  }

}