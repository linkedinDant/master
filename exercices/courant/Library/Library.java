import java.util.ArrayList;

public class Library {

  private ArrayList<Book> books;
  
  public Library() {
    books = new ArrayList<Book>();
  }
  
  public int size() {
    return 0;
  }
  
  public void addBook(Book b) {
    
  }
  
  public Book findByNom(String nom) {
    return null;
  }
  
  public ArrayList<Book> findByAuteur(String auteur) {
    return null;
  }
  
  public ArrayList<Book> findByAnnee(int annee) {
    return null;
  }
  
  public boolean emprunter(String nom) {
    return false;
  }
  
  public void rendre(Book b) {
    
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