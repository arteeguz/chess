package com.example;

import java.util.ArrayList;

import javafx.geometry.Point2D;
import javafx.scene.Cursor;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Spot extends StackPane {

    private Piece piece;
    private Rectangle tile;
    private ImageView imageView;
    private boolean isSpotOccupied;
    protected Piece pieceBeingDragged;
    protected ImageView imageViewBeingDragged;
    private final Color lightColor = Color.rgb(255, 206, 158);
    private final Color darkColor = Color.rgb(209, 139, 71);
    private double xCoor;
    private double yCoor;
    private ChessBoard board;

    public Spot(Piece piece, Rectangle tile, boolean isSpotOccupied, ChessBoard board, Player player) {
        this.piece = piece;
        this.tile = tile;
        this.imageView = null;
        this.isSpotOccupied = isSpotOccupied;
        this.board = board;
        this.updateEventListeners(player);
    }

    public ChessBoard getBoard() {
        return board;
    }

    public void setBoard(ChessBoard board) {
        this.board = board;
    }

    public void removePiece() {

        piece = null; // set the piece reference to null
        setIsSpotOccupied(false);

    }

    public void removeImageView() {

        imageView = null; // set the piece reference to null

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
        setIsSpotOccupied(piece != null);

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

    public void setIsSpotOccupied(boolean isSpotOccupied) {
        this.isSpotOccupied = isSpotOccupied;
    }

    public void highlight() {
        tile.setFill(Color.rgb(170, 162, 58));
    }

    public void resetColor() {
        int row = getRow();
        int col = getColumn();
        tile.setFill((row + col) % 2 == 0 ? lightColor : darkColor);
    }

    public void updateEventListeners(Player player) {

        setOnMousePressed(e -> {

            board.resetHighlights(); // Reset highlights on the board
            if (isSpotOccupied) {
                ArrayList<Move> legalMoves = piece.legalMoves(board, this);
                for (Move move : legalMoves) {
                    Spot endSpot = move.getEnd(); // Access the 'end' Spot directly
                    endSpot.highlight();
                }
                pieceBeingDragged = piece;
                imageViewBeingDragged = imageView;

                this.toFront();
                this.setCursor(Cursor.CLOSED_HAND);

            }

        });

        setOnMouseDragged(event -> {
            if (pieceBeingDragged != null) {
                xCoor = event.getX() - 25;
                yCoor = event.getY() - 25;
                imageViewBeingDragged.setTranslateX(xCoor);
                imageViewBeingDragged.setTranslateY(yCoor);

            }
        });
        setOnMouseReleased(event -> {

            board.resetHighlights();
            if (pieceBeingDragged != null) {
                imageViewBeingDragged.setTranslateX(0);
                imageViewBeingDragged.setTranslateY(0);

                // Calculate the destination row and column based on the local coordinates
                // within the GridPane
                Point2D localPoint = board.sceneToLocal(event.getSceneX(), event.getSceneY());
                int newRow = (int) Math.floor(localPoint.getY() / 50);
                int newCol = (int) Math.floor(localPoint.getX() / 50);

                Spot endSpot = board.getSpot(newRow, newCol);

                if (endSpot != this && this != null &&
                        this.isSpotOccupied() && this.getPiece().getColor() == player.getPieceColor()) {
                    if (player.isTurn()) {
                        if (endSpot != null && pieceBeingDragged.canMove(board, this, endSpot)) {
                            if (pieceBeingDragged instanceof Pawn) {
                                ((Pawn) pieceBeingDragged).setFirstMove(false);
                            }
                            if (endSpot.isSpotOccupied()) {
                                ImageView capturedPieceImageView = endSpot.getImageView();
                                endSpot.removeImageView();
                                endSpot.getChildren().remove(capturedPieceImageView);
                            }
                            this.removePiece();
                            this.getChildren().remove(imageViewBeingDragged);
                            this.removeImageView();

                            this.setOnMousePressed(null);
                            this.setOnMouseDragged(null);
                            this.setOnMouseReleased(null);

                            endSpot.setPiece(pieceBeingDragged);
                            endSpot.getChildren().add(imageViewBeingDragged);
                            endSpot.setImageView(imageViewBeingDragged);
                            endSpot.setIsSpotOccupied(true);

                            ArrayList<Player> players = board.players();
                            players.get(0).changeTurn();
                            players.get(1).changeTurn();
                            board.changeplayers(players.get(0), players.get(1));
                            endSpot.updateEventListeners(player);
                        }

                    } else {
                        return;
                    }
                }

                setCursor(Cursor.DEFAULT);

            }
        });
    }

}