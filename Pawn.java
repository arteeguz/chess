package application;

import java.util.ArrayList;

import javafx.scene.image.Image;

public class Pawn extends Piece {
    private static final String BLACK_IMAGE_PATH = "blackPawn.png";
    private static final String WHITE_IMAGE_PATH = "whitePawn.png";

    Pawn(Boolean isKilled, Boolean whitePiece) {
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
        return color +"Pawn";
    }
    
    @Override
    public Image getImage() {
        String imagePath = whitePiece ? WHITE_IMAGE_PATH : BLACK_IMAGE_PATH;
        return new Image(imagePath);
    }
}
