package application;

public class Move {
    private Spot start;
    private Spot end;
    private Piece pieceMoved;
    private Piece pieceKilled;
    private boolean castlingMove = false;

    public Move(Spot start, Spot end) {
        this.start = start;
        this.end = end;
        this.pieceMoved = start.getPiece();
        this.pieceKilled = end.getPiece();
    }

    public Move(Spot start, Spot end, boolean isCastlingMove) {
        this(start, end);
        this.castlingMove = isCastlingMove;
    }

    public Spot getStart() {
        return start;
    }

    public Spot getEnd() {
        return end;
    }

    public Piece getPieceMoved() {
        return pieceMoved;
    }

    public Piece getPieceKilled() {
        return pieceKilled;
    }

    public boolean isCastlingMove() {
        return castlingMove;
    }
}