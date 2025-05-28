package com.ui.controller.player;

import com.core.player.model.Player;
import com.ui.tools.ContextController;
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
        gamesPlayedLabel.setText(String.valueOf(player.getGamesWon() + player.getGamesLost() + player.getGamesDraw()));
        gamesWonLabel.setText(String.valueOf(player.getGamesWon()));
    }

    @FXML
    public void addPlayer() {
        ContextController.getAppCore().setActivePlayer(usernameLabel.getText());
    }
}
