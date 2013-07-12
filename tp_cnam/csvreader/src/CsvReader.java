import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class CsvReader {

  static private final int MAX_WORDS = 150;
  static private final int MAX_LINES = 150;

  private char separator;
  private File file;
  private StreamTokenizer token;

  public CsvReader(char separator) {
    this.separator = separator;
  }

  public CsvReader(File file, char separator) throws FileNotFoundException {
    this.separator = separator;
    setFile(file);
  }

  public CsvReader(File file) throws FileNotFoundException {
    this.separator = ',';
    setFile(file);
  }

  public void setSeparator(char c) {
    separator = c;
  }

  public void setFile(File f) throws FileNotFoundException {
    file = f;
    token = new StreamTokenizer(new FileReader(file));
    token.eolIsSignificant(true);
    token.whitespaceChars(separator, separator);
    token.parseNumbers();
  }

  public void reset() throws FileNotFoundException {
    setFile(file); // Pour éviter de dupliquer le code, on recréer le StreamTokenizer
  }

  public String[] readLine() throws IOException {
    if (token == null) {
      throw new IOException("Il faut spécifier un fichier avant de pouvoir le parser");
    }
    int cpt = 0;
    int nextToken = token.nextToken();
    if(nextToken == StreamTokenizer.TT_EOF) {
      return null;
    }
    String[] content = new String[MAX_WORDS];
    while (nextToken != StreamTokenizer.TT_EOF) {
      if (nextToken == StreamTokenizer.TT_EOL) {
        return Arrays.copyOf(content, cpt);
      }
      if (token.ttype == StreamTokenizer.TT_WORD) {
        content[cpt] = token.sval;
      } else if (token.ttype == StreamTokenizer.TT_NUMBER) {
        content[cpt] = Double.toString(token.nval);
      }
      ++cpt;
      nextToken = token.nextToken();
    }
    return Arrays.copyOf(content, cpt);
  }
  
  public String[][] read() throws IOException {
    if (token == null) {
      throw new IOException("Il faut spécifier un fichier avant de pouvoir le parser");
    }
    String[][] content = new String[MAX_LINES][MAX_WORDS];
    int cpt = 0;
    while((content[cpt] = readLine()) != null) {
      ++cpt;
    }
    return content;
  }
  
  public void close() {
    token = null;
    file = null;
  }

}
