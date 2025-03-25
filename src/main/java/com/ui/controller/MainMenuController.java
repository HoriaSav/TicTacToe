package com.ui.controller;

import com.ui.tools.ControllerContext;
import com.ui.tools.FxmlFileOpener;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;

public class MainMenuController {
    StackPane targetStackPane;
    public void initialize() {

    }

    @FXML
    private void loadGame() {
        StackPane targetStack = ControllerContext.getMainStack();
        if (targetStack != null) {
            FxmlFileOpener.loadFrame(targetStack, "game_table.fxml");
        } else {
            System.out.println("Main StackPane not found.");
        }
    }
}
