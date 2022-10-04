package chess;

/**
 * The Abstract class for chess pieces.
 */
public abstract class AbstractChessPiece implements ChessPiece {
  /**
   * The piece's Row.
   */
  protected int row;
  /**
   * The piece's Column.
   */
  protected int col;
  /**
   * The piece's Color.
   */
  protected Color color;

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
    if (color != Color.BLACK && color != Color.WHITE) {
      throw new IllegalArgumentException("Chess Piece color can't only be black or white!");
    }

    // Do i need to do more excetion checks?

    this.row = row;
    this.col = col;
    this.color = color;
  }

  public int getRow() {
    return this.row;
  }

  public int getColumn() {
    return this.col;
  }

  public Color getColor() {
    return this.color;
  }

  public boolean canMove(int row, int col){
    return (row != this.row || col != this.col);
  }
  public boolean canKill(ChessPiece piece) {
    checkBound(piece.getRow(), piece.getColumn());
    return (this.canMove(piece.getRow(), piece.getColumn()) && (this.color != piece.getColor()));
  }

  /**
   * Check bound.
   *
   * @param row the row
   * @param col the col
   * @throws IllegalArgumentException the illegal argument exception
   */
  public void checkBound(int row, int col) throws IllegalArgumentException {

    final int MINIMUM_DIMENSION = 0;
    final int MAXIMUM_DIMENSION = 7;

    if (row < MINIMUM_DIMENSION  || row > MAXIMUM_DIMENSION) {
      throw new IllegalArgumentException("Row number is out of bound!");
    } else if (col < MINIMUM_DIMENSION || col > MAXIMUM_DIMENSION) {
      throw new IllegalArgumentException("Column number is out of bound!");
    }
  }

  /**
   * Is on hor or ver line boolean.
   *
   * @param row the row
   * @param col the col
   * @return the boolean
   */
  public boolean isOnHorOrVerLine(int row, int col) {
    return (row == this.row || col == this.col);
  }

  /**
   * Is on diagonal line boolean.
   *
   * @param row the row
   * @param col the col
   * @return the boolean
   */
  public boolean isOnDiagonalLine(int row, int col) {
    return ((row - this.row) == (col - this.col));
  }
}
