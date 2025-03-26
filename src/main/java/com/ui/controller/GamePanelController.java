package com.ui.controller;

import com.core.AppCore;
import com.core.Player;
import com.ui.tools.ContextController;
import com.ui.tools.FxmlFileOpener;
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
                System.out.println(ContextController.getAppCore().getRound());
                if (ContextController.getAppCore().getRound() % 2 == 0) {
                    newImage = addMove(position, ContextController.getAppCore().getActivePlayers()[0], "/icons/x.png");
                } else {
                    newImage = addMove(position, ContextController.getAppCore().getActivePlayers()[1], "/icons/o.png");
                }
                ImageView imageView = (ImageView) clickedButton.getGraphic();
                imageView.setImage(newImage);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private Image addMove(int position, Player player, String iconPath) throws Exception{
        ContextController.getAppCore().addMove(position, player);
        Image newImage = new Image(getClass().getResourceAsStream(iconPath));
        System.out.println("Round "+ContextController.getAppCore().getRound());
        showGameOver(player.getUsername());
        System.out.println(player.getUsername());
        return newImage;
    }

    private void showGameOver(String playerName) {
        if (ContextController.getAppCore().isGameOver()) {
            gameOver = true;
            Label label = ContextController.getErrorLabel();
            String player1=ContextController.getAppCore().getActivePlayers()[0].getUsername();
            String player2=ContextController.getAppCore().getActivePlayers()[1].getUsername();

            if(ContextController.getAppCore().getRound()==9){
                label.setText("Game Over. It's a tie!");
                ContextController.getAppCore().updatePlayer(null,player1);
                ContextController.getAppCore().updatePlayer(null,player2);
            }
            else{
                label.setText("Game Over. Player " + playerName + " won!");
                if(ContextController.getAppCore().getRound()%2==1) {
                    ContextController.getAppCore().updatePlayer(Boolean.TRUE, player1);
                    ContextController.getAppCore().updatePlayer(Boolean.FALSE, player2);
                }
                else {
                    ContextController.getAppCore().updatePlayer(Boolean.FALSE, player1);
                    ContextController.getAppCore().updatePlayer(Boolean.TRUE, player2);
                }
            }
            loadMainPanel();
        }
    }

    private void loadMainPanel() {
        StackPane targetStack = ContextController.getMainStack();
        if (targetStack != null) {
            FxmlFileOpener.loadFrame(targetStack, "welcome_panel.fxml");
        } else {
            System.out.println("Main StackPane not found.");
        }
    }

    @FXML
    private void restartGame() {
        gameOver = false;

    }
}
