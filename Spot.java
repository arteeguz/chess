package application;


import java.util.ArrayList;

import javafx.geometry.Point2D;
import javafx.scene.Cursor;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Spot extends StackPane {

    private Piece piece;
    private Rectangle tile;
    private ImageView imageView;
    private boolean isSpotOccupied;
    protected Piece pieceBeingDragged;
    protected ImageView imageViewBeingDragged;
    private ChessBoard board;
    private final Color lightColor = Color.rgb(255, 206, 158);
    private final Color darkColor = Color.rgb(209, 139, 71);
    double X;
    double Y;

    public Spot(Piece piece, Rectangle tile, boolean isSpotOccupied, ChessBoard board) {
        this.piece = piece;
        this.tile = tile;
        this.imageView = null;
        this.isSpotOccupied = isSpotOccupied;
        this.board = board;

        setOnMousePressed(e -> {
            board.resetHighlights(); // Reset highlights on the board
            if (isSpotOccupied) {
                ArrayList<Move> legalMoves = piece.legalMoves(board, this);
                for (Move move : legalMoves) {
                    Spot destinationSpot = move.getEnd(); // Access the 'end' Spot directly
                    destinationSpot.highlight();
                }
                pieceBeingDragged = piece;
                imageViewBeingDragged = imageView;
                toFront();
                setCursor(Cursor.CLOSED_HAND);
            }
        });


        setOnMouseDragged(event -> {
            if (pieceBeingDragged != null) {
                X = event.getX() - 25;
                Y = event.getY() - 25;
                imageViewBeingDragged.setTranslateX(X);
                imageViewBeingDragged.setTranslateY(Y);
                event.consume();
            }
        });
        setOnMouseReleased(event -> {
            if (pieceBeingDragged != null) {
                imageViewBeingDragged.setTranslateX(0);
                imageViewBeingDragged.setTranslateY(0);

                // Calculate the destination row and column based on the local coordinates within the GridPane
                Point2D localPoint = board.sceneToLocal(event.getSceneX(), event.getSceneY());
                int newRow = (int) Math.floor(localPoint.getY() / 50);
                int newCol = (int) Math.floor(localPoint.getX() / 50);

                Spot destinationSpot = board.getSpot(newRow, newCol);

                if (destinationSpot != null && pieceBeingDragged.canMove(board, this, destinationSpot)) {
                    if (pieceBeingDragged instanceof Pawn) {
                        ((Pawn) pieceBeingDragged).setFirstMove(false);
                    }

                    if (destinationSpot.isSpotOccupied()) {
                        ImageView capturedPieceImageView = destinationSpot.getImageView();
                        destinationSpot.removeImageView();
                        destinationSpot.getChildren().remove(capturedPieceImageView);
                    }

                    destinationSpot.setPiece(pieceBeingDragged);
                    destinationSpot.setImageView(imageViewBeingDragged);
                    destinationSpot.getChildren().add(imageViewBeingDragged);
                    removePiece();
                    removeImageView();
                    pieceBeingDragged = null;
                }

                setCursor(Cursor.DEFAULT);
                event.consume();
            }
        });




    }

    private void removePiece() {
        this.piece = null;
    }


    private void removeImageView() {
        this.imageView = null;
    }

    public Spot(Piece piece, Rectangle tile, ImageView imageView, boolean isSpotOccupied) {
        this.piece = piece;
        this.tile = tile;
        this.imageView = imageView;
        this.isSpotOccupied = isSpotOccupied;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;

    }

    public Rectangle getTile() {
        return tile;
    }

    public void getTileColor() {
        Color color = (Color) tile.getFill();
        System.out.println("Rectangle color: " + color.toString());
    }

    public Paint getColor() {
        return tile.getFill();
    }

    public void setTile(Rectangle tile) {
        this.tile = tile;
    }

    public double getTileX() {
        return tile.getX();
    }

    public double getTileY() {
        return tile.getY();
    }
    
    public int getRow() {
        return GridPane.getRowIndex(this);
    }

    public int getColumn() {
        return GridPane.getColumnIndex(this);
    }

    public boolean isSpotOccupied() {
        return isSpotOccupied;
    }
    public void highlight() {
        tile.setFill(Color.rgb(170, 162, 58));
    }

    public void resetColor() {
        int row = getRow();
        int col = getColumn();
        tile.setFill((row + col) % 2 == 0 ? lightColor : darkColor);
    }

}