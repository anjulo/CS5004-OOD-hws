package chess;

public class King extends AbstractChessPiece{

  public King(int row, int col, Color color) throws IllegalArgumentException {
    super(row, col, color);
  }

  public boolean canMove(int row, int col) throws IllegalArgumentException {
    super.checkBound(row, col);

    final double oneSpaceHorVer = 1.00;
    final double oneSpaceDiag = 1.414; // sqrt(1^2 + 1^2)
    final double EPSILON = 0.01;

    double distanceMove = Math.sqrt(Math.pow(row - this.row, 2) + Math.pow(col - this.col, 2));
    return (isOnHorOrVerLine(row, col) && Math.abs(distanceMove - oneSpaceHorVer) < EPSILON) ||
            (isOnDiagonalLine(row, col) && Math.abs(distanceMove - oneSpaceDiag) < EPSILON);
  }
}
