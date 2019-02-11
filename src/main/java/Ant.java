public class Ant {

  private Direction direction;
  private int x, y;

  public void setPosition(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public void setDirection(Direction direction) {
    this.direction = direction;
  }

  public void move(Board board) {
    if (Case.WHITE == board.getCase(x, y)) {
      if (direction == Direction.NORTH) {
        direction = Direction.WEST;
      } else if (direction == Direction.WEST) {
        direction = Direction.SOUTH;
      } else if (direction == Direction.SOUTH) {
        direction = Direction.EAST;
      } else {
        direction = Direction.NORTH;
      }
    }

    if (Case.BLACK == board.getCase(x, y)) {
      if (direction == Direction.NORTH) {
        direction = Direction.EAST;
      } else if (direction == Direction.EAST) {
        direction = Direction.SOUTH;
      } else if (direction == Direction.SOUTH) {
        direction = Direction.WEST;
      } else {
        direction = Direction.NORTH;
      }
    }

    board.nextColor(x, y);
  }

  public Direction getDirection() {
    return direction;
  }
}
