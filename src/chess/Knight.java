package chess;

public class Knight extends AbstractChessPiece {

  public Knight(int row, int col, Color color) throws IllegalArgumentException {
    super(row, col, color);
  }

  public boolean canMove(int row, int col) throws IllegalArgumentException{

    super.checkBound(row, col);
    final int HOR_MOVE = 2;
    final int VER_MOVE = 1;
    double horMove = col - this.col;
    double verMove = row - this.row;

    return (horMove == HOR_MOVE && verMove == VER_MOVE) ;
  }
}
