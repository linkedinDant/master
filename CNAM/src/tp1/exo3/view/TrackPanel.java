package tp1.exo3.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import tp1.exo3.image.ImageBuilder;


public class TrackPanel extends JPanel {

  private static final long serialVersionUID = 1L;

  private Color[][] colors;
  private int longueur, hauteur;

  public TrackPanel(ImageBuilder b) {
    this(b.getColors(), b.getLongueur(), b.getHauteur());
  }

  public TrackPanel(Color[][] colors, int longueur, int largeur) {
    this.colors = colors;
    this.hauteur = largeur;
    this.longueur = longueur;
  }

  @Override
  public void paintComponent(Graphics g) {
    if(colors == null) {
      return;
    }
    for (int i = 0; i < longueur; i++) {
      for (int j = 0; j < hauteur; j++) {
        g.setColor(colors[i][j]);
        g.drawRect(i, j, 1, 1);
      }
    }
  }

}
