package chess;

public interface ChessPiece {

  int getRow();
  int getColumn();
  Color getColor();
  boolean canMove(int row, int col);
  boolean canKill(ChessPiece piece);

}
