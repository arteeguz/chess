package application;

import java.util.ArrayList;

import application.Player.PieceColor;

public class King extends Piece {

    public King(PieceColor isWhite) {
        super(isWhite);
    }

    @Override
    public ArrayList<Move> legalMoves(ChessBoard board, Spot start) {
        ArrayList<Move> moves = new ArrayList<>();
        int startRow = start.getRow();
        int startCol = start.getColumn();

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue; // Skip the king's current spot
                }

                int newRow = startRow + i;
                int newCol = startCol + j;
                Spot end = board.getSpot(newRow, newCol);

                if (end != null && (!end.isSpotOccupied() || end.getPiece().getColor() != getColor())) {
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

        // Check if the end spot is adjacent to the start spot
        return rowDiff <= 1 && colDiff <= 1;
    }
}
