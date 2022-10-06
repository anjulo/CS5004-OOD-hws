package chess;

/**
 * The interface for Chess piece.
 */
public interface ChessPiece {

  /**
   * Getter for the row number.
   *
   * @return row number
   */
  int getRow();

  /**
   * Getter for the column number.
   *
   * @return column number
   */
  int getColumn();

  /**
   * Getter for the color.
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
