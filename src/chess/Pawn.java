package chess;

public class Pawn extends AbstractChessPiece{
  public Pawn(int row, int col, Color color) throws IllegalArgumentException {

    super(row, col, color);

    if ((color == Color.BLACK && row == 0) || (color == Color.WHITE && row == 7)){
      throw new IllegalArgumentException("No pawns may be created in the 'royal' row for" +
                                                                              "their color");
    }
  }

   boolean firstMoveFlag = true;
  public boolean canMove(int row, int col) throws IllegalArgumentException {
    super.checkBound(row, col);

    final int FIRST_MOVE_STEP = 2;
    final int NORMAL_STEP = 1;
    if (col == this.col){
      if (firstMoveFlag){

        firstMoveFlag = false;
        if (this.color == Color.WHITE){
          return (((row - this.row) >= 0) && ((row - this.row) <= FIRST_MOVE_STEP));
        }
        else {
          return (((this.row - row) >= 0) && ((this.row - row) <= FIRST_MOVE_STEP));
        }
      }
      else { // not first move
        if (this.color == Color.WHITE){
          return (((row - this.row) >= 0) && ((row - this.row) <= NORMAL_STEP));
        }
        else {
          return (((this.row - row) >= 0) && ((this.row - row) <= NORMAL_STEP));
        }
      }
    }
    return false;
  }

  @Override
  public boolean canKill(ChessPiece piece) {
    return (this.canMove(piece.getRow(), this.getColumn()) &&
                                      this.isOnDiagonalLine(piece.getRow(), this.getColumn()));
  }
}
