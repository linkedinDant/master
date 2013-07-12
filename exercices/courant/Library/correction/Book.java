public class Book {
  
  private String nom;
  private String auteur;  
  private int annee;
  private boolean emprunte;
  
  public Book(String nom, String auteur, int annee) {
    this.nom = nom;
    this.auteur = auteur;
    this.annee = annee;
    emprunte = false;
  }
  
  public String getNom() {
    return nom;
  }
  
  public String getAuteur() {
    return auteur;
  }
  
  public int getAnnee() {
    return annee;
  }
  
  public boolean isEmprunte() {
    return emprunte;
  }
  
  public void setEmprunte(boolean emprunte) {
    this.emprunte = emprunte;
  }
  
  public boolean equals(Object ob) {
    if(ob instanceof Book) {
      Book b = (Book) ob;
      return annee == b.annee && nom == b.nom && auteur == b.auteur && emprunte == b.emprunte;
    }
    return false;
  }
  
  public String toString() {
    return nom;
  }
  
}