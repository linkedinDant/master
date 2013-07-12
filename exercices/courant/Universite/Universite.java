import java.util.ArrayList;

public class Universite {

  private ArrayList<Etudiant> etudiants;
  private ArrayList<Enseignant> prof;
  private ArrayList<Module> modules;
  private String nom;
  
  public Universite(String nom) {
    this.nom = nom;
    etudiants = new ArrayList<Etudiant>();
    prof = new ArrayList<Enseignant>();
    modules = new ArrayList<Module>();
  }
  
  public String getNom() {
    return nom;
  }
  
  public String toString() {
    return getNom();
  }
  
  public boolean inscrireEtudiant(String nom, String prenom) {
    return etudiants.add(new Etudiant(nom, prenom));
  }
  
  public boolean inscrireEnseignant(String nom) {
    return prof.add(new Enseignant(nom));
  }
  
  public boolean ajouterModule(String module, String prof) {
    int position = this.prof.indexOf(new Enseignant(prof));
    if(position == -1) {
      return false; // Le prof n'existe pas
    }
    return modules.add(new Module(module, this.prof.get(position)));
  }
  
  public void addEtudiantOnModule(Module module, Etudiant etu) {
    int pos = etudiants.indexOf(etu);
    if(pos == -1) {
      etudiants.add(etu);
    }
    module.inscrireEtudiant(etu);
  }
  
  public ArrayList<Etudiant> getEtudiantsFromModule(String module) {
    for(int i = 0 ; i < modules.size() ; i++) {
      if(modules.get(i).getNom().equals(module)) {
	return modules.get(i).getInscrits();
      }
    }
    return null;
  }

}