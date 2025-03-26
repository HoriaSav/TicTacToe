package com.ui.controller;

import com.ui.tools.ContextController;
import com.ui.tools.FxmlFileOpener;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;

public class MainPanelController {
    public void initialize() {

    }
    @FXML
    private void loadPlayerSelectionPanel() {
        StackPane targetStack = ContextController.getMainStack();
        if (targetStack != null) {
            FxmlFileOpener.loadFrame(targetStack, "player_selection_panel.fxml");
        } else {
            System.out.println("Main StackPane not found.");
        }
    }
    @FXML
    private void loadSettingsPanel() {
        StackPane targetStack = ContextController.getMainStack();
        if (targetStack != null) {
            FxmlFileOpener.loadFrame(targetStack, "settings.fxml");
        } else {
            System.out.println("Main StackPane not found.");
        }
    }
}
