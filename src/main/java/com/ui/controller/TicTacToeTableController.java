package com.ui.controller;

import com.core.AppCore;
import com.core.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TicTacToeTableController {
    private AppCore appCore;
    private Player player1;
    private Player player2;
    private int round;

    public void initialize() {
        appCore = new AppCore();
        round = 0;
        player1=new Player("HoriaS", "1234");
        player1.setGameId(1);
        player2=new Player("Zpewg", "5678");
        player2.setGameId(2);
    }

    @FXML
    private void addMove(ActionEvent event) {

        Button clickedButton = (Button) event.getSource();
        int position = Integer.parseInt(clickedButton.getText());
        if (position%2==0) {
            appCore.addMove(position-1, player1);
        }
        else {
            appCore.addMove(position-1, player2);
        }
        ImageView imageView = (ImageView) clickedButton.getGraphic();

        // Pick the right image
        Image newImage;
        if (round % 2 == 0) {
            newImage = new Image(getClass().getResourceAsStream("/icons/x.png")); // for player1
        } else {
            newImage = new Image(getClass().getResourceAsStream("/icons/o.png")); // for player2
        }
        imageView.setImage(newImage);
        round++;
    }
}
