package application;

public class BlackPlayer extends Player {

    private PieceColor pieceColor;

    public BlackPlayer(String name,PieceColor color,
    boolean isTurn) {
            super(name,isTurn);
            pieceColor = color;
        }
        public BlackPlayer(Player player) {
            super(player.name,player.isTurn);
            pieceColor = player.getPieceColor();
        }
    
    @Override
    public PieceColor getPieceColor() {
        return pieceColor;
    }
}