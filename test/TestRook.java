import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import chess.Bishop;
import chess.Color;
import chess.King;
import chess.Knight;
import chess.Pawn;
import chess.Queen;
import chess.Rook;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class for the rook class.
 */
public class TestRook {

  /**
   * The Piece 1.
   */
  Rook piece1;

  /**
   * Create the queen objects for test purpose.
   *
   * @throws IllegalArgumentException if the position is out of bound.
   */
  @Before
  public void setUp() throws IllegalArgumentException {
    piece1 = new Rook(5, 2, Color.WHITE);
  }

  /**
   * Test method for the canMove() method.
   */
  @Test
  public void testCanMove() {

    assertTrue(piece1.canMove(5, 0));
    assertTrue(piece1.canMove(5, 1));
    assertTrue(piece1.canMove(5, 3));
    assertTrue(piece1.canMove(5, 4));
    assertTrue(piece1.canMove(3, 2));
    assertTrue(piece1.canMove(4, 2));
    assertTrue(piece1.canMove(6, 2));
    assertTrue(piece1.canMove(7, 2));

    assertFalse(piece1.canMove(4, 1));
    assertFalse(piece1.canMove(4, 3));
    assertFalse(piece1.canMove(6, 1));
    assertFalse(piece1.canMove(6, 3));
  }

  /**
   * Test method for exceptions thrown by canMove() method.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testCanMoveException() {
    assertFalse(piece1.canMove(-1, 2));
    assertFalse(piece1.canMove(5, -1));
    assertFalse(piece1.canMove(8, 2));
    assertFalse(piece1.canMove(5, 8));
  }

  /**
   * Test method for canKill() method.
   */
  @Test
  public void testCanKill() {

    assertTrue(piece1.canKill(new Bishop(5, 0, Color.BLACK)));
    assertTrue(piece1.canKill(new Knight(5, 1, Color.BLACK)));
    assertTrue(piece1.canKill(new Pawn(5, 3, Color.BLACK)));
    assertTrue(piece1.canKill(new Queen(5, 4, Color.BLACK)));
    assertTrue(piece1.canKill(new Rook(3, 2, Color.BLACK)));
    assertTrue(piece1.canKill(new King(4, 2, Color.BLACK)));
    assertTrue(piece1.canKill(new Knight(6, 2, Color.BLACK)));
    assertTrue(piece1.canKill(new King(7, 2, Color.BLACK)));

    assertFalse(piece1.canKill(new Bishop(4, 1, Color.BLACK)));
    assertFalse(piece1.canKill(new Knight(4, 3, Color.BLACK)));
    assertFalse(piece1.canKill(new Pawn(6, 1, Color.BLACK)));
    assertFalse(piece1.canKill(new Queen(6, 3, Color.BLACK)));

    assertFalse(piece1.canKill(new Bishop(5, 0, Color.WHITE)));
    assertFalse(piece1.canKill(new Knight(5, 1, Color.WHITE)));
    assertFalse(piece1.canKill(new Pawn(5, 3, Color.WHITE)));
    assertFalse(piece1.canKill(new Queen(5, 4, Color.WHITE)));
  }
}