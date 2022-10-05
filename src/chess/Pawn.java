package chess;

/**
 * The Pawn concrete class.
 */
public class Pawn extends AbstractChessPiece {
  /**
   * Instantiates a new Pawn piece.
   *
   * @param row   the row
   * @param col   the column
   * @param color the color
   * @throws IllegalArgumentException the illegal argument exception
   */
  public Pawn(int row, int col, Color color) throws IllegalArgumentException {

    super(row, col, color);

    if ((color == Color.WHITE && row == 0) || (color == Color.BLACK && row == 7)) {
      throw new IllegalArgumentException("No pawns may be created in the 'royal' row for"
                                                                        + "their color");
    }
  }

  @Override
  public boolean canMove(int row, int col) throws IllegalArgumentException {

    final int FIRST_MOVE_STEP = 2;
    final int NORMAL_STEP = 1;
    if (super.canMove(row, col)) {
      if (col == this.col) {
        if (this.isOnPawnRow()) {
          if (this.color == Color.WHITE) {
            return (((row - this.row) >= 0) && ((row - this.row) <= FIRST_MOVE_STEP));
          } else {
            return (((this.row - row) >= 0) && ((this.row - row) <= FIRST_MOVE_STEP));
          }
        } else { // not first move
          if (this.color == Color.WHITE) {
            return (((row - this.row) >= 0) && ((row - this.row) <= NORMAL_STEP));
          } else {
            return (((this.row - row) >= 0) && ((this.row - row) <= NORMAL_STEP));
          }
        }
      }
    }
    return false;
  }

  @Override
  public boolean canKill(ChessPiece piece) {

    if ((this.getColor() == Color.WHITE) && (piece.getColor() == Color.BLACK)){
      return (this.isOnDiagonalLine(piece.getRow(), piece.getColumn())
                && (piece.getRow() - this.row == 1));


    } else if ((this.getColor() == Color.BLACK) && (piece.getColor() == Color.WHITE)) {
      return (this.isOnDiagonalLine(piece.getRow(), piece.getColumn())
              && (piece.getRow() - this.row == -1));
    }
    return false;
  }

  /**
   * Decides if a Pawn is on the royal row for its color.
   *
   * @return the boolean
   */
  public boolean isOnPawnRow() {
    if (this.getColor() == Color.WHITE) {
      return (this.getRow() == 1);
    } else {
      return (this.getRow() == 6);
    }
  }
}
