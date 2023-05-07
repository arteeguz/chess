package application;

import java.io.File;

import application.Player.PieceColor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ChessBoard extends GridPane{

    private final int size;
    private final Color lightColor = Color.rgb(255, 206, 158);
    private final Color darkColor = Color.rgb(209, 139, 71);
    boolean bool = false;
    private Spot[][] spots = new Spot[8][8];
    //GridPane grid = new GridPane();
    static final String IMAGE_PATH = "images"; 
    
    
    public Spot getSpot(int row, int col) {
        if (row < 0 || row >= size || col < 0 || col >= size) {
            return null;
        }
        return spots[row][col];
    }
    public void resetHighlights() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                spots[i][j].resetColor();
            }
        }
    }

    public ChessBoard(int size) {
       
        this.size = size;
        
        // Create the squares on the board
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // setting placement and size of the tile
                Rectangle tile = new Rectangle(i * 50, j * 50, 50, 50);
                // alternates the color of the tiles
                tile.setFill((i + j) % 2 == 0 ? lightColor : darkColor);
                Piece piece = null;
               boolean isSpotOccupied = false;
                if (i == 0 || i == 7) {
                    switch (j) {
                        case 0:
                        case 7:
                        if(i < 2 ){
                             bool = false;
                        }else{
                             bool =true;
                        }
                            piece = new Rook(bool);
                            isSpotOccupied = true;
                            break;
                        case 1:
                        case 6:
                        if(i <2 ){
                            bool = false;
                       }else{
                            bool =true;
                       }
                            piece = new Knight(bool);
                            isSpotOccupied = true;
                            break;
                        case 2:
                        case 5:
                        if(i < 2 ){
                            bool = false;
                       }else{
                            bool =true;
                       }
                            piece = new Bishop(bool);
                            isSpotOccupied = true;
                            break;
                        case 3:
                        if(i < 2 ){
                            bool = false;
                       }else{
                            bool =true;
                       }
                            piece = new Queen(bool);
                            isSpotOccupied = true;
                            break;
                        case 4:
                            if( i < 2 ){
                                bool = false;
                            }else{
                            bool =true;
                            }
                            piece = new King(bool);
                            isSpotOccupied = true;
                            break;
                    }
                } else if (i == 1 || i == 6) {
                    if(i < 2){
                        bool = false;
                   }else{
                        bool =true;
                   }
                    piece = new Pawn(bool ? PieceColor.WHITE : PieceColor.BLACK);
                    isSpotOccupied = true;
                }
                Spot spot = new Spot(piece, tile, isSpotOccupied, this);
                spots[i][j] = spot;
                this.add(tile, j, i);
                
                
                
             // Load the chess piece image
                if (piece != null) {
                    String imagePath = IMAGE_PATH + "\\" + piece.getImageName() + ".png";
                    File imageFile = new File(imagePath);
                    if (imageFile.exists()) {
                        Image image = new Image(imageFile.toURI().toString());
                        ImageView imageView = new ImageView(image);
                        imageView.setFitWidth(40);
                        imageView.setFitHeight(40);
                        spot.setImageView(imageView);
                        spot.getChildren().add(imageView);
                    }
                }
                this.add(spot, j, i);
            }
        }
    }
}