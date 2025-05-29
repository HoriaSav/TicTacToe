module TicTacToe {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;

    opens com to javafx.graphics, javafx.fxml;
    opens com.ui.tools to javafx.fxml;
    opens com.ui.util to javafx.fxml;
    opens com.ui.controller.player to javafx.fxml;
    opens com.ui.controller.app to javafx.fxml;
    opens com.ui.controller.game to javafx.fxml;
    opens com.ui.controller to javafx.fxml;
}