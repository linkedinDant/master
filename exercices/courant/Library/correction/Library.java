import java.util.ArrayList;

public class Library {

  private ArrayList<Book> books;
  
  public Library() {
    books = new ArrayList<Book>();
  }
  
  public int size() {
    return books.size();
  }
  
  public void addBook(Book b) {
    books.add(b);
  }
  
  public Book findByNom(String nom) {
    int size = size(); 
    for(int i = 0 ; i < size ; i++) {
      // On récupère le prochain livre de liste
      Book b = books.get(i);
      // S'il a le nom que l'on cherche, on le renvoie
      if(b.getNom().equals(nom)) {
	return b;
      }
    }
    // Le livre dont le nom est spécifié n'existe pas
    return null;
  }
  
  public ArrayList<Book> findByAuteur(String auteur) {
    int size = size(); 
    // On crée une nouvelle liste pour contenir les résultats de la recherche
    ArrayList<Book> results = new ArrayList<Book>();
    for(int i = 0 ; i < size ; i++) {
      // On récupère le prochain livre de liste
      Book b = books.get(i);
      // Si le livre est bien de l'auteur recherché, on l'ajoute
      if(b.getAuteur().equals(auteur)) {
	results.add(b);
      }
    }
    // On retourne la liste
    return results;
  }
  
  public ArrayList<Book> findByAnnee(int annee) {
    int size = size(); 
    // On crée une nouvelle liste pour contenir les résultats de la recherche
    ArrayList<Book> results = new ArrayList<Book>();
    for(int i = 0 ; i < size ; i++) {
      // On récupère le prochain livre de liste
      Book b = books.get(i);
      // Si le livre a la même date que celle spécifiée, on l'ajoute
      if(b.getAnnee() == annee) {
	results.add(b);
      }
    }
    // On retourne la liste
    return results;
  }
  
  public boolean emprunter(String nom) {
    // On recherche le livre dont le nom est spécifié
    Book result = findByNom(nom);
    // S'il n'existe pas ou qu'il est déjà emprunté, on retourne false
    if(result == null || result.isEmprunte()) {
      return false;
    }
    // Sinon on l'emprunte
    result.setEmprunte(true);
    return true;
  }
  
  public void rendre(Book b) {
    b.setEmprunte(false);
  }
  
  public static void main(String[] args) {
    Library l = new Library();
    Book a = new Book("x", "b", 2012);
    Book b = new Book("y", "b", 2013);
    Book c = new Book("z", "c", 2012);
    l.addBook(a);
    if(l.size() != 1) {
      System.out.println("La taille devrait être d'un élément. La méthode size ou addBook est erronée");
      return;
    }
    l.addBook(b);
    l.addBook(c);
    if(a != l.findByNom("x")) {
      System.out.println("La méthode findByNom ne renvoie pas le bon ouvrage.");
      return;
    }
    if(a != l.findByAuteur("b").get(0) || b != l.findByAuteur("b").get(1)) {
      System.out.println("La méthode findByAuteur ne renvoie pas les bons ouvrages.");
      return;
    }
    if(a != l.findByAnnee(2012).get(0) || c != l.findByAnnee(2012).get(1)) {
      System.out.println("La méthode findByAnnee ne renvoie pas les bons ouvrages.");
      return;
    }
    if(l.emprunter(a.getNom()) == false) {
      System.out.println("La méthode emprunter ne permet pas d'emprunter un ouvrage empruntable.");
      return;
    }
    if(l.emprunter(a.getNom())) {
      System.out.println("La méthode emprunter permet d'emprunter un ouvrage non empruntable.");
      return;
    }
    l.rendre(a);
    if(a.isEmprunte()) {
      System.out.println("La méthode rendre ne rend pas un ouvrage non empruntable.");
      return;
    }
    System.out.println("La classe Library est valide.");
  }
}