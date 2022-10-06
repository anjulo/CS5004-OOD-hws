package chess;

/**
 * The Abstract class for chess pieces.
 */
public abstract class AbstractChessPiece implements ChessPiece {
  /**
   * The piece's Row.
   */
  private int row;
  /**
   * The piece's Column.
   */
  private int col;
  /**
   * The piece's Color.
   */
  private Color color;

  /**
   * Instantiates a new abstract chess piece.
   *
   * @param row   the row
   * @param col   the column
   * @param color the color
   * @throws IllegalArgumentException the illegal argument exception
   */
  public AbstractChessPiece(int row, int col, Color color) throws IllegalArgumentException {

    this.checkBound(row, col);
    this.row = row;
    this.col = col;
    this.color = color;
  }

  /**
   * Getter for the row number.
   *
   * @return row number
   */
  public int getRow() {
    return this.row;
  }

  /**
   * Getter for the column number.
   *
   * @return column number
   */
  public int getColumn() {
    return this.col;
  }

  /**
   * Getter for the color.
   *
   * @return color
   */
  public Color getColor() {
    return this.color;
  }

  /**
   * Tells us if a piece can move to a specific position on the board.
   *
   * @param row row number
   * @param col col number
   * @return the boolean
   */
  public boolean canMove(int row, int col) throws IllegalArgumentException {
    this.checkBound(row, col);
    return ((row != this.row || col != this.col));
  }

  /**
   * Tells us if a piece can kill another piece if its position is given.
   *
   * @param piece the piece to be killed
   * @return the boolean
   */
  public boolean canKill(ChessPiece piece) {
    return ((this.color != piece.getColor()) && this.canMove(piece.getRow(), piece.getColumn()));
  }

  /**
   * Check bound.
   *
   * @param row the row
   * @param col the col
   * @throws IllegalArgumentException the illegal argument exception
   */
  private void checkBound(int row, int col) throws IllegalArgumentException {

    final int MINIMUM_DIMENSION = 0;
    final int MAXIMUM_DIMENSION = 7;

    if (row < MINIMUM_DIMENSION  || row > MAXIMUM_DIMENSION) {
      throw new IllegalArgumentException("Row number is out of bound!");
    } else if (col < MINIMUM_DIMENSION || col > MAXIMUM_DIMENSION) {
      throw new IllegalArgumentException("Column number is out of bound!");
    }
  }

  /**
   * Tells us if the (row, col) point is on horizontal or vertical line relative to the
   * position of the piece.
   *
   * @param row the row
   * @param col the col
   * @return boolean
   */
  protected boolean isOnHorOrVerLine(int row, int col) {
    return (row == this.row || col == this.col);
  }

  /**
   * Tells us if the (row, col) point is on diagonal line relative to the position of the piece.
   *
   * @param row the row
   * @param col the col
   * @return the boolean
   */
  protected boolean isOnDiagonalLine(int row, int col) {
    return (Math.abs(row - this.row) == Math.abs(col - this.col));
  }
}
