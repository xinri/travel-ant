import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class AntTravelLauncher {

  public static void main(String[] args) {
    AntTravelLauncher launcher = new AntTravelLauncher();
    launcher.openFileAndLaunchGame();
  }

  private void openFileAndLaunchGame() {
    ClassLoader classLoader = getClass().getClassLoader();

    File file = new File(classLoader.getResource("boardInput.txt").getFile());
    Board board = new Board();

    try (Scanner scanner = new Scanner(file)) {

      if (!scanner.hasNextLine()) {
        throw new IllegalStateException("Must input the first line as the actual nb step");
      }

      int nbStepMax = Integer.valueOf(scanner.nextLine());
      int nbStep = Integer.valueOf(scanner.nextLine());

      int ant_x = Integer.valueOf(scanner.nextLine()) - 1;
      int ant_y = Integer.valueOf(scanner.nextLine()) - 1;

      Ant ant = new Ant();
      ant.setPosition(ant_x, ant_y);
      ant.setDirection(Direction.EAST);

      if (!scanner.hasNextLine()) {
        throw new IllegalStateException("No Data");
      }

      List<String> boardRepresentation = new ArrayList<>();

      while (scanner.hasNextLine()) {
        boardRepresentation.add(scanner.nextLine());
      }

      board.setBoard(boardRepresentation.toArray(new String[boardRepresentation.size()]));

      int nbExecution = nbStepMax - nbStep + 1;

      IntStream.range(0, nbExecution)
          .forEach(i -> ant.move(board));

      System.out.println("(" + (ant.getPosition().getX() + 1) + ", " + (ant.getPosition().getY() + 1) + ")");

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}
