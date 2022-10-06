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

    final int WHITE_ROYAL_ROW = 0;
    final int BLACK_ROYAL_ROW = 7;

    if ((color == Color.WHITE && row == WHITE_ROYAL_ROW)
                  || (color == Color.BLACK && row == BLACK_ROYAL_ROW)) {
      throw new IllegalArgumentException("No pawns may be created in the 'royal' row for"
                                                                        + "their color");
    }
  }

  @Override
  public boolean canMove(int row, int col) throws IllegalArgumentException {

    final int TWO_STEP = 2;
    final int ONE_STEP = 1;
    if (super.canMove(row, col)) {
      if (col == this.getColumn()) {
        if (this.isOnPawnRow()) { // first move
          if (this.getColor() == Color.WHITE) { // White
            return (((row - this.getRow()) == ONE_STEP) || ((row - this.getRow()) == TWO_STEP));
          } else { // Black
            return (((this.getRow() - row) == ONE_STEP) || ((this.getRow() - row) == TWO_STEP));
          }
        } else { // non-first move
          if (this.getColor() == Color.WHITE) { //white
            return ((row - this.getRow()) == ONE_STEP);
          } else { // Black
            return ((this.getRow() - row) == ONE_STEP);
          }
        }
      }
      return false;
    }
    return false;
  }

  @Override
  public boolean canKill(ChessPiece piece) {

    if ((this.getColor() == Color.WHITE) && (piece.getColor() == Color.BLACK)) {
      return (this.isOnDiagonalLine(piece.getRow(), piece.getColumn())
                && (piece.getRow() - this.getRow() == 1));


    } else if ((this.getColor() == Color.BLACK) && (piece.getColor() == Color.WHITE)) {
      return (this.isOnDiagonalLine(piece.getRow(), piece.getColumn())
              && (piece.getRow() - this.getRow() == -1));
    }
    return false;
  }

  /**
   * Checks if a Pawn is on starting position.
   *
   * @return the boolean
   */
  private boolean isOnPawnRow() {
    if (this.getColor() == Color.WHITE) {
      return (this.getRow() == 1);
    } else {
      return (this.getRow() == 6);
    }
  }
}
