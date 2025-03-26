package com.core;

import com.core.manager.GameManager;
import com.core.manager.PlayerManager;

import java.util.List;

public class AppCore {
    private GameManager gameManager;
    private PlayerManager playerManager;

    public AppCore() {
        gameManager = new GameManager();
        playerManager = new PlayerManager();
    }

    public void addMove(int position, Player player) throws Exception {
        gameManager.addMove(position, player);
    }

    public boolean isGameOver() {
        return gameManager.isGameOver();
    }

    public int getRound() {
        return gameManager.getRound();
    }

    public void createNewUser(String username) {
        playerManager.createNewUser(username);
    }

    public void deletePlayer(String username) {
        playerManager.deletePlayer(username);
    }

    public void updatePlayer(Boolean status, String username) {
        playerManager.updatePlayers(status, username);
    }

    public List<Player> getPlayerList() {
        return playerManager.getPlayerList();
    }

    public Player [] getActivePlayers() {
        return playerManager.getActivePlayers();
    }

    public void setActivePlayer(String username) {
        playerManager.setActivePlayer(username);
    }

    public void resetActivePlayer(int playerNumber) {
        playerManager.resetActivePlayer(playerNumber);
    }
}
