package com.core.player.service;

import com.core.player.model.Player;

import java.util.List;

public interface IPlayerService {
    void creatPlayer(String username);
    void deletePlayer(String username);
    void updatePlayerGames(String username, Boolean gameStatus);
    List<Player> getAllPlayers();
    Player getActivePlayer(int playerNumber);
    void setActivePlayer(String username);
    Player getPlayer(String username) throws Exception;
    void resetActivePlayer(int playerNumber);
}
