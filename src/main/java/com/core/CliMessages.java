package com.core;

public class CliMessages {

    public static String wrongMove(int moveValue, int maxValue, String axis) {
        return "Invalid Move entered: " + axis + " axis coordinate is out of bounds -> [0 <= " + moveValue + " <= " + maxValue + "]";
    }

    public static String unavailableMove(UserMove move) {
        return "Move unavailable in point (" + move.getCol() + ", " + move.getRow() + "), square already taken!";
    }

    public static String getMoveInput() {
        return "Enter move values for x and y coordinates";
    }

    public static String replayGame() {
        return "Replay game: [1 - Yes : 2 - No]";
    }

    public static String wrongInput() {
        return "Wrong input. Try again";
    }

    public static String selectLobbyAction() {
        return "Select lobby action: [0 - play game : 1 - create players]";
    }

    public static String playerMenuAction() {
        return "Select action: [0 - create new player : 1 - select 2 existing players]";
    }
}