package com.ui.controller;

import com.ui.tools.ContextController;
import com.ui.util.FxmlLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class MainPanelController {
    @FXML
    private Button playButton;
    @FXML
    private Button settingsButton;

    public void initialize() {
        setButtons();
    }

    private void setButtons(){
        playButton.setOnMouseEntered(e -> playButton.setScaleX(1.05));
        playButton.setOnMouseExited(e -> playButton.setScaleX(1.0));

        settingsButton.setOnMouseEntered(e -> settingsButton.setScaleX(1.05));
        settingsButton.setOnMouseExited(e -> settingsButton.setScaleX(1.0));
    }
    @FXML
    private void loadPlayerSelectionPanel() {
        StackPane targetStack = ContextController.getMainStack();
        if (targetStack != null) {
            String newPanel = "player_selection_panel.fxml";
            ContextController.setLastAccessedFile("welcome_panel.fxml");
            FxmlLoader.loadFrame(targetStack, newPanel);
        } else {
            System.out.println("Main StackPane not found.");
        }
    }
    @FXML
    private void loadSettingsPanel() {
        StackPane targetStack = ContextController.getMainStack();
        if (targetStack != null) {
            String newPanel = "settings.fxml";
            ContextController.setLastAccessedFile("welcome_panel.fxml");
            FxmlLoader.loadFrame(targetStack, newPanel);
        } else {
            System.out.println("Main StackPane not found.");
        }
    }
}
