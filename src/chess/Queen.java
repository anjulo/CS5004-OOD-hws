package chess;

/**
 * The Queen concrete class.
 */
public class Queen extends AbstractChessPiece {

  private final double EPSILON = 0.01;

  /**
   * Instantiates a new Queen piece.
   *
   * @param row   the row
   * @param col   the column
   * @param color the color
   * @throws IllegalArgumentException the illegal argument exception
   */

  public Queen(int row, int col, Color color) throws IllegalArgumentException {
    super(row, col, color);
  }

  @Override
  public boolean canMove(int row, int col) throws IllegalArgumentException {
    super.checkBound(row, col);
    if (super.canMove(row, col)) {
      return (super.isOnHorOrVerLine(row, col) || super.isOnDiagonalLine(row, col));
    }
    return false;
  }
}
