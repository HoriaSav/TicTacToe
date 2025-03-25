package com.ui.controller;

import com.core.AppCore;
import com.core.Player;
import com.ui.tools.ControllerContext;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GameTableController {
    private AppCore appCore;
    private Player player1;
    private Player player2;
    private boolean gameOver = false;

    public void initialize() {
        appCore = new AppCore();
        player1 = new Player("HoriaS", "1234");
        player1.setGameId(1);
        player2 = new Player("Zpewg", "5678");
        player2.setGameId(2);
    }

    @FXML
    private void addMove(ActionEvent event) {
        if (!gameOver) {
            Button clickedButton = (Button) event.getSource();
            int position = Integer.parseInt(clickedButton.getText());
            Image newImage;
            if (appCore.getRounds() % 2 == 0) {
                appCore.addMove(position, player1);
                newImage = new Image(getClass().getResourceAsStream("/icons/x.png"));
                showGameOver(player1.getUserName());
            } else {
                appCore.addMove(position, player2);
                newImage = new Image(getClass().getResourceAsStream("/icons/o.png"));
                showGameOver(player2.getUserName());
            }
            ImageView imageView = (ImageView) clickedButton.getGraphic();
            imageView.setImage(newImage);
        }
    }

    private boolean isGameOver() {
        return appCore.isGameOver();
    }

    private void showGameOver(String playerName) {
        if (isGameOver()) {
            gameOver = true;
            Label label = ControllerContext.getErrorLabel();
            label.setText("Game Over. Player " + playerName + " won!");
        }
    }
}
