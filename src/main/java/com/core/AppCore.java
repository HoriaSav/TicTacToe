package com.core;

public class AppCore {
    private final Boolean[] matrix;

    private int rounds = 0;

    public AppCore() {
        matrix = new Boolean[9];
    }

    public void addMove(int position, Player player) {
        if (UserInputValidator.isValidMove(position, matrix)) {
            if(player.getGameId() == 1){
                matrix[position] = true;
            }
            else {
                matrix[position] = false;
            }
            rounds++;
        }
    }


    public boolean isGameOver() {
        return UserInputValidator.isGameOver(matrix);
    }

    public int getRounds() {
        return rounds;
    }
}
