package com.ui.controller.app;

import com.core.game.GameEngine;
import com.ui.tools.ContextController;
import com.ui.util.FxmlLoader;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AppBoxController {

    @FXML
    private StackPane stackPane;
    @FXML
    private Label errorLabel;
    @FXML
    private VBox goBackVBox;

    public void initialize() {
        loadWelcomePanel();
        ContextController.setMainStack(stackPane); // Register stackPane
        ContextController.setErrorLabel(errorLabel);
        ContextController.setAppCore(new GameEngine());
        ContextController.setLastAccessedFile("welcome_panel.fxml");
        ContextController.setGoBackVBox(goBackVBox);
        goBackVBox.setVisible(false);
    }

    private void loadWelcomePanel() {
        String newPanel = "welcome_panel.fxml";
        FxmlLoader.loadFrame(stackPane, newPanel);
    }

    @FXML
    private void goBackToLastPanel() {
        if (ContextController.getLastAccessedFile() != null) {
            FxmlLoader.loadFrame(stackPane, ContextController.getLastAccessedFile());
            if (ContextController.getLastAccessedFile().equals("welcome_panel.fxml")) {
                goBackVBox.setVisible(false);
            }
        }
    }

    @FXML
    private void minimizeWindow(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    private void closeApp() {
        Platform.exit();
    }

    @FXML
    private void toggleMaximize(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setMaximized(!stage.isMaximized());
    }
}
