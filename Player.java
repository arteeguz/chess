package application;

public class Player {
    private String name;
    private PieceColor pieceColor;

    public Player(String name, PieceColor pieceColor) {
        this.name = name;
        this.pieceColor = pieceColor;
    }
    
    public enum PieceColor {
        WHITE,
        BLACK
    }


    public String getName() {
        return name;
    }

    public PieceColor getPieceColor() {
        return pieceColor;
    }

    public boolean isWhite() {
        return pieceColor == PieceColor.WHITE;
    }

    public boolean isBlack() {
        return pieceColor == PieceColor.BLACK;
    }
}