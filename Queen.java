package application;

import java.util.ArrayList;

import javafx.scene.image.Image;

public class Queen extends Piece {

	Queen(Boolean isKilled, Boolean whitePiece) {
		super(isKilled, whitePiece);
		// TODO Auto-generated constructor stub
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
		return color +"Queen";
	}

	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return null;
	}
}