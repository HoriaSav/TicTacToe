package com.core;

public class Player {
    private String userName;
    private String password;
    private int gamesWon = 0;
    private int gamesLost = 0;
    private int gamesDraw = 0;
    private int gameId;

    public Player(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }
}