package tp1.exo2.correction.store;

public class Application {

  static private int cpt = 1;

  private int id;
  private String name;
  private int popularite;
  private String description;

  public Application(String name, String description) {
    id = cpt++;
    this.name = name;
    this.popularite = 0;
    this.description = description;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getId() {
    return this.id;
  }

  public int getPopularite() {
    return this.popularite;
  }

  public void incrementPopularite() {
    popularite++;
  }

  @Override
  public boolean equals(Object ob) {
    if (ob instanceof Application) {
      Application app = (Application) ob;
      return id == app.id;
    }
    return false;
  }

  @Override
  public String toString() {
    return getName();
  }

}
