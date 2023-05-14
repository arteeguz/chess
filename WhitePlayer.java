package application;

/**
 * 
 * the WhitePlayer class represents a player with white pieces in a game of
 * chess.
 * 
 * it implements the Player interface.
 */
public class WhitePlayer implements Player {
    protected String name; // the name of the player
    protected boolean isTurn; // whether or not it is currently the player's turn

    /**
     * 
     * Constructs a new WhitePlayer with the specified name and turn status.
     * 
     * @param name   the name of the player
     * @param isTurn whether or not it is currently the player's turn
     */
    public WhitePlayer(String name, boolean isTurn) {
        this.name = name;
        this.isTurn = isTurn;
    }

    /**
     * @return the name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * @return true if it is currently the player's turn, false otherwise
     */
    public boolean isTurn() {
        return isTurn;
    }

    /**
     * 
     * Sets the turn status of the player.
     * 
     * @param isTurn true if it is currently the player's turn, false otherwise
     */
    public void setTurn(boolean isTurn) {
        this.isTurn = isTurn;
    }

    /**
     * 
     * Changes the turn status of the player.
     */
    public void changeTurn() {
        isTurn = !isTurn;
    }

    /**
     * 
     * Gets the color of the pieces the player is using.
     * 
     * @return the PieceColor.WHITE enum value representing white pieces
     */
    public PieceColor getPieceColor() {
        return PieceColor.WHITE;
    }
}