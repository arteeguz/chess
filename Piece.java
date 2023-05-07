package application;

import java.util.ArrayList;

import application.Player.PieceColor;

public abstract class Piece {
    protected boolean isKilled;
    protected PieceColor color;

    public Piece(PieceColor color) {
        this.color = color;
        this.isKilled = false;
    }

    public abstract ArrayList<Move> legalMoves(ChessBoard board, Spot start);
    public abstract String getName(Piece piece);
    public abstract boolean canMove(ChessBoard board, Spot start, Spot end);

    public PieceColor getColor() {
        return color;
    }

    public void setColor(PieceColor color) {
        this.color = color;
    }

    public boolean isKilled() {
        return isKilled;
    }
    public String getImageName() {
        String colorString = color == PieceColor.WHITE ? "white" : "black";
        return colorString + getClass().getSimpleName().toLowerCase();
    }


    public void setKilled(boolean isKilled) {
        this.isKilled = isKilled;
    }
}
