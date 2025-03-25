package com.ui.controller;

import com.ui.tools.ControllerContext;
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
        loadPage();
        ControllerContext.setMainStack(stackPane); // Register stackPane
        ControllerContext.setErrorLabel(errorLabel);
    }

    private void loadPage() {
        FxmlFileOpener.loadFrame(stackPane, "main_menu.fxml");
    }

    @FXML
    private void minimizeWindow(ActionEvent event){
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    private void closeApp(){
        Platform.exit();
    }

    @FXML
    private void toggleMaximize(ActionEvent event){
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setMaximized(!stage.isMaximized());
    }
}
