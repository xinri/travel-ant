import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.Test;

public class BoardShould {

  @Test
  public void stay_and_face_north_when_ant_is_in_a_black_case_and_face_east() {
    // given
    Board board = new Board();
    board.setBoard(new String[]{"b"});
    Ant ant = new Ant();
    ant.setPosition(0, 0);
    ant.setDirection(Direction.EAST);

    // when
    ant.move(board);

    // then
    assertThat(board.getCase(0, 0)).isEqualTo("n");
    assertThat(ant.getDirection() == Direction.NORTH).isTrue();
  }

}
