import java.util.ArrayList;

public class Module {

  private ArrayList<Etudiant> inscrits;
  private Enseignant prof;
  private String nom;
  
  public Module(String nom, Enseignant prof) {
    this.nom = nom;
    this.prof = prof;
    inscrits = new ArrayList<Etudiant>();
  }
  
  public String getNom() {
    return nom;
  }
  
  public Enseignant getProf() {
    return prof;
  }
  
  public ArrayList<Etudiant> getInscrits() {
    return inscrits;
  }
  
  public void inscrireEtudiant(Etudiant etu) {
    inscrits.add(etu);
  }
  
  public void desinscrireEtudiant(Etudiant etu) {
    inscrits.remove(etu);
  }
  
  public int nombreEtudiant() {
    return inscrits.size();
  }
  
  public boolean estInscrit(Etudiant etu) {
    return inscrits.indexOf(etu) != -1;
  }
  
  public String toString() {
    return nom;
  }
  
  public boolean equals(Object ob) {
    if(ob instanceof Module) {
      Module mod = (Module) ob;
      return mod.nom.equals(nom);
    }
    return false;
  }

}