package com.tools;

import com.core.CliMessages;
import com.core.UserInputValidator;
import com.core.UserMove;

import java.util.Scanner;

public class Main {
//    private static final Boolean[][] matrix = new Boolean[3][3];
//
//    public static void main(String[] args) {
//        gameLobby();
//    }
//
//    private static void gameLobby() {
//        boolean running = true;
//        while (running) {
//            int option;
//            System.out.println(CliMessages.selectLobbyAction());
//            option = getUserNumber();
//            switch (option) {
//                case 0:
//                    boolean playGames = true;
//                    while (playGames) {
//                        playGames = runGame();
//                    }
//                    break;
//                case 1:
//                    setPlayers();
//                    break;
//                case 2:
//                    running = false;
//                    break;
//                default:
//                    System.out.println(CliMessages.wrongInput());
//                    break;
//            }
//        }
//    }
//
//    private static void setPlayers() {
//        System.out.println(CliMessages.playerMenuAction());
//        int action = getUserNumber();
//        switch (action) {
//            case 0:
//                createNewPlayer();
//                break;
//            case 1:
//                selectPlayers();
//                break;
//        }
//    }
//
//    private static void createNewPlayer() {}
//
//    private static void selectPlayers() {}
//
//    private static boolean runGame() {
//        int rounds = 0;
//        while (rounds < 9) {
//            UserMove userMove = new UserMove();
//            do {
//                System.out.println(CliMessages.getMoveInput());
//                userMove.setCol(getUserNumber());
//                userMove.setRow(getUserNumber());
//            } while (!UserInputValidator.isValidMove(userMove, matrix));
//            if (rounds % 2 == 0) {
//                matrix[userMove.getRow()][userMove.getCol()] = true;
//            } else {
//                matrix[userMove.getRow()][userMove.getCol()] = false;
//            }
//            printMatrix();
//            if (UserInputValidator.isGameOver(matrix)) {
//                System.out.println("User " + (rounds % 2 + 1) + " won the game!");
//                break;
//            }
//            rounds++;
//        }
//        System.out.println(CliMessages.replayGame());
//        boolean playGames = false;
//        if (getUserNumber() == 1) {
//            playGames = true;
//        } else if (getUserNumber() != 2) {
//            System.out.println(CliMessages.wrongInput());
//        }
//        return playGames;
//    }
//
//    private static void printMatrix() {
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                String item;
//                if (Boolean.TRUE.equals(matrix[i][j])) {
//                    item = "[X]";
//                } else if (Boolean.FALSE.equals(matrix[i][j])) {
//                    item = "[O]";
//                } else {
//                    item = "[ ]";
//                }
//                if (j < matrix[i].length - 1) {
//                    System.out.print(item + " | ");
//                } else {
//                    System.out.print(item);
//                }
//            }
//            if (i < matrix.length - 1) {
//                System.out.println("\n----|-----|----");
//            } else {
//                System.out.println();
//            }
//        }
//        System.out.println();
//    }
//
//    private static int getUserNumber() {
//        Scanner scan = new Scanner(System.in);
//        return scan.nextInt();
//    }
}