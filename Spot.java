package application;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Spot extends StackPane {
    private Piece piece;
    private final Rectangle highlight;
    private final Color lightColor = Color.rgb(255, 206, 158);
    private final Color darkColor = Color.rgb(209, 139, 71);
    private final ImageView pieceImageView;

    public Spot(Piece piece, Rectangle rectangle) {
        this.piece = piece;
        this.highlight = new Rectangle(50, 50, Color.rgb(0, 0, 255, 0.5));
        this.highlight.setVisible(false);
        this.getChildren().addAll(rectangle, highlight);
        if (piece != null) {
            pieceImageView = new ImageView(piece.getImage());
            this.getChildren().add(pieceImageView);
        } else {
            pieceImageView = null;
        }

        this.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (piece != null) {
                    toFront();
                }
            }
        });

        this.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (piece != null) {
                    setTranslateX(getTranslateX() + event.getX() - 25);
                    setTranslateY(getTranslateY() + event.getY() - 25);
                }
            }
        });
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
        if (piece != null) {
            pieceImageView.setImage(piece.getImage());
        } else {
            this.getChildren().remove(pieceImageView);
        }
    }

    public Rectangle getHighlight() {
        return highlight;
    }

    public Color getLightColor() {
        return lightColor;
    }

    public Color getDarkColor() {
        return darkColor;
    }
}