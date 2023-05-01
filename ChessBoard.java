package application;

import java.io.File;

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
                if (j == 0 || j == 7) {
                    switch (i) {
                        case 0:
                        case 7:
                        if((i + j) % 2 == 0 ){
                             bool = true;
                        }else{
                             bool =false;
                        }
                            piece = new Rook(false, bool);
                            break;
                        case 1:
                        case 6:
                        if((i + j) % 2 == 0 ){
                            bool = true;
                       }else{
                            bool =false;
                       }
                            piece = new Knight(false, bool);
                            break;
                        case 2:
                        case 5:
                        if((i + j) % 2 == 0 ){
                            bool = true;
                       }else{
                            bool =false;
                       }
                            piece = new Bishop(false, bool);
                            break;
                        case 3:
                        if((i + j) % 2 == 0 ){
                            bool = true;
                       }else{
                            bool =false;
                       }
                            piece = new Queen(false, bool);
                            break;
                        case 4:
                            if((i + j) % 2 == 0 ){
                                bool = true;
                            }else{
                            bool =false;
                            }
                            piece = new King(false, bool);
                            break;
                    }
                } else if (j == 1 || j == 6) {
                    if((i + j) % 2 == 0 ){
                        bool = true;
                   }else{
                        bool =false;
                   }
                    piece = new Pawn(false, bool);
                }
                Spot spot = new Spot(piece, tile);
                spots[i][j] = spot;
                this.add(tile, j, i);
                
                // Load the chess piece image
                if (piece != null && piece.getName(piece) != null) {
                    String imagePath = IMAGE_PATH + "\\"+ piece.getName(piece)+".png";
                    File imageFile = new File(imagePath);
                    if (imageFile.exists()) {
                        Image image = new Image(imageFile.toURI().toString());
                        ImageView imageView = new ImageView(image);
                        imageView.setFitWidth(40);
                        imageView.setFitHeight(40);
                        spot.getChildren().add(imageView);
                    }
                }
                this.add(spot, j, i);
            }
        }
    }

	public int getSize() {
		return size;
	}

   

}