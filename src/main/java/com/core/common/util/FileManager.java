package com.core.common.util;

import com.core.player.model.Player;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author HoriaSav
 *
 * This class handles the file operations for storing and retrieving the player data.
 */
public class FileManager {

    public static void writeToFile(List<Player> playerList) {
        String filename = "players.json";
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
            FileWriter myWriter = new FileWriter(filename);
            myWriter.write(data.toString());
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static List<Player> readFile() {
        List<Player> playerList;
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
}
