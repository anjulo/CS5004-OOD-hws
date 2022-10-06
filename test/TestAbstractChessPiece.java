import static org.junit.Assert.assertEquals;

import chess.AbstractChessPiece;
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
 * The test class for abstract class.
 */
public class TestAbstractChessPiece {

  /**
   * The Piece 1.
   */
  AbstractChessPiece piece1;
  /**
   * The Piece 2.
   */
  AbstractChessPiece piece2;
  /**
   * The Piece 3.
   */
  AbstractChessPiece piece3;
  /**
   * The Piece 4.
   */
  AbstractChessPiece piece4;
  /**
   * The Piece 5.
   */
  AbstractChessPiece piece5;
  /**
   * The Piece 6.
   */
  AbstractChessPiece piece6;

  /**
   * Create instances for test purpose.
   *
   * @throws IllegalArgumentException if the position is out of bound.
   */
  @Before
  public void setUp() throws IllegalArgumentException {
    piece1 = new King(5, 2, Color.BLACK);
    piece2 = new Queen(0, 7, Color.BLACK);
    piece3 = new Knight(1, 6, Color.BLACK);
    piece4 = new Rook(3, 5, Color.WHITE);
    piece5 = new Bishop(4, 4, Color.WHITE);
    piece6 = new Pawn(3, 7, Color.WHITE);
  }

  /**
   * Test constructor exceptions.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testConstructorExceptions() {
    piece1 = new King(5, 8, Color.BLACK);
    piece2 = new Queen(8, 2, Color.WHITE);
    piece3 = new King(5, -1, Color.WHITE);
    piece4 = new Queen(-1, 2, Color.BLACK);
  }

  /**
   * Test getter for row number.
   */
  @Test
  public void testGetRow() {
    assertEquals(5, piece1.getRow(), 0.01);
    assertEquals(0, piece2.getRow(), 0.01);
    assertEquals(1, piece3.getRow(), 0.01);
    assertEquals(3, piece4.getRow(), 0.01);
    assertEquals(4, piece5.getRow(), 0.01);
    assertEquals(3, piece6.getRow(), 0.01);

  }

  /**
   * Test getter for column number.
   */
  @Test
  public void testGetColumn() {
    assertEquals(2, piece1.getColumn(), 0.01);
    assertEquals(7, piece2.getColumn(), 0.01);
    assertEquals(6, piece3.getColumn(), 0.01);
    assertEquals(5, piece4.getColumn(), 0.01);
    assertEquals(4, piece5.getColumn(), 0.01);
    assertEquals(7, piece6.getColumn(), 0.01);
  }

  /**
   * Test getter for color.
   */
  @Test
  public void testGetColor() {
    assertEquals(Color.BLACK, piece1.getColor());
    assertEquals(Color.BLACK, piece2.getColor());
    assertEquals(Color.BLACK, piece3.getColor());
    assertEquals(Color.WHITE, piece4.getColor());
    assertEquals(Color.WHITE, piece5.getColor());
    assertEquals(Color.WHITE, piece6.getColor());

  }

  /*
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

   */
}