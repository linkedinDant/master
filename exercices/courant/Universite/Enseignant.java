

public class Enseignant {

  private String nom;
  
  public Enseignant(String nom) {
    this.nom = nom;
  }
  
  public String getNom() {
    return nom;
  }
   
  public void setNom(String nom) {
    this.nom = nom;
  }
  
  public String toString() {
    return nom;
  }
  
  public boolean equals(Object ob) {
    if(ob instanceof Enseignant) {
      Enseignant etu = (Enseignant) ob;
      return etu.nom.equals(nom);
    }
    return false;
  }

}