package com.example;

import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Spot extends StackPane {

    private Piece piece;
    private Rectangle tile;
    private ImageView imageView;

    public Spot(Piece piece, Rectangle tile) {
        this.piece = piece;
        this.tile = tile;
    }

    public Spot(Piece piece, Rectangle tile, ImageView imageView) {
        this.piece = piece;
        this.tile = tile;
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

    public void setTile(Rectangle tile) {
        this.tile = tile;
    }

    public double getTileX() {
        return tile.getX();
    }

    public double getTileY() {
        return tile.getY();
    }
    
    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

}
