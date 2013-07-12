package tp3.exo3.correction.examens;

public class TicTacToe {

  // Question 3 : On sauvegarde en mémoire un coup
  static private char[][] memory_grid;
  static private int memory_player;
  static private char memory_coup;
  
  public static void main(String[] args) {
    // Question 1 : Initialisation
    char[][] grid = new char[3][3];
    int player = 0;
    for (int i = 0; i < 3; i++) {
      grid[i][0] = ' ';
      grid[i][1] = ' ';
      grid[i][2] = ' ';
    }
    // Question 5 : On fait un appel
    save(player, grid, 'X');
    hasWinner(grid);
    print(grid);
  }

  // Question 2 : Affichage
  static public void print(char[][] grid) {
    for (int i = 0; i < 3; i++) {
      System.out.print("| ");
      for (int j = 0; j < 3; j++) {
        System.out.print(grid[i][j] + " | ");
      }
      System.out.println();
    }
  }
  
  // Question 3
  static public void save(int player, char[][] grid, char coup) {
    memory_grid = grid;
    memory_player = player;
    memory_coup = coup;
  }
  
  // Question 4 
  static public boolean hasWinner(char[][] grid) {
    for(int i = 0 ; i < 3 ; i++) {
      if(grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2]) {
        return true;
      }
    }
    for(int i = 0 ; i < 3 ; i++) {
      if(grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i]) {
        return true;
      }
    }
    if(grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) {
      return true;
    }
    return (grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]);
  }

}
