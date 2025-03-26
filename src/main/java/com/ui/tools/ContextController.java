package com.ui.tools;

import com.core.AppCore;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class ContextController {
    private static AppCore appCore;

    private static StackPane mainStack;
    private static Label errorLabel;

    private static Label player1UsernameLabel;
    private static Label player2UsernameLabel;
    private static Label player1WinrateLabel;
    private static Label player2WinrateLabel;

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

    public static AppCore getAppCore(){
        return appCore;
    }

    public static void setAppCore(AppCore appCore) {
        ContextController.appCore = appCore;
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
}
