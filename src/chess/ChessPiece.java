package chess;

/**
 * The interface for Chess piece.
 */
public interface ChessPiece {

  /**
   * Gets row.
   *
   * @return row number
   */
  int getRow();

  /**
   * Gets column.
   *
   * @return column number
   */
  int getColumn();

  /**
   * Gets color.
   *
   * @return color
   */
  Color getColor();

  /**
   * Tells us if a piece can move to a specific position on the board.
   *
   * @param row row number
   * @param col col number
   * @return the boolean
   */
  boolean canMove(int row, int col);

  /**
   * Tells us if a piece can kill another piece if its position is given.
   *
   * @param piece the piece to be killed
   * @return the boolean
   */
  boolean canKill(ChessPiece piece);

}
