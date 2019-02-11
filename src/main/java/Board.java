import java.util.HashMap;
import java.util.Map;

public class Board {

  private static final Map<Character, Case> mapOfStringToCase =
      new HashMap<>(3);

  static {
    mapOfStringToCase.put('n', Case.BLACK);
    mapOfStringToCase.put('b', Case.WHITE);
    mapOfStringToCase.put('o', Case.ORANGE);
  }

  private Case[][] board;

  public void setBoard(String[] boardRepresentation) {

    int width = boardRepresentation[0].length();
    int height = boardRepresentation.length;

    board = new Case[height][width];

    for (int row = 0; row < height; row++) {
      for (int column = 0; column < width; column++) {
        board[row][column] = mapOfStringToCase.get(boardRepresentation[row].charAt(column));
      }
    }
  }

  public Case getCase(int x, int y) {
    return board[y][x];
  }

  public void nextColor(int x, int y) {
    board[y][x] = board[y][x].getNextColor();
  }
}
