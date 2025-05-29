package com.ui.controller.game;

import com.core.player.model.Player;
import com.ui.tools.ContextController;
import com.ui.util.FxmlLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class GamePanelController {
    private boolean gameOver = false;

    public void initialize() {
    }

    @FXML
    private void addMove(ActionEvent event) {
        try {
            if (!gameOver) {
                Button clickedButton = (Button) event.getSource();
                int position = Integer.parseInt(clickedButton.getText());
                Image newImage;
                if (ContextController.getGameEngine().getRound() % 2 == 0) {
                    newImage = addMoveOnMatrix(position, ContextController.getGameEngine().getActivePlayers(1), "/icons/x.png");
                } else {
                    newImage = addMoveOnMatrix(position, ContextController.getGameEngine().getActivePlayers(2), "/icons/o.png");
                }
                ImageView imageView = (ImageView) clickedButton.getGraphic();
                imageView.setImage(newImage);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private Image addMoveOnMatrix(int position, Player player, String iconPath) throws Exception {
        System.out.print("Round " + ContextController.getGameEngine().getRound() + ": " + player.getUsername() + " -> ");
        ContextController.getGameEngine().addMove(position, player);
        Image newImage = new Image(getClass().getResourceAsStream(iconPath));
        showGameOver(player.getUsername());
        return newImage;
    }

    private void showGameOver(String playerName) {
        if (ContextController.getGameEngine().isGameOver()) {
            System.out.println("Game Over! Player: \"" + playerName + "\" won!");
            gameOver = true;
            ContextController.getGameEngine().resetGame();
            Label label = ContextController.getErrorLabel();
            String player1 = ContextController.getGameEngine().getActivePlayers(1).getUsername();
            String player2 = ContextController.getGameEngine().getActivePlayers(2).getUsername();

            if (ContextController.getGameEngine().getRound() == 9) {
                label.setText("Game Over. It's a tie!");
                ContextController.getGameEngine().updatePlayer(null, player1);
                ContextController.getGameEngine().updatePlayer(null, player2);
            } else {
                label.setText("Game Over. Player " + playerName + " won!");
                if (ContextController.getGameEngine().getRound() % 2 == 1) {
                    ContextController.getGameEngine().updatePlayer(Boolean.TRUE, player1);
                    ContextController.getGameEngine().updatePlayer(Boolean.FALSE, player2);
                } else {
                    ContextController.getGameEngine().updatePlayer(Boolean.FALSE, player1);
                    ContextController.getGameEngine().updatePlayer(Boolean.TRUE, player2);
                }
            }
            loadMainPanel();
        }
    }

    private void loadMainPanel() {
        StackPane targetStack = ContextController.getMainStack();
        if (targetStack != null) {
            String newPanel = "welcome_panel.fxml";
            ContextController.setLastAccessedFile(newPanel);
            FxmlLoader.loadFrame(targetStack, newPanel);
        } else {
            System.out.println("Main StackPane not found.");
        }
    }

    @FXML
    private void restartGame() {
        gameOver = false;

    }
}
