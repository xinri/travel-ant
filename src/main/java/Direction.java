public enum Direction {
  NORTH, WEST, SOUTH, EAST;

  static {
    NORTH.nextDirectionFromBlack = EAST;
    WEST.nextDirectionFromBlack = NORTH;
    SOUTH.nextDirectionFromBlack = WEST;
    EAST.nextDirectionFromBlack = SOUTH;

    NORTH.nextDirectionFromWhite = WEST;
    WEST.nextDirectionFromWhite = SOUTH;
    SOUTH.nextDirectionFromWhite = EAST;
    EAST.nextDirectionFromWhite = NORTH;
  }

  private Direction nextDirectionFromBlack;
  private Direction nextDirectionFromWhite;

  public Direction nextDirection(Case boardCase) {
    if (boardCase == Case.WHITE) {
      return this.nextDirectionFromWhite;
    }

    if (boardCase == Case.BLACK) {
      return this.nextDirectionFromBlack;
    }
    return this;
  }
}
