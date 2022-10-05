package chess;

/**
 * The Knight concrete class.
 */
public class Knight extends AbstractChessPiece {

  /**
   * Instantiates a new Knight piece.
   *
   * @param row   the row
   * @param col   the column
   * @param color the color
   * @throws IllegalArgumentException the illegal argument exception
   */

  public Knight(int row, int col, Color color) throws IllegalArgumentException {
    super(row, col, color);
  }

  @Override
  public boolean canMove(int row, int col) throws IllegalArgumentException {

    final int ONE_STEP = 1;
    final int TWO_STEP = 2;

    if (super.canMove(row, col)) {
      double horMove = Math.abs(col - this.col);
      double verMove = Math.abs(row - this.row);
      return ((horMove == ONE_STEP && verMove == TWO_STEP) ||
                                      (horMove == TWO_STEP && verMove == ONE_STEP));
    }
    return false;
  }
}
