import org.junit.Before;
import org.junit.Test;

import chess.*;

import static org.junit.Assert.*;

public class TestQueen {

  Queen piece1;
  @Before
  public void setUp() throws Exception {
    piece1 = new Queen(5,2, Color.BLACK);
  }

  @Test
  public void canMove() {

    assertTrue(piece1.canMove(5,0));
    assertTrue(piece1.canMove(5,1));
    assertTrue(piece1.canMove(5,3));
    assertTrue(piece1.canMove(5,4));

    assertTrue(piece1.canMove(4,1));
    assertTrue(piece1.canMove(4,2));
    assertTrue(piece1.canMove(4,3));

    assertTrue(piece1.canMove(6,1));
    assertTrue(piece1.canMove(6,2));
    assertTrue(piece1.canMove(6,3));

    assertTrue(piece1.canMove(3,0));
    assertTrue(piece1.canMove(3,2));
    assertTrue(piece1.canMove(3,4));

    assertTrue(piece1.canMove(7,0));
    assertTrue(piece1.canMove(7,2));
    assertTrue(piece1.canMove(7,4));

    assertFalse(piece1.canMove(5,2));
    assertFalse(piece1.canMove(3,1));
    assertFalse(piece1.canMove(3,3));
    assertFalse(piece1.canMove(7,1));
    assertFalse(piece1.canMove(7,3));

    assertFalse(piece1.canMove(4,0));
    assertFalse(piece1.canMove(4,4));
    assertFalse(piece1.canMove(6,0));
    assertFalse(piece1.canMove(6,4));
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

    assertTrue(piece1.canKill(new Bishop(5, 0, Color.WHITE)));
    assertTrue(piece1.canKill(new Knight(5, 1, Color.WHITE)));
    assertTrue(piece1.canKill(new Pawn(5, 3, Color.WHITE)));
    assertTrue(piece1.canKill(new Queen(5, 4, Color.WHITE)));
    assertTrue(piece1.canKill(new Rook(4, 1, Color.WHITE)));
    assertTrue(piece1.canKill(new King(4, 2, Color.WHITE)));
    assertTrue(piece1.canKill(new Knight(4, 3, Color.WHITE)));

    assertTrue(piece1.canKill(new King(6, 1, Color.WHITE)));
    assertTrue(piece1.canKill(new Bishop(6, 2, Color.WHITE)));
    assertTrue(piece1.canKill(new Knight(6, 3, Color.WHITE)));
    assertTrue(piece1.canKill(new Pawn(3, 0, Color.WHITE)));
    assertTrue(piece1.canKill(new Queen(3, 2, Color.WHITE)));
    assertTrue(piece1.canKill(new Rook(3, 4, Color.WHITE)));
    assertTrue(piece1.canKill(new King(7, 0, Color.WHITE)));
    assertTrue(piece1.canKill(new Knight(7, 2, Color.WHITE)));
    assertTrue(piece1.canKill(new King(7, 4, Color.WHITE)));

    assertFalse(piece1.canKill(new Bishop(5, 0, Color.BLACK)));
    assertFalse(piece1.canKill(new Knight(5, 1, Color.BLACK)));
    assertFalse(piece1.canKill(new Pawn(5, 3, Color.BLACK)));
    assertFalse(piece1.canKill(new Queen(5, 4, Color.BLACK)));
    assertFalse(piece1.canKill(new Rook(4, 1, Color.BLACK)));
    assertFalse(piece1.canKill(new King(4, 2, Color.BLACK)));
    assertFalse(piece1.canKill(new Knight(4, 3, Color.BLACK)));
  }
}