package com.example;

import com.example.Player.PieceColor;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class ChessGame extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    final static int BOARDSIZE = 8;
    private Player player1;
    private Player player2;
    private ChessBoard board;

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
            PieceColor player1Color = PieceColor.WHITE;
            PieceColor player2Color = PieceColor.BLACK;

            // Create player instances with the chosen names and colors
            player1 = new WhitePlayer(player1Name, player1Color, true);
            player2 = new BlackPlayer(player2Name, player2Color, false);

            // Create HBox to hold player labels
            HBox playerLabels = new HBox(20);
            playerLabels.setAlignment(Pos.CENTER);
            playerLabels.getChildren().addAll(new Label(player1.getName() + " (" + "White" + ")",
                    new Label(player2.getName() + " (" + "Black" + ")")));

            // Create chess board
            board = new ChessBoard(BOARDSIZE,player1,player2);

            // Create VBox to hold player labels and chess board
            VBox gameLayout = new VBox(20);
            gameLayout.getChildren().addAll(playerLabels, board);

            // Create MenuBar
            MenuBar menuBar = new MenuBar();
            Menu fileMenu = new Menu("File");
            MenuItem saveItem = new MenuItem("Save");
            fileMenu.getItems().add(saveItem);
            saveItem.setOnAction(event -> {
                // include code to save the chess board
                // output all information to an output file
                // save who's turn it is
                // save the position of the pieces
                // And maybe save the time remaining on the timer
            });
            menuBar.getMenus().addAll(fileMenu);

            // Create StackPane to hold VBox and MenuBar
            StackPane gameRoot = new StackPane();
            gameRoot.getChildren().addAll(gameLayout, menuBar);
            StackPane.setAlignment(menuBar, Pos.TOP_CENTER);
            StackPane.setMargin(gameLayout, new Insets(25, 0, 0, 0));


            // Launch the game with the chosen players
            Scene gameScene = new Scene(gameRoot);
            primaryStage.setScene(gameScene);

        });
    }
}