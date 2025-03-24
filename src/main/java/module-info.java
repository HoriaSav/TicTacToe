module TicTacToe {
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.controls;

    opens com to javafx.graphics, javafx.fxml;
    opens com.ui.controller to javafx.fxml;
    opens com.ui.tools to javafx.fxml;
}