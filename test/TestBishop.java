import org.junit.Before;
import org.junit.Test;

import chess.*;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class TestBishop {

  Bishop piece1;
  Bishop piece2;

  @Before
  public void setUp() throws Exception {

    piece1 = new Bishop(1,2, Color.WHITE);
    piece2 = new Bishop(6,2, Color.BLACK);
  }

  @Test
  public void testCanMove() {
    assertTrue(piece1.canMove(0,1));
    assertTrue(piece1.canMove(2,1));
    assertTrue(piece1.canMove(0,3));
    assertTrue(piece1.canMove(2,3));

    assertFalse(piece1.canMove(0,2));
    assertFalse(piece1.canMove(2,2));
    assertFalse(piece1.canMove(1,1));
    assertFalse(piece1.canMove(1,3));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testCanMoveException(){
    assertFalse(piece1.canMove(-1,2));
    assertFalse(piece1.canMove(6,-1));
    assertFalse(piece1.canMove(8,2));
    assertFalse(piece1.canMove(6,8));
  }

  @Test
  public void testCanKill() {

    assertTrue(piece1.canKill(new Bishop(0,1, Color.BLACK)));
    assertTrue(piece1.canKill(new Pawn(2,1, Color.BLACK)));
    assertTrue(piece1.canKill(new King(0,3, Color.BLACK)));
    assertTrue(piece1.canKill(new Queen(2,3, Color.BLACK)));
    assertTrue(piece2.canKill(new Knight(5,1, Color.WHITE)));
    assertTrue(piece2.canKill(new Rook(7,3, Color.WHITE)));

    assertFalse(piece1.canKill(new Bishop(0,2, Color.BLACK)));
    assertFalse(piece1.canKill(new Pawn(2,2, Color.BLACK)));
    assertFalse(piece1.canKill(new King(1,1, Color.BLACK)));
    assertFalse(piece1.canKill(new Queen(1,3, Color.BLACK)));
    assertFalse(piece2.canKill(new Knight(5,2, Color.WHITE)));
    assertFalse(piece2.canKill(new Rook(7,2, Color.WHITE)));

    //same color
    assertFalse(piece1.canKill(new Bishop(0,1, Color.WHITE)));
    assertFalse(piece1.canKill(new Pawn(2,1, Color.WHITE)));
    assertFalse(piece2.canKill(new Knight(5,1, Color.BLACK)));
    assertFalse(piece2.canKill(new Rook(7,3, Color.BLACK)));

  }

}