package com.ui.controller;

import com.ui.tools.ContextController;
import com.ui.tools.FxmlFileOpener;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;

public class MainMenuController {
    StackPane targetStackPane;
    public void initialize() {

    }

    @FXML
    private void loadGame() {
        StackPane targetStack = ContextController.getMainStack();
        if (targetStack != null) {
            FxmlFileOpener.loadFrame(targetStack, "player_selection_menu.fxml");
        } else {
            System.out.println("Main StackPane not found.");
        }
    }
}
