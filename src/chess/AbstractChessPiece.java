package chess;

public abstract class AbstractChessPiece implements ChessPiece {
  protected int row;
  protected int column;
  protected Color color;
  private final int MINIMUM_DIMENTION = 0;
  private final int MAXIMUM_DIMENTION = 7;


  public AbstractChessPiece(int row, int column, Color color) throws IllegalArgumentException {
    if (MINIMUM_DIMENTION > row || row > MAXIMUM_DIMENTION || MINIMUM_DIMENTION > column
                                                           || column > MAXIMUM_DIMENTION) {
      throw new IllegalArgumentException("Chess piece position out of bound!");
    }
    this.row = row;
    this.column = column;
    this.color = color;
  }
}
