package com.ui.controller;

import com.core.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PlayerItemController {
    @FXML
    private Label usernameLabel;
    @FXML
    private Label gamesWonLabel;
    @FXML
    private Label gamesPlayedLabel;

    public void initialize() {
    }

    public void setPlayerDetails(Player player) {
        usernameLabel.setText(player.getUsername());
        gamesPlayedLabel.setText(String.valueOf(player.getGamesWon()+player.getGamesLost()+player.getGamesDraw()));
        gamesWonLabel.setText(String.valueOf(player.getGamesWon()));
    }
}
