package com.core.game.service;

import com.core.common.util.UserInputValidator;
import com.core.player.model.Player;

/**
 * @author HoriaSav
 *
 * This class handles the game logic for the TicTacToe game.
 * It maintains the state of the game and provides methods to perform game operations.
 * It also validates the user input for the game.
 */
public class GameService implements IGameService{
    private Boolean[] matrix;
    private int round = 0;

    public GameService() {
        matrix = new Boolean[9];
    }

    @Override
    public void startGame() {
        //TODO: mabe delete later
    }

    @Override
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

    @Override
    public boolean isGameOver() {
        return round == 9 || UserInputValidator.isGameOver(matrix);
    }

    @Override
    public int getRound() {
        return round;
    }

    @Override
    public void resetGame(){
        matrix = new Boolean[9];
        round = 0;
        System.out.println("Game has been reset");
    }
}
