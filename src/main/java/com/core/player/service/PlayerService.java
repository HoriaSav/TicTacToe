package com.core.player.service;

import com.core.common.exception.PlayerException;
import com.core.common.util.FileManager;
import com.core.player.model.Player;
import com.ui.tools.ContextController;

import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

/**
 * @author HoriaSav
 *
 * This class handles the player operations for creating, deleting, updating and retrieving the player data.
 * It also handles the player status and game status updates.
 * It also handles the active player selection.
 */
public class PlayerService implements IPlayerService{
    private List<Player> playerList;
    private Player[] currentPlayers;

    public PlayerService() {
        playerList = readPlayersFromFile();
        currentPlayers = new Player[2];
    }
    @Override
    public void creatPlayer(String username) {
        Player newPlayer = new Player(username);
        storePlayer(newPlayer);
    }

    @Override
    public void deletePlayer(String username) {
        playerList.removeIf(player -> player.getUsername().equals(username));
        updateFile();
    }

    @Override
    public void updatePlayerStatus(String username, Boolean gameStatus) {
        for (Player player : playerList) {
            if (player.getUsername().equals(username)) {
                if (gameStatus == null) {
                    player.setGamesDraw(player.getGamesDraw() + 1);
                } else if (gameStatus.equals(FALSE)) {
                    player.setGamesLost(player.getGamesLost() + 1);
                } else if (gameStatus.equals(TRUE)) {
                    player.setGamesWon(player.getGamesWon() + 1);
                }
                updateFile();
            }
        }
    }

    private void storePlayer(Player player) {
        playerList.add(player);
        updateFile();
    }

    @Override
    public List<Player> getAllPlayers() {
        return playerList;
    }

    @Override
    public Player getActivePlayer(int playerNumber) {
        return currentPlayers[playerNumber-1];
    }

    private List<Player> readPlayersFromFile() {
        return FileManager.readFile();
    }

    //TODO: modify readPlayersFromFile() to setPlayerList()
    private void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    //TODO: eliminate updateFile(), use getAllPlayers() to write to file
    private void updateFile() {
        FileManager.writeToFile(playerList);
    }

    private Player getPlayer(String username) throws Exception {
        for (Player player : playerList) {
            if (player.getUsername().equals(username)) {
                return player;
            }
        }
        throw new Exception("No such Player found");
    }

    public void setActivePlayer(String username) {
        try {
            if (currentPlayers[0] == null) {
                setAPlayer(0, username);
            } else if (currentPlayers[1] == null) {
                setAPlayer(1, username);
            }
        } catch (Exception e) {
            throw new PlayerException("No such Player found");
        }
    }

    private void setAPlayer(int i, String username) throws Exception {
        currentPlayers[i] = getPlayer(username);
        currentPlayers[i].setGameId(i+1);
        float winrate;
        int gamesPlayed = currentPlayers[i].getGamesWon() + currentPlayers[i].getGamesLost() + currentPlayers[i].getGamesDraw();
        if (gamesPlayed == 0) {
            winrate = 0.0f;
        } else {
            float gamesWon = currentPlayers[i].getGamesWon();
            winrate = gamesWon / gamesPlayed;
        }
        ContextController.setPlayer2InfoDetails(username, (winrate + ""));
    }

    public void resetActivePlayer(int playerNumber) {
        if(playerNumber == 1) {
            ContextController.setPlayer1InfoDetails("Guest", "unknown");
            currentPlayers[0]=null;
        } else if (playerNumber == 2) {
            ContextController.setPlayer2InfoDetails("Guest", "unknown");
            currentPlayers[1]=null;
        }
    }

    public Player[] getActivePlayers() {
        return currentPlayers;
    }
}
