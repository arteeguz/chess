package com.example;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class ChessBoard extends GridPane {
    private final int size;
    private final Color lightColor = Color.rgb(255, 206, 158);
    private final Color darkColor = Color.rgb(209, 139, 71);

    public ChessBoard(int size) {
        this.size = size;

        // Create the squares on the board
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // setting placement and size of the tile( x-coor,y-coor,width,height)
                Rectangle tile = new Rectangle(i * 50, j * 50, 50, 50);
                // alternates the color of the tiles
                tile.setFill((i + j) % 2 == 0 ? lightColor : darkColor);
                // adds the tile to the chessboard via gridPane
                this.add(tile, j, i);
                
            }
        }
    }
}
