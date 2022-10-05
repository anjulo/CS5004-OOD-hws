import org.junit.Before;
import org.junit.Test;

import chess.AbstractChessPiece;
import chess.Color;
import chess.King;
import chess.Queen;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestAbstractChessPiece {

  AbstractChessPiece piece1;
  AbstractChessPiece piece2;
  @Before
  public void setUp() throws Exception {

    piece1 = new King(5,2, Color.WHITE);
    piece2 = new Queen(0,7, Color.BLACK);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testConstructorExceptions(){
    piece1 = new King(5,8, Color.BLACK);
    piece2 = new Queen(5, 2, Color.WHITE);
    piece1 = new King(5,-1, Color.BLACK);
    piece2 = new Queen(-1, 2, Color.WHITE);
  }

  @Test
  public void testGetRow() {
    assertEquals(5, piece1.getRow(), 0.01);
    assertEquals(0, piece2.getRow(), 0.01);
  }

  @Test
  public void testGetColumn() {
    assertEquals(2, piece1.getColumn(), 0.01);
    assertEquals(7, piece2.getColumn(), 0.01);
  }

  @Test
  public void testGetColor() {
    assertEquals(Color.WHITE, piece1.getColor());
    assertEquals(Color.BLACK, piece2.getColor());
  }
  @Test
  public void testIsOnHorOrVerLine() {

    assertTrue(piece1.isOnHorOrVerLine(4,2));
    assertTrue(piece1.isOnHorOrVerLine(6,2));
    assertTrue(piece1.isOnHorOrVerLine(5,1));
    assertTrue(piece1.isOnHorOrVerLine(5,3));

    assertFalse(piece1.isOnHorOrVerLine(4,1));
    assertFalse(piece1.isOnHorOrVerLine(6,1));
    assertFalse(piece1.isOnHorOrVerLine(4,3));
    assertFalse(piece1.isOnHorOrVerLine(6,3));
  }

  @Test
  public void testIsOnDiagonalLine() {

    assertTrue(piece1.isOnDiagonalLine(4,1));
    assertTrue(piece1.isOnDiagonalLine(6,1));
    assertTrue(piece1.isOnDiagonalLine(4,3));
    assertTrue(piece1.isOnDiagonalLine(6,3));

    assertFalse(piece1.isOnDiagonalLine(4,2));
    assertFalse(piece1.isOnDiagonalLine(6,2));
    assertFalse(piece1.isOnDiagonalLine(5,1));
    assertFalse(piece1.isOnDiagonalLine(5,3));

  }
}