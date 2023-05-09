package application;

import java.io.File;
import java.util.ArrayList;

import application.Player.PieceColor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ChessBoard extends GridPane {
    // the size of the chess board
    private final int size;
    // colors used for the light and dark tiles on the board
    private final Color lightColor = Color.rgb(255, 206, 158);
    private final Color darkColor = Color.rgb(209, 139, 71);
    // boolean value used to alternate between white and black pieces
    boolean bool = false;
    // 2D array of spots that make up the board
    private static final Spot[][] spots = new Spot[8][8];
    // path to the images used for the chess pieces
    final static String IMAGE_PATH = "images";
    private  Player whitePlayer;
    private  Player blackPlayer;

    public ChessBoard(int size, Player whitePlayer, Player blackPlayer) {
        // set the size of the board
        this.size = size;
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
        // create the squares on the board
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                // setting placement and size of the tile
                Rectangle tile = new Rectangle(i * 50, j * 50, 50, 50);

                // alternates the color of the tiles
                tile.setFill((i + j) % 2 == 0 ? lightColor : darkColor);

                // initialize the piece and occupied status for the spot
                Piece piece = null;
                boolean isSpotOccupied = false;

                // set up the starting position for the pieces on the board
                if (i == 0 || i == 7) {
                    switch (j) {
                        case 0:
                        case 7:
                            if (i < 2) {
                                bool = false;
                            } else {
                                bool = true;
                            }
                            piece = new Rook(bool ? PieceColor.WHITE : PieceColor.BLACK);
                            isSpotOccupied = true;
                            break;
                        case 1:
                        case 6:
                            if (i < 2) {
                                bool = false;
                            } else {
                                bool = true;
                            }
                            piece = new Knight(bool ? PieceColor.WHITE : PieceColor.BLACK);
                            isSpotOccupied = true;
                            break;
                        case 2:
                        case 5:
                            if (i < 2) {
                                bool = false;
                            } else {
                                bool = true;
                            }
                            piece = new Bishop(bool ? PieceColor.WHITE : PieceColor.BLACK);
                            isSpotOccupied = true;
                            break;
                        case 3:
                            if (i < 2) {
                                bool = false;
                            } else {
                                bool = true;
                            }
                            piece = new Queen(bool ? PieceColor.WHITE : PieceColor.BLACK);
                            isSpotOccupied = true;
                            break;
                        case 4:
                            if (i < 2) {
                                bool = false;
                            } else {
                                bool = true;
                            }
                            piece = new King(bool ? PieceColor.WHITE : PieceColor.BLACK);
                            isSpotOccupied = true;
                            break;
                    }
                } else if (i == 1 || i == 6) {
                    if (i < 2) {
                        bool = false;
                    } else {
                        bool = true;
                    }
                    piece = new Pawn(bool ? PieceColor.WHITE : PieceColor.BLACK);
                    isSpotOccupied = true;
                }
                // add tile to the board
                this.add(tile, j, i);
                Spot spot = new Spot(piece, tile, isSpotOccupied, this, bool ? whitePlayer : blackPlayer);

                // load the piece image and add it to the spot
                if (piece != null) {
                    String imagePath = IMAGE_PATH + "\\" + piece.getImageName() + ".png";
                    File imageFile = new File(imagePath);
                    if (imageFile.exists()) {
                        Image image = new Image(imageFile.toURI().toString());
                        ImageView imageView = new ImageView(image);
                        imageView.setFitWidth(40);
                        imageView.setFitHeight(40);
                        spot.getChildren().add(imageView);
                        spot.setImageView(imageView);

                    }
                }
                // Add the spot to the 2D array of spots
                spots[i][j] = spot;
                // add spot to the board
                this.add(spot, j, i);
            }
        }
        this.updateBoard();
    }

    // function that returns a specific spot or null if out of bounds
    public Spot getSpot(int row, int col) {
        if (row < 0 || row >= size || col < 0 || col >= size) {
            return null;
        }
        return spots[row][col];
    }

    // function that sets specific spot and adds it to the board
    public void setSpot(int row, int col, Spot spot) {

        ImageView oldImageView = spot.getImageView();

        if (oldImageView != null) {
            spot.getChildren().remove(oldImageView);
        }

        if (spot.getPiece() != null) {
            String imagePath = IMAGE_PATH + "\\" + spot.getPiece().getImageName() + ".png";
            File imageFile = new File(imagePath);
            if (imageFile.exists()) {
                Image image = new Image(imageFile.toURI().toString());
                ImageView imageView = new ImageView(image);
                imageView.setFitWidth(40);
                imageView.setFitHeight(40);
                spot.getChildren().add(imageView);
                spot.setImageView(imageView);
            }
        }
        spots[row][col] = spot;
    }

    // function that resets the tile color to the default colors
    public void resetHighlights() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                spots[i][j].resetColor();
            }
        }
    }

    public void updateBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                spots[i][j].setBoard(this);
            }
        }
    }

    public ArrayList<Player> players() {
        ArrayList<Player> players = new ArrayList<>(2);
        players.add(whitePlayer);
        players.add(blackPlayer);
        return players;

    }
    public void changeplayers(Player white,Player black) {
            this.whitePlayer.isTurn = white.isTurn;
            this.blackPlayer.isTurn = black.isTurn;
            this.updateBoard();
    }
}