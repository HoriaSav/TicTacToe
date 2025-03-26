package com.core.manager;

import com.core.Player;
import com.ui.tools.ContextController;

import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class PlayerManager {
    private List<Player> playerList;
    private Player[] currentPlayers;

    public PlayerManager() {
        playerList = readPlayersFromFile();
        currentPlayers = new Player[2];
    }

    public void createNewUser(String username) {
        Player newPlayer = new Player(username);
        addPlayerToList(newPlayer);
    }

    private void addPlayerToList(Player player) {
        playerList.add(player);
        updateFile();
    }

    public void deletePlayer(String username) {
        playerList.removeIf(player -> player.getUsername().equals(username));
        updateFile();
    }

    public void updatePlayers(Boolean gameStatus, String username) {
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

    private List<Player> readPlayersFromFile() {
        return FileManager.readFile();
    }

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
        if(username == null) {
            currentPlayers[0] = null;
            currentPlayers[1] = null;
        }
        else {
            try {
                if (currentPlayers[0] == null) {
                    currentPlayers[0] = getPlayer(username);
                    currentPlayers[0].setGameId(1);
                    float winrate;
                    int gamesPlayed = currentPlayers[0].getGamesWon() + currentPlayers[0].getGamesLost() + currentPlayers[0].getGamesDraw();
                    if (gamesPlayed == 0) {
                        winrate = 0.0f;
                    } else {
                        float gamesWon = currentPlayers[0].getGamesWon();
                        winrate = gamesWon / (gamesPlayed);
                    }
                    ContextController.setPlayer1InfoDetails(username, (winrate + ""));
                } else if(currentPlayers[1] == null) {
                    currentPlayers[1] = getPlayer(username);
                    currentPlayers[1].setGameId(2);
                    float winrate;
                    int gamesPlayed = currentPlayers[1].getGamesWon() + currentPlayers[1].getGamesLost() + currentPlayers[1].getGamesDraw();
                    if (gamesPlayed == 0) {
                        winrate = 0.0f;
                    } else {
                        float gamesWon = currentPlayers[1].getGamesWon();
                        winrate = gamesWon / gamesPlayed;
                    }
                    ContextController.setPlayer2InfoDetails(username, (winrate + ""));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Player[] getActivePlayers() {
        return currentPlayers;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }
}
