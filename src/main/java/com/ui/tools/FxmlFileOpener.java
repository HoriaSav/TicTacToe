package com.ui.tools;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import com.MainApp;

import java.io.IOException;

public class FxmlFileOpener {

    public FxmlFileOpener(){
    }

    public void openFileOnAction(String filename) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource(filename));
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);

            Scene scene = new Scene(fxmlLoader.load(), 300, 400);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void loadFrame(StackPane stackPane, String filename) {
        try {
            FXMLLoader loader = new FXMLLoader(FxmlFileOpener.class.getResource("/fxml/" + filename));

            Parent page = loader.load();  // JavaFX will automatically use the fx:controller from the FXML
            stackPane.getChildren().setAll(page);  // Replace content in StackPane

//            System.out.println("Loaded FXML: " + filename);
        } catch (IOException e) {
            System.out.println("Error loading FXML: " + filename);
            e.printStackTrace();
        }
    }

}

