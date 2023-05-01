package application;

import java.util.ArrayList;

import javafx.scene.image.Image;

public class Knight extends Piece {

	Knight(Boolean isKilled, Boolean whitePiece) {
		super(isKilled, whitePiece);
		
	}
	
	@Override
	public ArrayList<Move> legalMoves(ChessBoard board, Spot start) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getName(Piece piece) {
		String color;
		if(piece.getwhitePiece()){
			color = "white";
		}else{
			color="black";
		}
		return color +"Knight";
	}

	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return null;
	}
}