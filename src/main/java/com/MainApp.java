package com;

import javafx.application.Application;
import javafx.stage.Stage;
import com.ui.util.FxmlLoader;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        FxmlLoader fxmlLoader = new FxmlLoader();
        fxmlLoader.openFileOnAction("/fxml/appBox.fxml");
    }

    public static void main(String[] args) {
        launch(args);
    }
}

