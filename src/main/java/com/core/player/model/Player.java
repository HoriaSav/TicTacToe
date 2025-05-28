package com.core.player.model;

/**
 * @author HoriaSav
 *
 * This class represents a player in the TicTacToe game.
 * It maintains the player details like username, games won, games lost and games draw.
 * It also maintains the game id for the player.
 * It also provides methods to update the player details.
 * It also provides methods to retrieve the player details.
*/
public class Player {
    private String username;
    private int gamesWon = 0;
    private int gamesLost = 0;
    private int gamesDraw = 0;
    private int gameId;

    public Player(){}

    public Player(String userName) {
        this.username = userName;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    public int getGamesLost() {
        return gamesLost;
    }

    public void setGamesLost(int gamesLost) {
        this.gamesLost = gamesLost;
    }

    public int getGamesDraw() {
        return gamesDraw;
    }

    public void setGamesDraw(int gamesDraw) {
        this.gamesDraw = gamesDraw;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }
}