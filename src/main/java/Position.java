import jdk.nashorn.internal.ir.annotations.Immutable;

@Immutable
public final class Position {

  private int x, y;

  public Position(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public Position moveUp() {
    if (y - 1 < 0) {
      return this;
    }
    return new Position(x, y - 1);
  }

  public Position moveDown(int height) {
    if (y + 1 >= height) {
      return this;
    }
    return new Position(x, y + 1);
  }

  public Position moveRight(int width) {
    if (x + 1 >= width) {
      return this;
    }
    return new Position(x + 1, y);
  }

  public Position moveLeft() {
    if (x - 1 < 0) {
      return this;
    }
    return new Position(x - 1, y);
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }
}
