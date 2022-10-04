package chess;

/**
 * The Rook concrete class.
 */
public class Rook extends AbstractChessPiece {

  /**
   * Instantiates a new Rook piece.
   *
   * @param row   the row
   * @param col   the col
   * @param color the color
   * @throws IllegalArgumentException the illegal argument exception
   */
  public Rook(int row, int col, Color color) throws IllegalArgumentException {
    super(row, col, color);
  }

  public boolean canMove(int row, int col) throws IllegalArgumentException {
    super.checkBound(row, col);
    return isOnDiagonalLine(row, col);
  }
}
