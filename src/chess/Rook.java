package chess;

public class Rook extends AbstractChessPiece {

  public Rook(int row, int col, Color color) throws IllegalArgumentException {
    super(row, col, color);
  }

  public boolean canMove(int row, int col) throws IllegalArgumentException {
    super.checkBound(row, col);
    return isOnDiagonalLine(row, col);
  }
}
