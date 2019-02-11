public enum Case {
  BLACK,
  WHITE,
  ORANGE;

  static {
    BLACK.nextColor = ORANGE;
    WHITE.nextColor = BLACK;
    ORANGE.nextColor = WHITE;
  }

  private Case nextColor;

  public Case getNextColor() {
    return nextColor;
  }
}
