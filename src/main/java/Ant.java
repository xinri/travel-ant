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
    direction = direction.nextDirection(board.getCase(x, y));
    board.nextColor(x, y);
  }

  public Direction getDirection() {
    return direction;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }
}
