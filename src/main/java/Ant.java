public class Ant {

  private Direction direction;

  public void setPosition(int x, int y) {

  }

  public void setDirection(Direction direction) {
    this.direction = direction;
  }

  public void move(Board board) {
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

  public Direction getDirection() {
    return direction;
  }
}
