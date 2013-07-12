import java.io.File;
import java.io.IOException;
import java.util.Arrays;


public class Main {

  public static void main(String[] args) throws IOException {
    CsvReader r = new CsvReader(new File("file.csv"), ',');
    String[][] c = r.read();
    for(int i = 0 ; i < 4 ; i++)
    System.out.println(Arrays.toString(c[i]));
  }

}
