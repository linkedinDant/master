

public class Post {

  private String auteur;
  private String message;
  private long date;

  public Post() {
  }

  public Post(String auteur, String message, long date) {
    this.auteur = auteur;
    this.message = message;
    this.date = date;
  }

  public String getAuteur() {
    return this.auteur;
  }

  public void setAuteur(String auteur) {
    this.auteur = auteur;
  }

  public String getMessage() {
    return this.message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public long getDate() {
    return this.date;
  }

  public void setDate(long date) {
    this.date = date;
  }

  @Override
  public boolean equals(Object ob) {
    if (ob instanceof Post) {
      Post p = (Post) ob;
      return message.equals(p.message) && date == p.date && auteur.equals(p.auteur);
    }
    return false;
  }

  @Override
  public String toString() {
    return getMessage();
  }

}
