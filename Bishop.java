package application;

import java.util.ArrayList;

import application.Player.PieceColor;

public class Bishop extends Piece {

    public Bishop(PieceColor isWhite) {
        super(isWhite);
    }

    @Override
    public ArrayList<Move> legalMoves(ChessBoard board, Spot start) {
        ArrayList<Move> moves = new ArrayList<>();
        int startRow = start.getRow();
        int startCol = start.getColumn();

        for (int i = -1; i <= 1; i += 2) {
            for (int j = -1; j <= 1; j += 2) {
                int newRow = startRow;
                int newCol = startCol;

                while (true) {
                    newRow += i;
                    newCol += j;
                    Spot end = board.getSpot(newRow, newCol);

                    if (end == null) {
                        break;
                    }

                    if (end.isSpotOccupied()) {
                        if (end.getPiece().getColor() != getColor()) {
                            moves.add(new Move(start, end));
                        }
                        break;
                    }

                    moves.add(new Move(start, end));
                }
            }
        }

        return moves;
    }

    @Override
    public boolean canMove(ChessBoard board, Spot start, Spot end) {
        if (end.isSpotOccupied() && end.getPiece().getColor() == getColor()) {
            return false;
        }

        int startRow = start.getRow();
        int startCol = start.getColumn();
        int endRow = end.getRow();
        int endCol = end.getColumn();

        int rowDiff = Math.abs(startRow - endRow);
        int colDiff = Math.abs(startCol - endCol);

        // Check if the end spot is in the same diagonal as the start spot
        if (rowDiff == colDiff) {
            int rowIncrement = (endRow - startRow) > 0 ? 1 : -1;
            int colIncrement = (endCol - startCol) > 0 ? 1 : -1;

            int currentRow = startRow + rowIncrement;
            int currentCol = startCol + colIncrement;

            while (currentRow != endRow && currentCol != endCol) {
                Spot intermediateSpot = board.getSpot(currentRow, currentCol);
                if (intermediateSpot.isSpotOccupied()) {
                    return false;
                }
                currentRow += rowIncrement;
                currentCol += colIncrement;
            }
            return true;
        }

        return false;
    }
}
