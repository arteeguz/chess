package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class MainMenu extends VBox {
	
    private final TextField player1NameField = new TextField();
    private final TextField player2NameField = new TextField();
    private final Button startButton = new Button("PLAY");

    public MainMenu() {
        super(10); // Set spacing between children to 10px
        setPadding(new Insets(20)); // Add padding to the VBox
        setPrefSize(500, 500); // Set size of the VBox

        // Add background image
        ImageView imageView = new ImageView(new Image("chessbg.jpg"));

        startButton.setFont(Font.font("Arial", FontWeight.BOLD, 24));

        // Add text fields for player names
        Text welcomeText = new Text("Welcome to Chess Game");
        welcomeText.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        StackPane welcomePane = new StackPane(welcomeText);
        welcomePane.setAlignment(Pos.CENTER);

        getChildren().addAll(
                imageView,
                welcomePane,
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
