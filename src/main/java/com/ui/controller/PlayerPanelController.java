package com.ui.controller;

import com.core.Player;
import com.ui.tools.ContextController;
import com.ui.tools.FxmlFileOpener;
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
        ContextController.getAppCore().resetActivePlayer(1);
        ContextController.getAppCore().resetActivePlayer(2);
    }

    private void loadPlayersInUI() {
        playerList = ContextController.getAppCore().getPlayerList();
        playerListVbox.getChildren().clear();
        FxmlFileOpener.addCustomizedFXMLTo(playerListVbox, "playerListColumnDef.fxml", (PlayerListColumnDefController controller) -> {});
        addSeparator();
        for (Player player : playerList) {
            FxmlFileOpener.addCustomizedFXMLTo(playerListVbox, "playerItem.fxml", (PlayerItemController controller) -> controller.setPlayerDetails(player));
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
        ContextController.getAppCore().createNewUser(usernameTextField.getText());
        loadPlayersInUI();
    }

    @FXML
    private void playGame() {
        StackPane targetStack = ContextController.getMainStack();
        if (targetStack != null) {
            FxmlFileOpener.loadFrame(targetStack, "game_panel.fxml");
        } else {
            System.out.println("Main StackPane not found.");
        }
    }

    @FXML
    private void eliminatePlayer1(){
        ContextController.getAppCore().resetActivePlayer(1);
    }

    @FXML
    private void eliminatePlayer2(){
        ContextController.getAppCore().resetActivePlayer(2);
    }
}
