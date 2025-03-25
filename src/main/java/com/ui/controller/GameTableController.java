package com.ui.controller;

import com.core.AppCore;
import com.core.Player;
import com.ui.tools.ContextController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GameTableController {
    private AppCore appCore;
    private boolean gameOver = false;

    public void initialize() {
        appCore = new AppCore();
    }

    @FXML
    private void addMove(ActionEvent event) {
        try {
            if (!gameOver) {
                Button clickedButton = (Button) event.getSource();
                int position = Integer.parseInt(clickedButton.getText());
                Image newImage;
                System.out.println(appCore.getRounds());
                if (appCore.getRounds() % 2 == 0) {
                    newImage = addMove(position, ContextController.getPlayer1(), "/icons/x.png");
                } else {
                    newImage = addMove(position, ContextController.getPlayer2(), "/icons/o.png");
                }
                ImageView imageView = (ImageView) clickedButton.getGraphic();
                imageView.setImage(newImage);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private Image addMove(int position, Player player, String iconPath) throws Exception{
        appCore.addMove(position, player);
        Image newImage = new Image(getClass().getResourceAsStream(iconPath));
        showGameOver(player.getUsername());
        System.out.println(player.getUsername());
        return newImage;
    }

    private boolean isGameOver() {
        return appCore.isGameOver();
    }

    private void showGameOver(String playerName) {
        if (isGameOver()) {
            gameOver = true;
            Label label = ContextController.getErrorLabel();
            label.setText("Game Over. Player " + playerName + " won!");
            ContextController.updateGamesWon(playerName);
        }
    }
    @FXML
    private void restartGame() {
        gameOver = false;

    }
}
