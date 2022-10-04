package chess;

public class Bishop extends AbstractChessPiece {

  public Bishop(int row, int col, Color color) throws IllegalArgumentException {
    super(row, col, color);
  }

  public boolean canMove(int row, int col) throws IllegalArgumentException {
    super.checkBound(row, col);
    return (super.isOnDiagonalLine(row,col));
  }

  public boolean canKill(ChessPiece piece) {
    return false;
  }
}
