package application;

public abstract class Player {
    protected String name;
    protected boolean isTurn;

    
    public Player(String name,boolean isTurn)  {
        this.name = name;
        this.isTurn = isTurn;
    }
    public Player(Player player) {
        this.name = player.name;
        this.isTurn = player.isTurn;
    }

    public String getName() {
        return name;
    }

    public boolean isTurn() {
        return isTurn;
    }

    public void setTurn(boolean isTurn) {
        this.isTurn = isTurn;
    }

    public void changeTurn() {
        isTurn = !isTurn;
    }
    public enum PieceColor {
            WHITE,
            BLACK
          }
        
    public abstract PieceColor getPieceColor();
}