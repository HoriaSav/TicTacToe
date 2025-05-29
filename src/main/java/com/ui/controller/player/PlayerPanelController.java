package com.ui.controller.player;

import com.core.player.model.Player;
import com.ui.tools.ContextController;
import com.ui.util.FxmlLoader;
import javafx.fxml.FXML;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.util.List;

public class PlayerPanelController {
    @FXML
    private Label player1UsernameLabel;
    @FXML
    private Label player2UsernameLabel;
    @FXML
    private Label player1WinrateLabel;
    @FXML
    private Label player2WinrateLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private VBox playerListVbox;

    private List<Player> playerList;

    public void initialize() {
        loadPlayersInUI();
        ContextController.setPlayerInfoLabels(player1UsernameLabel, player2UsernameLabel, player1WinrateLabel, player2WinrateLabel);
        ContextController.getGameEngine().resetActivePlayer(1);
        ContextController.getGameEngine().resetActivePlayer(2);
        ContextController.getGoBackVBox().setVisible(true);
    }

    private void loadPlayersInUI() {
        playerList = ContextController.getGameEngine().getPlayerList();
        playerListVbox.getChildren().clear();
        FxmlLoader.addCustomizedFXMLTo(playerListVbox, "playerListColumnDef.fxml", (PlayerListColumnDefController controller) -> {});
        addSeparator();
        for (Player player : playerList) {
            FxmlLoader.addCustomizedFXMLTo(playerListVbox, "playerItem.fxml", (PlayerItemController controller) -> controller.setPlayerDetails(player));
        }
    }

    private void addSeparator() {
        Separator separator = new Separator();
        separator.setPrefWidth(284); // Set desired length
        separator.setOrientation(Orientation.HORIZONTAL); // Optional, since it's horizontal by default

        playerListVbox.getChildren().add(separator);
    }

    @FXML
    public void createNewUser() {
        ContextController.getGameEngine().createNewUser(usernameTextField.getText());
        usernameTextField.clear();
        loadPlayersInUI();
    }

    @FXML
    private void playGame() {
        if (ContextController.getGameEngine().getActivePlayers(1) == null) {
            ContextController.getGameEngine().setActivePlayer("Guest 1");
        }
        if (ContextController.getGameEngine().getActivePlayers(2) == null) {
            ContextController.getGameEngine().setActivePlayer("Guest 2");
        }
        StackPane targetStack = ContextController.getMainStack();
        if (targetStack != null) {
            String newPanel = "game_panel.fxml";
            ContextController.setLastAccessedFile("welcome_panel.fxml");
            FxmlLoader.loadFrame(targetStack, newPanel);
        } else {
            System.out.println("Main StackPane not found.");
        }
    }

    @FXML
    private void eliminatePlayer1(){
        ContextController.getGameEngine().resetActivePlayer(1);
    }

    @FXML
    private void eliminatePlayer2(){
        ContextController.getGameEngine().resetActivePlayer(2);
    }
}
