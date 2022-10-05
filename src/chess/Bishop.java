package chess;

/**
 * The Bishop concrete class.
 */
public class Bishop extends AbstractChessPiece {

  /**
   * Instantiates a new Bishop piece.
   *
   * @param row   the row
   * @param col   the column
   * @param color the color
   * @throws IllegalArgumentException the illegal argument exception
   */
  public Bishop(int row, int col, Color color) throws IllegalArgumentException {
    super(row, col, color);
  }

  @Override
  public boolean canMove(int row, int col) throws IllegalArgumentException {
    if (super.canMove(row, col)) {
      return (super.isOnDiagonalLine(row, col));
    }
    return false;
  }
}
