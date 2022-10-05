import org.junit.Before;
import org.junit.Test;

import chess.Color;
import chess.Pawn;

import static org.junit.Assert.*;

public class TestPawn {

  Pawn piece1;
  Pawn piece2;
  Pawn piece3;
  Pawn piece4;

  @Before
  public void setUp() throws Exception {
    piece1 = new Pawn(1,5, Color.WHITE);
    piece2 = new Pawn(6,5, Color.BLACK);
    piece3 = new Pawn(5,4, Color.WHITE);
    piece4 = new Pawn(2,4, Color.BLACK);

  }
  @Test(expected = IllegalArgumentException.class)
  public void testSetUpExceptions(){
    piece1 = new Pawn(0,2, Color.WHITE);
    piece2 = new Pawn(7,2, Color.BLACK);

  }

  @Test
  public void testCanMove() {

    // white pawn at it's game start row
    assertFalse(piece1.canMove(0,5));
    assertFalse(piece1.canMove(1,5));
    assertTrue(piece1.canMove(2,5));
    assertTrue(piece1.canMove(3,5));
    assertFalse(piece1.canMove(4,5));

    assertFalse(piece1.canMove(0,4));
    assertFalse(piece1.canMove(1,4));
    assertFalse(piece1.canMove(2,4));
    assertFalse(piece1.canMove(0,6));
    assertFalse(piece1.canMove(1,6));
    assertFalse(piece1.canMove(2,6));

    // white pawn at non-game-start row
    assertTrue(piece3.canMove(6,4));
    assertFalse(piece3.canMove(7,4));

    // black pawn at it's game start row
    assertFalse(piece2.canMove(7,5));
    assertFalse(piece2.canMove(6,5));
    assertTrue(piece2.canMove(5,5));
    assertTrue(piece2.canMove(4,5));
    assertFalse(piece2.canMove(3,5));

    assertFalse(piece2.canMove(7,4));
    assertFalse(piece2.canMove(6,4));
    assertFalse(piece2.canMove(5,4));

    assertFalse(piece2.canMove(7,6));
    assertFalse(piece2.canMove(6,6));
    assertFalse(piece2.canMove(5,6));

    // black pawn at non-game-start row
    assertTrue(piece4.canMove(1,4));
    assertFalse(piece4.canMove(0,4));



  }

  @Test(expected = IllegalArgumentException.class)
  public void testCanMoveExceptions() {

    // out of bound exception
    piece1.canMove(8,5);
    piece1.canMove(-1,5);
    piece1.canMove(2,8);
    piece1.canMove(2,-1);

    // royal row exception
    piece1.canMove(0,5);
    piece2.canMove(7,5);

  }
  @Test
  public void testCanKill() {

    // white pawn test
    assertTrue(piece3.canKill(new Pawn(6,5, Color.BLACK)));
    assertTrue(piece3.canKill(new Pawn(6, 3, Color.BLACK)));
    assertFalse(piece3.canKill(new Pawn(6, 4, Color.BLACK)));
    assertFalse(piece3.canKill(new Pawn(4, 3, Color.BLACK)));
    assertFalse(piece3.canKill(new Pawn(4, 4, Color.BLACK)));
    assertFalse(piece3.canKill(new Pawn(4, 5, Color.BLACK)));
    assertFalse(piece3.canKill(new Pawn(5, 3, Color.BLACK)));
    assertFalse(piece3.canKill(new Pawn(5, 4, Color.BLACK))); //self.position
    assertFalse(piece3.canKill(new Pawn(5, 5, Color.BLACK)));
    // eligible position, but same color
    assertFalse(piece3.canKill(new Pawn(6,5, Color.WHITE)));
    assertFalse(piece3.canKill(new Pawn(6, 3, Color.WHITE)));


    // black pawn test
    assertTrue(piece4.canKill(new Pawn(1,5, Color.WHITE)));
    assertTrue(piece4.canKill(new Pawn(1, 3, Color.WHITE)));
    assertFalse(piece4.canKill(new Pawn(1, 4, Color.WHITE)));
    assertFalse(piece4.canKill(new Pawn(3, 3, Color.WHITE)));
    assertFalse(piece4.canKill(new Pawn(3, 4, Color.WHITE)));
    assertFalse(piece4.canKill(new Pawn(3, 5, Color.WHITE)));
    assertFalse(piece4.canKill(new Pawn(2, 3, Color.WHITE)));
    assertFalse(piece4.canKill(new Pawn(2, 4, Color.WHITE))); //self.position
    assertFalse(piece4.canKill(new Pawn(2, 5, Color.WHITE)));

    // eligible position, but same color
    assertFalse(piece4.canKill(new Pawn(1,5, Color.BLACK)));
    assertFalse(piece4.canKill(new Pawn(1, 3, Color.BLACK)));
  }

  @Test
  public void testIsOnPawnRow() {

    assertTrue(piece1.isOnPawnRow());
    assertTrue(piece2.isOnPawnRow());

    assertFalse(piece3.isOnPawnRow());
    assertFalse(piece4.isOnPawnRow());
  }

}