package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */

public class ChessGame extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Create main menu and add it to a new Scene
        MainMenu mainMenu = new MainMenu();
        Scene menuScene = new Scene(mainMenu);

        // Set the primary stage's scene to the main menu Scene
        primaryStage.setTitle("Chess Game");
        primaryStage.setScene(menuScene);
        primaryStage.show();

        // Launch the game with the chosen players when the start button is pressed
        mainMenu.getStartButton().setOnAction(e -> {
            // Get player names from text fields
            String player1Name = mainMenu.getPlayer1NameField().getText();
            String player2Name = mainMenu.getPlayer2NameField().getText();

            // Assign random colors to the players
            boolean player1IsBlack = Math.random() < 0.5;
            boolean player2IsBlack = !player1IsBlack;

            // Create player instances with the chosen names and colors
            Player player1 = new Player(player1Name, player1IsBlack);
            Player player2 = new Player(player2Name, player2IsBlack);

            // Create HBox to hold player labels
            HBox playerLabels = new HBox(20);
            playerLabels.setAlignment(Pos.CENTER);
            playerLabels.getChildren().addAll(
                    new Label(player1.getName() + " (" + (player1.isBlack() ? "Black" : "White") + ")"),
                    new Label(player2.getName() + " (" + (player2.isBlack() ? "Black" : "White") + ")")
            );

            // Create VBox to hold player labels and chess board
            VBox gameLayout = new VBox(20);
            gameLayout.getChildren().addAll(playerLabels, new ChessBoard(8));

            // Launch the game with the chosen players
            Scene gameScene = new Scene(gameLayout);
            primaryStage.setScene(gameScene);
        });
    }
}

