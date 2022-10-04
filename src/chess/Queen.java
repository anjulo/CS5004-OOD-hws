package chess;

public class Queen extends AbstractChessPiece{

  private final double EPSILON = 0.01;
  public Queen(int row, int col, Color color) throws IllegalArgumentException {
    super(row, col, color);
  }

  public boolean canMove(int row, int col) throws IllegalArgumentException {
    super.checkBound(row, col);
    return (super.isOnHorOrVerLine(row, col) || super.isOnDiagonalLine(row, col));
  }
}
