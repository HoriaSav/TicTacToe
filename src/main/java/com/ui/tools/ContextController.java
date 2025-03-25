package com.ui.tools;

import com.core.Player;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContextController {
    private static StackPane mainStack;
    private static Label errorLabel;

    private static Player player1;
    private static Player player2;

    private static List<Player> playerList;

    public static void setMainStack(StackPane stackPane) {
        mainStack = stackPane;
    }

    public static void setErrorLabel(Label error) {
        errorLabel = error;
    }

    public static StackPane getMainStack() {
        return mainStack;
    }

    public static Label getErrorLabel() {
        return errorLabel;
    }

    public static Player getPlayer1() {
        return player1;
    }

    public static Player getPlayer2() {
        return player2;
    }

    public static void setPlayer1(String userName) {
        player1 = new Player(userName);
        player1.setGameId(1);
    }

    public static void setPlayer2(String userName) {
        player2 = new Player(userName);
        player2.setGameId(2);
    }

    public static void addPlayer(Player player) {
        playerList.add(player);
    }

    public static void writeToFile() {
        StringBuilder data = new StringBuilder();
        data.append("[");
        for (Player player : playerList) {
            data.append("\n\t{" +
                    "\n\t\t\"username\": \"" + player.getUsername() + "\"," +
                    "\n\t\t\"games won\": \"" + player.getGamesWon() + "\"," +
                    "\n\t\t\"games lost\": \"" + player.getGamesLost() + "\"," +
                    "\n\t\t\"games drawn\": \"" + player.getGamesDraw() + "\"" +
                    "\n\t}");
            if (playerList.indexOf(player) != playerList.size() - 1) {
                data.append(",");
            }
        }
        data.append("\n]");
        try {
            FileWriter myWriter = new FileWriter("players.json");
            myWriter.write(data.toString());
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static List<Player> readFile() {
        StringBuilder data = new StringBuilder();
        try {
            File file = new File("players.json");
            if (file.createNewFile()) {
                System.out.println("players.json file created");
                playerList = new ArrayList<>();
                return playerList;
            } else {
                Scanner sc = new Scanner(file);
                while (sc.hasNextLine()) {
                    data.append(sc.nextLine());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (data.isEmpty()) {
            playerList = new ArrayList<>();
            return playerList;
        }
        playerList = parseStringToList(data.toString());
        return playerList;
    }

    private static List<Player> parseStringToList(String data) {
        List<Player> players = new ArrayList<>();
        String[] dataArray = data.split("[\\[\\]{}]+");
        Player player = null;
        int count = 0;
        for (int i = 0; i < dataArray.length; i++) {
            if (!dataArray[i].isEmpty() && !dataArray[i].equals("\t") && !dataArray[i].equals(",\t")) {
                String[] taskArray = dataArray[i].split(",");
                for (int j = 0; j < taskArray.length; j++) {
                    switch (count % 4) {
                        case 0:
                            player = new Player();
                            String[] usernameArray = taskArray[j].split("\"");
                            player.setUsername(usernameArray[usernameArray.length - 1]);
                            count++;
                            break;
                        case 1:
                            String[] gamesWonArray = taskArray[j].split("\"");
                            player.setGamesWon(Integer.parseInt(gamesWonArray[gamesWonArray.length - 1]));
                            count++;
                            break;
                        case 2:
                            String[] gamesLostArray = taskArray[j].split("\"");
                            player.setGamesLost(Integer.parseInt(gamesLostArray[gamesLostArray.length - 1]));
                            count++;
                            break;
                        case 3:
                            String[] gamesDrawnArray = taskArray[j].split("\"");
                            if(gamesDrawnArray[gamesDrawnArray.length - 1].equals("\t")){
                                player.setGamesDraw(Integer.parseInt(gamesDrawnArray[gamesDrawnArray.length - 2]));
                            }
                            else {
                                player.setGamesDraw(Integer.parseInt(gamesDrawnArray[gamesDrawnArray.length - 1]));
                            }
                            count++;
                            players.add(player);
                            break;
                    }
                }
            }
        }
        return players;
    }

    public static void updateGamesWon(String username) {
        for (Player player : playerList) {
            if (player.getUsername().equals(username)) {
                player.setGamesWon(player.getGamesWon() + 1);
            }
        }
        writeToFile();
    }
}
