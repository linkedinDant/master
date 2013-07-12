public class ListeGateau {

  GateauListe premier;
  
  public GateauListe getPremier() {
    return premier;
  }
  
  public void ajouterAuDebut(Gateau g) {
    GateauListe ancienPremier = premier;
    premier = new GateauListe(g, ancienPremier);
  }
  
  public double poids() {
    GateauListe tmp = premier;
    double poids;
    if(tmp == null) {
      return 0.0;
    }
    poids = tmp.poids();
    while(tmp.getSuivant() != null) {
      tmp = tmp.getSuivant();
      poids += tmp.poids();
    }    
    return poids;
  }

}