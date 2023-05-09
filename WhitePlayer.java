package application;

public class WhitePlayer extends Player {
    private PieceColor pieceColor;

    public WhitePlayer(String name,PieceColor color,
    boolean isTurn) {
        super(name,isTurn);
        pieceColor = color;
    }
    public WhitePlayer(Player player) {
        super(player.name,player.isTurn);
        pieceColor = player.getPieceColor();
    }
    @Override
    public PieceColor getPieceColor() {
        return pieceColor;
    }
}