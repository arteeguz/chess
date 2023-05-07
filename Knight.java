package application;

import java.util.ArrayList;

import application.Player.PieceColor;

public class Knight extends Piece {

	public Knight(boolean isWhite) {
	    super(isWhite ? PieceColor.WHITE : PieceColor.BLACK);
	}
	
	@Override
	public ArrayList<Move> legalMoves(ChessBoard board, Spot start) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getName(Piece piece) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canMove(ChessBoard board, Spot start, Spot end) {
		// TODO Auto-generated method stub
		return false;
	}
}