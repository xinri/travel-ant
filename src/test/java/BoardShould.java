import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.Test;

public class BoardShould {

  @Test
  public void stay_change_to_black_and_face_north_when_ant_is_in_a_white_case_and_face_east() {
    // given
    Board board = new Board();
    board.setBoard(new String[]{"b"});
    Ant ant = new Ant();
    ant.setPosition(0, 0);
    ant.setDirection(Direction.EAST);

    // when
    ant.move(board);

    // then
    assertThat(board.getCase(0, 0)).isEqualTo(Case.BLACK);
    assertThat(ant.getDirection() == Direction.NORTH).isTrue();
  }

  @Test
  public void stay_change_to_black_and_face_west_when_ant_is_in_a_white_case_and_face_north() {
    // given
    Board board = new Board();
    board.setBoard(new String[]{"b"});
    Ant ant = new Ant();
    ant.setPosition(0, 0);
    ant.setDirection(Direction.NORTH);

    // when
    ant.move(board);

    // then
    assertThat(board.getCase(0, 0)).isEqualTo(Case.BLACK);
    assertThat(ant.getDirection() == Direction.WEST).isTrue();
  }

  @Test
  public void stay_change_to_black_and_face_south_when_ant_is_in_a_white_case_and_face_west() {
    // given
    Board board = new Board();
    board.setBoard(new String[]{"b"});
    Ant ant = new Ant();
    ant.setPosition(0, 0);
    ant.setDirection(Direction.WEST);

    // when
    ant.move(board);

    // then
    assertThat(board.getCase(0, 0)).isEqualTo(Case.BLACK);
    assertThat(ant.getDirection() == Direction.SOUTH).isTrue();
  }

  @Test
  public void stay_change_to_black_and_face_east_when_ant_is_in_a_white_case_and_face_south() {
    // given
    Board board = new Board();
    board.setBoard(new String[]{"b"});
    Ant ant = new Ant();
    ant.setPosition(0, 0);
    ant.setDirection(Direction.SOUTH);

    // when
    ant.move(board);

    // then
    assertThat(board.getCase(0, 0)).isEqualTo(Case.BLACK);
    assertThat(ant.getDirection() == Direction.EAST).isTrue();
  }

  @Test
  public void stay_change_to_orange_and_face_south_when_ant_is_in_a_black_case_and_face_east() {
    // given
    Board board = new Board();
    board.setBoard(new String[]{"n"});
    Ant ant = new Ant();
    ant.setPosition(0, 0);
    ant.setDirection(Direction.EAST);

    // when
    ant.move(board);

    // then
    assertThat(board.getCase(0, 0)).isEqualTo(Case.ORANGE);
    assertThat(ant.getDirection() == Direction.SOUTH).isTrue();
  }

  @Test
  public void stay_change_to_orange_and_face_east_when_ant_is_in_a_black_case_and_face_north() {
    // given
    Board board = new Board();
    board.setBoard(new String[]{"n"});
    Ant ant = new Ant();
    ant.setPosition(0, 0);
    ant.setDirection(Direction.NORTH);

    // when
    ant.move(board);

    // then
    assertThat(board.getCase(0, 0)).isEqualTo(Case.ORANGE);
    assertThat(ant.getDirection() == Direction.EAST).isTrue();
  }

  @Test
  public void stay_change_to_orange_and_face_north_when_ant_is_in_a_black_case_and_face_west() {
    // given
    Board board = new Board();
    board.setBoard(new String[]{"n"});
    Ant ant = new Ant();
    ant.setPosition(0, 0);
    ant.setDirection(Direction.WEST);

    // when
    ant.move(board);

    // then
    assertThat(board.getCase(0, 0)).isEqualTo(Case.ORANGE);
    assertThat(ant.getDirection() == Direction.NORTH).isTrue();
  }

  @Test
  public void stay_change_to_orange_and_face_west_when_ant_is_in_a_black_case_and_face_south() {
    // given
    Board board = new Board();
    board.setBoard(new String[]{"n"});
    Ant ant = new Ant();
    ant.setPosition(0, 0);
    ant.setDirection(Direction.SOUTH);

    // when
    ant.move(board);

    // then
    assertThat(board.getCase(0, 0)).isEqualTo(Case.ORANGE);
    assertThat(ant.getDirection() == Direction.WEST).isTrue();
  }

  @Test
  public void move_forward_and_change_case_to_white_when_ant_is_in_a_orange_case_and_face_east() {
    // given
    Board board = new Board();
    board.setBoard(new String[]{"o n"});
    Ant ant = new Ant();
    ant.setPosition(0, 0);
    ant.setDirection(Direction.EAST);

    // when
    ant.move(board);

    // then
    assertThat(board.getCase(0, 0)).isEqualTo(Case.WHITE);
    assertThat(ant.getDirection() == Direction.EAST).isTrue();
    assertThat(ant.getPosition().getX() == 1).isTrue();
    assertThat(ant.getPosition().getY() == 0).isTrue();
  }

  @Test
  public void move_forward_and_change_case_to_white_when_ant_is_in_a_orange_case_and_face_north() {
    // given
    Board board = new Board();
    board.setBoard(new String[]{"n n", "o n"});
    Ant ant = new Ant();
    ant.setPosition(0, 1);
    ant.setDirection(Direction.NORTH);

    // when
    ant.move(board);

    // then
    assertThat(board.getCase(0, 1)).isEqualTo(Case.WHITE);
    assertThat(ant.getDirection() == Direction.NORTH).isTrue();
    assertThat(ant.getPosition().getX() == 0).isTrue();
    assertThat(ant.getPosition().getY() == 0).isTrue();
  }

  @Test
  public void move_forward_and_change_case_to_white_when_ant_is_in_a_orange_case_and_face_west() {
    // given
    Board board = new Board();
    board.setBoard(new String[]{"n o"});
    Ant ant = new Ant();
    ant.setPosition(1, 0);
    ant.setDirection(Direction.WEST);

    // when
    ant.move(board);

    // then
    assertThat(board.getCase(1, 0)).isEqualTo(Case.WHITE);
    assertThat(ant.getDirection() == Direction.WEST).isTrue();
    assertThat(ant.getPosition().getX() == 0).isTrue();
    assertThat(ant.getPosition().getY() == 0).isTrue();
  }

  @Test
  public void move_forward_and_change_case_to_white_when_ant_is_in_a_orange_case_and_face_south() {
    // given
    Board board = new Board();
    board.setBoard(new String[]{"o n", "n n"});
    Ant ant = new Ant();
    ant.setPosition(0, 0);
    ant.setDirection(Direction.SOUTH);

    // when
    ant.move(board);

    // then
    assertThat(board.getCase(0, 0)).isEqualTo(Case.WHITE);
    assertThat(ant.getDirection() == Direction.SOUTH).isTrue();
    assertThat(ant.getPosition().getX() == 0).isTrue();
    assertThat(ant.getPosition().getY() == 1).isTrue();
  }
}
