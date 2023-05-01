package application;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class MainMenu extends VBox {

    private final TextField player1NameField = new TextField();
    private final TextField player2NameField = new TextField();
    private final Button startButton = new Button("Start");

    public MainMenu() {
        super(10); // Set spacing between children to 10px
        setPadding(new Insets(20)); // Add padding to the VBox
        setPrefSize(500, 500); // Set size of the VBox

        // Add text fields for player names
        getChildren().addAll(
                new Text("Player 1 Name:"),
                player1NameField,
                new Text("Player 2 Name:"),
                player2NameField,
                startButton
        );
    }

    public TextField getPlayer1NameField() {
        return player1NameField;
    }

    public TextField getPlayer2NameField() {
        return player2NameField;
    }

    public Button getStartButton() {
        return startButton;
    }
}
