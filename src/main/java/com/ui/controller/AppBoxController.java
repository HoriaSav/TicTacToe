package com.ui.controller;

import com.core.AppCore;
import com.ui.tools.ContextController;
import com.ui.tools.FxmlFileOpener;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class AppBoxController {

    @FXML
    private StackPane stackPane;
    @FXML
    private Label errorLabel;

    public void initialize() {
        loadWelcomePanel();
        ContextController.setMainStack(stackPane); // Register stackPane
        ContextController.setErrorLabel(errorLabel);
        ContextController.setAppCore(new AppCore());
        ContextController.setLastAccessedFile("welcome_panel.fxml");
    }

    private void loadWelcomePanel() {
        String newPanel = "welcome_panel.fxml";
        FxmlFileOpener.loadFrame(stackPane, newPanel);
    }

    @FXML
    private void goBackToLastPanel() {
        if (ContextController.getLastAccessedFile() != null) {
            FxmlFileOpener.loadFrame(stackPane, ContextController.getLastAccessedFile());
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
