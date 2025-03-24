package com;

import javafx.application.Application;
import javafx.stage.Stage;
import com.ui.tools.FxmlFileOpener;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        FxmlFileOpener fxmlFileOpener = new FxmlFileOpener();
        fxmlFileOpener.openFileOnAction("/fxml/tictactoe_table.fxml");
    }

    public static void main(String[] args) {
        launch(args);
    }
}

