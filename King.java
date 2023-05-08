package application;

import java.util.ArrayList;

import application.Player.PieceColor;

public class King extends Piece {



	King(PieceColor isWhite) {
		super(isWhite);
	}

	@Override
	public ArrayList<Move> legalMoves(ChessBoard board, Spot start) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canMove(ChessBoard board, Spot start, Spot end) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'canMove'");
	}


}