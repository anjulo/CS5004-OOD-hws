import org.junit.Before;
import org.junit.Test;

import chess.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * The type Test knight.
 */
public class TestKnight {

  /**
   * The Piece 1.
   */
  Knight piece1;
  Knight piece2;
  Knight piece3;


  /**
   * Sets up.
   *
   * @throws Exception the exception
   */
  @Before
  public void setUp() throws Exception {
    piece1 = new Knight(5,2, Color.WHITE);
  }

  /**
   * Can move.
   */
  @Test
  public void testCanMove() {
    assertTrue(piece1.canMove(3,1));
    assertTrue(piece1.canMove(3,3));
    assertTrue(piece1.canMove(4,0));
    assertTrue(piece1.canMove(4,4));
    assertTrue(piece1.canMove(6,0));
    assertTrue(piece1.canMove(6,4));
    assertTrue(piece1.canMove(7,1));
    assertTrue(piece1.canMove(7,3));

    assertFalse(piece1.canMove(5,1));
    assertFalse(piece1.canMove(5,2));
    assertFalse(piece1.canMove(5,3));
    assertFalse(piece1.canMove(4,1));
    assertFalse(piece1.canMove(4,2));
    assertFalse(piece1.canMove(4,3));
    assertFalse(piece1.canMove(6,1));
    assertFalse(piece1.canMove(6,2));
    assertFalse(piece1.canMove(6,3));

    assertFalse(piece1.canMove(5,0));
    assertFalse(piece1.canMove(5,4));

    assertFalse(piece1.canMove(3,2));
    assertFalse(piece1.canMove(7,2));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testCanMoveException(){
    assertFalse(piece1.canMove(-1,2));
    assertFalse(piece1.canMove(5,-1));
    assertFalse(piece1.canMove(8,2));
    assertFalse(piece1.canMove(5,8));
  }

  @Test
  public void testCanKill(){
    assertTrue(piece1.canKill(new Knight(3,1, Color.BLACK)));
    assertTrue(piece1.canKill(new Bishop(3,3, Color.BLACK)));
    assertTrue(piece1.canKill(new King(4,0, Color.BLACK)));
    assertTrue(piece1.canKill(new Pawn(4,4, Color.BLACK)));
    assertTrue(piece1.canKill(new Queen(6,0, Color.BLACK)));
    assertTrue(piece1.canKill(new Rook(6,4, Color.BLACK)));
    assertTrue(piece1.canKill(new Knight(7,1, Color.BLACK)));
    assertTrue(piece1.canKill(new Rook(7,3, Color.BLACK)));

    assertTrue(piece1.canKill(new Knight(5,1, Color.BLACK)));
    assertTrue(piece1.canKill(new Bishop(5,2, Color.BLACK)));
    assertTrue(piece1.canKill(new King(5,3, Color.BLACK)));
    assertTrue(piece1.canKill(new Pawn(4,1, Color.BLACK)));
    assertTrue(piece1.canKill(new Queen(4,2, Color.BLACK)));
    assertTrue(piece1.canKill(new Rook(4,3, Color.BLACK)));
    assertTrue(piece1.canKill(new Knight(6,1, Color.BLACK)));
    assertTrue(piece1.canKill(new Rook(6,2, Color.BLACK)));
    assertTrue(piece1.canKill(new Rook(6,3, Color.BLACK)));

    assertFalse(piece1.canKill(new Knight(3,1, Color.WHITE)));
    assertFalse(piece1.canKill(new Bishop(3,3, Color.WHITE)));
    assertFalse(piece1.canKill(new King(4,0, Color.WHITE)));
    assertFalse(piece1.canKill(new Pawn(4,4, Color.WHITE)));
    assertFalse(piece1.canKill(new Queen(6,0, Color.WHITE)));
    assertFalse(piece1.canKill(new Rook(6,4, Color.WHITE)));
    assertFalse(piece1.canKill(new Knight(7,1, Color.WHITE)));
    assertFalse(piece1.canKill(new Rook(7,3, Color.WHITE)));
  }
}