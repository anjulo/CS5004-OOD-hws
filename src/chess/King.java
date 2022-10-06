package chess;

/**
 * The King concrete class.
 */
public class King extends AbstractChessPiece {

  /**
   * Instantiates a new King.
   *
   * @param row   the row
   * @param col   the column
   * @param color the color
   * @throws IllegalArgumentException the illegal argument exception
   */
  public King(int row, int col, Color color) throws IllegalArgumentException {
    super(row, col, color);
  }

  @Override
  public boolean canMove(int row, int col) throws IllegalArgumentException {

    // distance constants for one step taken: vertically/horizontally or diagonally
    final double oneStepHorVer = 1.00;
    final double oneStepDiag = 1.414;
    final double EPSILON = 0.01;
    if (super.canMove(row, col)) {

      double distanceMove = Math.sqrt(Math.pow(row - this.getRow(), 2) + Math.pow(col
                                                                          - this.getColumn(), 2));
      return ((isOnHorOrVerLine(row, col) && Math.abs(distanceMove - oneStepHorVer) <= EPSILON)
                || (isOnDiagonalLine(row, col) && Math.abs(distanceMove - oneStepDiag) <= EPSILON));
    }
    return false;
  }
}
