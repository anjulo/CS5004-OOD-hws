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
 * The test class for the pawn class.
 */
public class TestPawn {

  /**
   * The Piece 1.
   */
  Pawn piece1;
  /**
   * The Piece 2.
   */
  Pawn piece2;
  /**
   * The Piece 3.
   */
  Pawn piece3;
  /**
   * The Piece 4.
   */
  Pawn piece4;

  /**
   * Create the pawn objects for test purpose.
   *
   * @throws IllegalArgumentException if the position is out of bound.
   */
  @Before
  public void setUp() throws IllegalArgumentException {
    piece1 = new Pawn(1, 5, Color.WHITE);
    piece2 = new Pawn(6, 5, Color.BLACK);
    piece3 = new Pawn(5, 4, Color.WHITE);
    piece4 = new Pawn(2, 4, Color.BLACK);

  }

  /**
   * Test pawn constructor exceptions.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testPawnConstructorException() {
    piece1 = new Pawn(0, 2, Color.WHITE);
    piece2 = new Pawn(7, 2, Color.BLACK);

    piece1 = new Pawn(-1, 5, Color.WHITE);
    piece1 = new Pawn(1, -1, Color.BLACK);
    piece1 = new Pawn(1, 8, Color.WHITE);
    piece1 = new Pawn(8, 5, Color.BLACK);



  }

  /**
   * Test method for the canMove() method.
   */
  @Test
  public void testCanMove() {

    // white pawn at it's game start row
    assertFalse(piece1.canMove(0, 5));
    assertFalse(piece1.canMove(1, 5));
    assertTrue(piece1.canMove(2, 5));
    assertTrue(piece1.canMove(3, 5));
    assertFalse(piece1.canMove(4, 5));

    assertFalse(piece1.canMove(0, 4));
    assertFalse(piece1.canMove(1, 4));
    assertFalse(piece1.canMove(2, 4));
    assertFalse(piece1.canMove(0, 6));
    assertFalse(piece1.canMove(1, 6));
    assertFalse(piece1.canMove(2, 6));

    // white pawn at non-game-start row
    assertTrue(piece3.canMove(6, 4));
    assertFalse(piece3.canMove(7, 4));

    // black pawn at it's game start row
    assertFalse(piece2.canMove(7, 5));
    assertFalse(piece2.canMove(6, 5));
    assertTrue(piece2.canMove(5, 5));
    assertTrue(piece2.canMove(4, 5));
    assertFalse(piece2.canMove(3, 5));

    assertFalse(piece2.canMove(7, 4));
    assertFalse(piece2.canMove(6, 4));
    assertFalse(piece2.canMove(5, 4));

    assertFalse(piece2.canMove(7, 6));
    assertFalse(piece2.canMove(6, 6));
    assertFalse(piece2.canMove(5, 6));

    // black pawn at non-game-start row
    assertTrue(piece4.canMove(1, 4));
    assertFalse(piece4.canMove(0, 4));



  }

  /**
   * Test method for exceptions thrown by canMove() method.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testCanMoveExceptions() {

    // out of bound exception
    piece1.canMove(8, 5);
    piece1.canMove(-1, 5);
    piece1.canMove(2, 8);
    piece1.canMove(2, -1);

    // royal row exception
    piece1.canMove(0, 5);
    piece2.canMove(7, 5);

  }

  /**
   * Test method for canKill() method.
   */
  @Test
  public void testCanKill() {

    // white pawn test
    assertTrue(piece3.canKill(new Pawn(6, 5, Color.BLACK)));
    assertTrue(piece3.canKill(new Bishop(6, 3, Color.BLACK)));
    assertFalse(piece3.canKill(new King(6, 4, Color.BLACK)));
    assertFalse(piece3.canKill(new Knight(4, 3, Color.BLACK)));
    assertFalse(piece3.canKill(new Queen(4, 4, Color.BLACK)));
    assertFalse(piece3.canKill(new Rook(4, 5, Color.BLACK)));
    assertFalse(piece3.canKill(new Pawn(5, 3, Color.BLACK)));
    assertFalse(piece3.canKill(new Pawn(5, 4, Color.BLACK))); //self.position
    assertFalse(piece3.canKill(new Rook(5, 5, Color.BLACK)));
    // eligible position, but same color
    assertFalse(piece3.canKill(new Queen(6, 5, Color.WHITE)));
    assertFalse(piece3.canKill(new King(6, 3, Color.WHITE)));


    // black pawn test
    assertTrue(piece4.canKill(new Pawn(1, 5, Color.WHITE)));
    assertTrue(piece4.canKill(new Bishop(1, 3, Color.WHITE)));
    assertFalse(piece4.canKill(new King(1, 4, Color.WHITE)));
    assertFalse(piece4.canKill(new Knight(3, 3, Color.WHITE)));
    assertFalse(piece4.canKill(new Queen(3, 4, Color.WHITE)));
    assertFalse(piece4.canKill(new Rook(3, 5, Color.WHITE)));
    assertFalse(piece4.canKill(new Pawn(2, 3, Color.WHITE)));
    assertFalse(piece4.canKill(new Rook(2, 4, Color.WHITE))); //self.position
    assertFalse(piece4.canKill(new Rook(2, 5, Color.WHITE)));

    // eligible position, but same color
    assertFalse(piece4.canKill(new Pawn(1, 5, Color.BLACK)));
    assertFalse(piece4.canKill(new Pawn(1, 3, Color.BLACK)));
  }


  /*
  @Test
  public void testIsOnPawnRow() {

    assertTrue(piece1.isOnPawnRow());
    assertTrue(piece2.isOnPawnRow());

    assertFalse(piece3.isOnPawnRow());
    assertFalse(piece4.isOnPawnRow());
  }

   */

}