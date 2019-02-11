public class Ant {

  private Direction direction;
  private Position position;

  public void setPosition(int x, int y) {
    this.position = new Position(x, y);
  }

  public void setDirection(Direction direction) {
    this.direction = direction;
  }

  public void move(Board board) {
    direction = direction.nextDirection(board.getCase(position.getX(), position.getY()));

    if (board.getCase(position.getX(), position.getY()) == Case.ORANGE) {
      board.nextColor(position.getX(), position.getY());
      Position oldPosition = position;
      position = direction.nextPosition(position, board.getWidth(), board.getHeight());
      direction = direction.oppositeDirectionIfGoingOutside(oldPosition, position);
    } else {
      board.nextColor(position.getX(), position.getY());
    }
  }

  public Direction getDirection() {
    return direction;
  }

  public Position getPosition() {
    return position;
  }

}
