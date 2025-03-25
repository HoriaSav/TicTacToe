package com.core;

public class AppCore {
    private final Boolean[] matrix;

    private int rounds = 0;

    public AppCore() {
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
            rounds++;
        }
        else {
            throw new Exception("Invalid move");
        }
    }


    public boolean isGameOver() {
        return UserInputValidator.isGameOver(matrix);
    }

    public int getRounds() {
        return rounds;
    }

}
