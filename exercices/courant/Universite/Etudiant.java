

public class Etudiant {

  private int numero;
  private String nom;
  private String prenom;
  
  public Etudiant() {
    numero = (int) (Math.random() * 10000000);
  }
  
  public Etudiant(String nom, String prenom) {
    numero = (int) (Math.random() * 10000000);
    this.nom = nom;
    this.prenom = prenom;
  }
  
  public String getNom() {
    return nom;
  }
  
  public String getPrenom() {
    return prenom;
  }
  
  public void setNom(String nom) {
    this.nom = nom;
  }
  
  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }
  
  public int getNumero() {
    return numero;
  }
  
  public String toString() {
    return numero + "";
  }
  
  public boolean equals(Object ob) {
    if(ob instanceof Etudiant) {
      Etudiant etu = (Etudiant) ob;
      return etu.numero == numero;
    }
    return false;
  }

}