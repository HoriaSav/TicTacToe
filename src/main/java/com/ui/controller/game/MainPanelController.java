package com.ui.controller.game;

import com.ui.tools.ContextController;
import com.ui.util.FxmlLoader;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;

public class MainPanelController {
    public void initialize() {

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
