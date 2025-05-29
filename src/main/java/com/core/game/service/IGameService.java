package com.core.game.service;

import com.core.player.model.Player;

public interface IGameService {
    void startGame();
    void addMove(int position, Player player) throws Exception;
    boolean isGameOver();
    void resetGame();
    int getRound();
}
