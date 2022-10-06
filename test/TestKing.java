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
 * The test class for the King class.
 */
public class TestKing {

  /**
   * The Piece 1.
   */
  King piece1;
  /**
   * The Piece 2.
   */
  King piece2;

  /**
   * Create the king objects for test purpose.
   *
   * @throws Exception the exception
   */
  @Before
  public void setUp() throws Exception {
    piece1 = new King(5, 2, Color.BLACK);
    piece2 = new King(6, 2, Color.WHITE);
  }

  /**
   * Test method for the canMove() method.
   */
  @Test
  public void testCanMove() {
    assertTrue(piece1.canMove(5, 1));
    assertTrue(piece1.canMove(5, 3));
    assertTrue(piece1.canMove(4, 1));
    assertTrue(piece1.canMove(4, 2));
    assertTrue(piece1.canMove(4, 3));
    assertTrue(piece1.canMove(6, 1));
    assertTrue(piece1.canMove(6, 2));
    assertTrue(piece1.canMove(6, 3));


    assertFalse(piece1.canMove(3, 2));
    assertFalse(piece1.canMove(7, 2));
    assertFalse(piece1.canMove(5, 0));
    assertFalse(piece1.canMove(5, 4));
    assertFalse(piece1.canMove(3, 1));
    assertFalse(piece1.canMove(3, 3));
    assertFalse(piece1.canMove(7, 1));
    assertFalse(piece1.canMove(7, 3));
  }

  /**
   * Test method for exceptions thrown by canMove() method.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testCanMoveException() {
    assertFalse(piece1.canMove(-1, 2));
    assertFalse(piece1.canMove(2, -1));
    assertFalse(piece1.canMove(8, 2));
    assertFalse(piece1.canMove(2, 8));
  }

  /**
   * Test method for canKill() method.
   */
  @Test
  public void testCanKill() {
    assertTrue(piece1.canKill(new Bishop(5, 1, Color.WHITE)));
    assertTrue(piece1.canKill(new Knight(5, 3, Color.WHITE)));
    assertTrue(piece1.canKill(new Pawn(4, 1, Color.WHITE)));
    assertTrue(piece1.canKill(new Queen(4, 2, Color.WHITE)));
    assertTrue(piece1.canKill(new Rook(4, 3, Color.WHITE)));
    assertTrue(piece1.canKill(new King(6, 1, Color.WHITE)));
    assertTrue(piece1.canKill(new Knight(6, 2, Color.WHITE)));
    assertTrue(piece1.canKill(new King(6, 3, Color.WHITE)));

    assertFalse(piece1.canKill(new Bishop(3, 2, Color.WHITE)));
    assertFalse(piece1.canKill(new King(7, 2, Color.WHITE)));
    assertFalse(piece1.canKill(new Knight(5, 0, Color.WHITE)));
    assertFalse(piece1.canKill(new Pawn(5, 4, Color.WHITE)));
    assertFalse(piece1.canKill(new Queen(3, 1, Color.WHITE)));
    assertFalse(piece1.canKill(new Rook(3, 3, Color.WHITE)));
    assertFalse(piece1.canKill(new King(7, 1, Color.WHITE)));
    assertFalse(piece1.canKill(new Knight(7, 3, Color.WHITE)));

    assertFalse(piece1.canKill(new Bishop(5, 1, Color.BLACK)));
    assertFalse(piece1.canKill(new Knight(5, 3, Color.BLACK)));
    assertFalse(piece1.canKill(new Pawn(4, 1, Color.BLACK)));
    assertFalse(piece1.canKill(new Queen(4, 2, Color.BLACK)));
    assertFalse(piece1.canKill(new Rook(4, 3, Color.BLACK)));
    assertFalse(piece1.canKill(new King(6, 1, Color.BLACK)));
    assertFalse(piece1.canKill(new Knight(6, 2, Color.BLACK)));
    assertFalse(piece1.canKill(new King(6, 3, Color.BLACK)));
  }
}