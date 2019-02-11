import java.util.function.Function;

public enum Direction {
  NORTH(position -> width -> height -> position.moveUp()),
  WEST(position -> width -> height -> position.moveLeft()),
  SOUTH(position -> width -> height -> position.moveDown(height)),
  EAST(position -> width -> height -> position.moveRight(width));

  static {
    NORTH.nextDirectionFromBlack = EAST;
    WEST.nextDirectionFromBlack = NORTH;
    SOUTH.nextDirectionFromBlack = WEST;
    EAST.nextDirectionFromBlack = SOUTH;

    NORTH.nextDirectionFromWhite = WEST;
    WEST.nextDirectionFromWhite = SOUTH;
    SOUTH.nextDirectionFromWhite = EAST;
    EAST.nextDirectionFromWhite = NORTH;

    NORTH.oppositeDirection = SOUTH;
    WEST.oppositeDirection = EAST;
    SOUTH.oppositeDirection = NORTH;
    EAST.oppositeDirection = WEST;
  }

  private Direction nextDirectionFromBlack;
  private Direction nextDirectionFromWhite;
  private Direction oppositeDirection;
  private Function<Position, Function<Integer, Function<Integer, Position>>> moveFunction;

  Direction(Function<Position, Function<Integer, Function<Integer, Position>>> moveFunction) {
    this.moveFunction = moveFunction;
  }

  public Direction nextDirection(Case boardCase) {
    if (boardCase == Case.WHITE) {
      return this.nextDirectionFromWhite;
    }

    if (boardCase == Case.BLACK) {
      return this.nextDirectionFromBlack;
    }

    return this;
  }

  public Direction oppositeDirectionIfGoingOutside(Position oldPosition, Position newPosition) {
    if (oldPosition.getX() == newPosition.getX() && oldPosition.getY() == newPosition
        .getY()) {
      return oppositeDirection;
    }
    return this;
  }

  public Position nextPosition(Position actualPosition, int width, int height) {
    return moveFunction.apply(actualPosition).apply(width).apply(height);
  }
}
