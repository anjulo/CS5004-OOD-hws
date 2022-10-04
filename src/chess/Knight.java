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
    super.checkBound(row, col);

    final int HOR_MOVE = 2;
    final int VER_MOVE = 1;
    if (super.canMove(row, col)) {
      double horMove = col - this.col;
      double verMove = row - this.row;
      return (horMove == HOR_MOVE && verMove == VER_MOVE);
    }
    return false;
  }
}
