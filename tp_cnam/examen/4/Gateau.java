public class Gateau {

  int num;
  String descriptif;
  double poids;
  
  public Gateau(int num, String descriptif, double poids) {
    this.num = num;
    this.descriptif = descriptif;
    this.poids = poids;
  }
  
  public double getPoids() {
    return poids;
  }

}