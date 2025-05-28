package com.core.game;

import com.core.game.service.GameService;
import com.core.player.service.PlayerService;
import com.core.player.model.Player;

import java.util.List;

/**
 * @author HoriaSav
 *
 * This class is the core class of the TicTacToe game.
 * It maintains the state of the game and provides methods to perform game operations.
 * It also handles the player operations for creating, deleting, updating and retrieving the player data.
 * It also handles the player status and game status updates.
 * It also handles the active player selection.
*/
public class GameEngine {
    private final GameService gameService;
    private final PlayerService playerService;

    public GameEngine() {
        gameService = new GameService();
        playerService = new PlayerService();
    }

    public void addMove(int position, Player player) throws Exception {
        gameService.addMove(position, player);
    }

    public boolean isGameOver() {
        return gameService.isGameOver();
    }

    public int getRound() {
        return gameService.getRound();
    }

    public void createNewUser(String username) {
        playerService.creatPlayer(username);
    }

    public void deletePlayer(String username) {
        playerService.deletePlayer(username);
    }

    public void updatePlayer(Boolean status, String username) {
        playerService.updatePlayerStatus(username, status);
    }

    public List<Player> getPlayerList() {
        return playerService.getAllPlayers();
    }

    public Player [] getActivePlayers() {
        return playerService.getActivePlayers();
    }

    public void setActivePlayer(String username) {
        playerService.setActivePlayer(username);
    }

    public void resetActivePlayer(int playerNumber) {
        playerService.resetActivePlayer(playerNumber);
    }

    public void resetGame(){
        gameService.resetGame();
    }
}
