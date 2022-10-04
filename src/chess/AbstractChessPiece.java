package chess;

public abstract class AbstractChessPiece implements ChessPiece {
  protected int row;
  protected int col;
  protected Color color;

  public AbstractChessPiece(int row, int col, Color color) throws IllegalArgumentException {

    this.checkBound(row, col);
    if (color != Color.BLACK && color != Color.WHITE){
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

  public void checkBound(int row, int col) throws IllegalArgumentException {

    final int MINIMUM_DIMENTION = 0;
    final int MAXIMUM_DIMENTION = 7;

    if(row < MINIMUM_DIMENTION  || row > MAXIMUM_DIMENTION) {
      throw new IllegalArgumentException("Row number is out of bound!");
    }
    else if (col < MINIMUM_DIMENTION || col > MAXIMUM_DIMENTION){
      throw new IllegalArgumentException("Column number is out of bound!");
    }
  }

  public boolean onHorzOrVerLine(int row, int col){
    return (row == this.row || col == this.col);
  }
  public boolean onDiagonalLine(int row, int col){
    return ((row - this.row) == (col - this.col));
  }
}
