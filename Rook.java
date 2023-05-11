package application;

import java.util.ArrayList;

import application.Player.PieceColor;

public class Rook extends Piece {

    Rook(PieceColor isWhite) {
        super(isWhite);

    }

    // Returns an ArrayList of all legal moves for the rook
    // at the given start position on the given board
    @Override
    public ArrayList<Move> legalMoves(ChessBoard board, Spot start) {

        // Create an ArrayList to hold the legal moves
        ArrayList<Move> moves = new ArrayList<Move>();

        // Get the row and column of the starting position
        int currentRow = start.getRow();
        int currentCol = start.getColumn();

        // Add all possible moves in the same row
        for (int col = 0; col < 8; col++) {
            if (col != currentCol) {
                // Get the end position of the move
                Spot end = board.getSpot(currentRow, col);
                // Create a Move object representing the move from the start position to the end
                // position
                if (canMove(board, start, end)) {
                Move move = new Move(start, end);
                // Add the move to the list of legal moves
                moves.add(move);
                }
            }
        }

        // Add all possible moves in the same column
        for (int row = 0; row < 8; row++) {
            if (row != currentRow) {
                Spot end = board.getSpot(row, currentCol);
                if (canMove(board, start, end)) {
                Move move = new Move(start, end);
                moves.add(move);
                }
            }
        }
        // Return the list of legal moves
        return moves;
    }

    // Returns true if the rook at the given start position can legally move to the
    // given end position on the given board
    @Override
    public boolean canMove(ChessBoard board, Spot start, Spot end) {
        // Check if the end spot is occupied by a piece of the same color as the rook
        if (end.isSpotOccupied() && end.getPiece().getColor() == getColor()) {
            return false;
        }
        // Get the row and column of the starting and ending positions
        int startRow = start.getRow();
        int startCol = start.getColumn();
        int endRow = end.getRow();
        int endCol = end.getColumn();

        // Check if the end spot is in the same row or column as the start spot
        if (startRow == endRow) {
            // Check if there are any pieces in the way of the horizontal move
            int minCol = Math.min(startCol, endCol);
            int maxCol = Math.max(startCol, endCol);
            for (int col = minCol + 1; col < maxCol; col++) {
                // Get the spot at the current position in the row
                Spot currenSpot = board.getSpot(startRow, col);
                // Check if the spot is occupied by a piece of the same color as the rook
                if (currenSpot.isSpotOccupied()) {
                    return false;
                }
            }
            // There are no pieces blocking the rook's path
            return true;
        } else if (startCol == endCol) {
            // Check if there are any pieces in the way of the vertical move
            int minRow = Math.min(startRow, endRow);
            int maxRow = Math.max(startRow, endRow);
            for (int row = minRow + 1; row < maxRow; row++) {
                Spot currenSpot = board.getSpot(row, startCol);
                if (currenSpot.isSpotOccupied()) {
                    return false;
                }
            }
            return true;
        } else {
            // The end spot is neither in the same row nor column as the start spot
            return false;
        }
    }

}
