package com.core.game.service;

import com.core.player.model.Player;

public interface IGameService {
    void startGame();
    void addMove(int position, Player player);
    boolean isGameOver();
    void resetGame();
    int getRound();
}
