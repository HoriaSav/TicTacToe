package com.ui.controller;

import com.core.Player;
import com.ui.tools.ContextController;
import com.ui.tools.FxmlFileOpener;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.util.List;

public class PlayerMenuController {
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
        loadPlayerArrayList();
    }

    private void loadPlayers() {
        playerListVbox.getChildren().clear();
        for (Player player : playerList) {
            FxmlFileOpener.addCustomizedFXMLTo(playerListVbox, "playerItem.fxml", (PlayerItemController controller) -> controller.setPlayerDetails(player));
        }
    }

    private void loadPlayerArrayList() {
        playerList = ContextController.readFile();
        loadPlayers();
    }

    @FXML
    public void createNewUser() {
        System.out.println("Creating new user "+usernameTextField.getText());
        Player newPlayer = new Player(usernameTextField.getText());
        ContextController.addPlayer(newPlayer);
        ContextController.writeToFile();
        loadPlayerArrayList();
    }

    @FXML
    public void selectUser() {

    }

    @FXML
    public void playGame() {
        ContextController.setPlayer1(player1UsernameLabel.getText());
        ContextController.setPlayer2(player2UsernameLabel.getText());
        openGame();
    }

    private void openGame() {
        StackPane targetStack = ContextController.getMainStack();
        if (targetStack != null) {
            FxmlFileOpener.loadFrame(targetStack, "game_table.fxml");
        } else {
            System.out.println("Main StackPane not found.");
        }
    }
}
