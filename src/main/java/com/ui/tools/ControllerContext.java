package com.ui.tools;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class ControllerContext {
    private static StackPane mainStack;

    private static Label errorLabel;

    public static void setMainStack(StackPane stackPane) {
        mainStack = stackPane;
    }

    public static void setErrorLabel(Label error) {
        errorLabel = error;
    }

    public static StackPane getMainStack() {
        return mainStack;
    }

    public static Label getErrorLabel() {
        return errorLabel;
    }
}
