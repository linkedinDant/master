package tp1.exo3.correction.file;

import java.io.FileInputStream;
import java.io.InputStream;

public class TrackReader {

  public String[] read(String filename) {
    try {
      InputStream file = new FileInputStream(filename);
      byte[] content = new byte[file.available()];
      file.read(content);
      file.close();
      return new String(content).split("\n");
    } catch (Exception e) {
      e.printStackTrace();
      System.err.println("Invalid Format : " + filename
               + "... Loading aborted");
      return null;
    }
  }
  
}
