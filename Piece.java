package application;

import java.util.ArrayList;

import javafx.scene.image.Image;

//Determine whether or not the Piece class should include the position of each Piece or
//The tile class can determine that
public abstract class Piece {
	
	protected Boolean isKilled;
	protected Boolean whitePiece;
	Piece(){
		isKilled = false;
		whitePiece = true;
	}
	Piece(Boolean isKilled, Boolean whitePiece) {
		this.isKilled = isKilled;
		this.whitePiece = whitePiece;
	}
	
	public abstract ArrayList<Move> legalMoves(ChessBoard board, Spot start);
	public abstract String getName(Piece piece);
    public abstract Image getImage();

	//if the piece is White false is returned and true is returned for a Black piece
	public Boolean getwhitePiece() {
		return whitePiece;
	}

	//sets the piece color to either White(false) or Black(true)
	public void setWhitePiece(Boolean isWhite) {
		this.whitePiece = isWhite;
	}

	public Boolean getIsKilled() {
		return isKilled;
	}

	public void setIsKilled(Boolean isKilled) {
		this.isKilled = isKilled;
	}


}