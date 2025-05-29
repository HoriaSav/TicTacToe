package com.ui.tools;

import com.core.game.GameEngine;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class ContextController {
    private static GameEngine gameEngine;

    private static StackPane mainStack;
    private static Label errorLabel;

    private static Label player1UsernameLabel;
    private static Label player2UsernameLabel;
    private static Label player1WinrateLabel;
    private static Label player2WinrateLabel;

    private static String lastAccessedFile;

    private static HBox goBackVBox;

    public static void setMainStack(StackPane stackPane) {
        mainStack = stackPane;
    }

    public static void setErrorLabel(Label error) {
        errorLabel = error;
    }

    public static StackPane getMainStack() {
        return mainStack;
    }

    public static Label getErrorLabel() {
        return errorLabel;
    }

    public static GameEngine getGameEngine(){
        return gameEngine;
    }

    public static void setAppCore(GameEngine gameEngine) {
        ContextController.gameEngine = gameEngine;
    }

    public static void setPlayerInfoLabels(Label player1UsernameLabel, Label player2UsernameLabel, Label player1WinrateLabel, Label player2WinrateLabel) {
        ContextController.player1UsernameLabel = player1UsernameLabel;
        ContextController.player2UsernameLabel = player2UsernameLabel;
        ContextController.player1WinrateLabel = player1WinrateLabel;
        ContextController.player2WinrateLabel = player2WinrateLabel;
    }

    public static void setPlayer1InfoDetails(String username1, String winrate1) {
        ContextController.player1UsernameLabel.setText(username1);
        ContextController.player1WinrateLabel.setText(winrate1);
    }

    public static void setPlayer2InfoDetails(String username2, String winrate2) {
        ContextController.player2UsernameLabel.setText(username2);
        ContextController.player2WinrateLabel.setText(winrate2);
    }

    public static String getLastAccessedFile() {
        return lastAccessedFile;
    }

    public static void setLastAccessedFile(String lastAccessedFile) {
        ContextController.lastAccessedFile = lastAccessedFile;
    }

    public static HBox getGoBackVBox() {
        return goBackVBox;
    }

    public static void setGoBackVBox(HBox goBackVBox) {
        ContextController.goBackVBox = goBackVBox;
    }
}
