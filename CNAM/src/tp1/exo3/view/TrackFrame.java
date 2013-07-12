package tp1.exo3.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import tp1.exo3.image.ImageBuilder;
import tp1.exo3.view.TrackPanel;


public class TrackFrame {

  public static void main(String[] args) {
    String filename = "track/1_safe.trk"; // A éditer si l'on veut afficher différentes images. Elles se trouvent toutes dans le dossier track/
    showFrame(filename);
  }

  private static void showFrame(String filename) {
    // On charge l'image dont le nom de fichier est spécifié 
    ImageBuilder imageBuilder = new ImageBuilder();
    imageBuilder.read(filename);
    // Si la variable est bien initialisée on affiche
    if (imageBuilder.getColors() != null) {
      JFrame frame = new JFrame("Course");
      JPanel panel = new TrackPanel(imageBuilder);
      frame.setContentPane(panel);
      frame.pack();
      frame.setSize(imageBuilder.getLongueur(), imageBuilder.getHauteur());
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
    } else {
      System.err.println("L'image " + filename
          + " à charger est null. L'affichage de celle-ci ne se fera pas. Cela signifie que la variable \"colors\" de \"ImageBuilder\" est null");
    }

  }

}
