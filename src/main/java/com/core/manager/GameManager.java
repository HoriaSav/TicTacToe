package com.core.manager;

import com.core.Player;
import com.core.UserInputValidator;

public class GameManager {
    private Boolean[] matrix;
    private int round = 0;

    public GameManager() {
        matrix = new Boolean[9];
    }

    public void addMove(int position, Player player) throws Exception {
        if (UserInputValidator.isValidMove(position, matrix)) {
            if(player.getGameId() == 1){
                matrix[position] = true;
                System.out.println("player 1 moved");
            }
            else {
                matrix[position] = false;
                System.out.println("player 2 moved");
            }
            round++;
        }
        else {
            throw new Exception("Invalid move");
        }
    }

    public boolean isGameOver() {
        return round == 9 || UserInputValidator.isGameOver(matrix);
    }

    public int getRound() {
        return round;
    }

    public void resetGame(){
        matrix = new Boolean[9];
        round = 0;
        System.out.println("Game has been reset");
    }
}
