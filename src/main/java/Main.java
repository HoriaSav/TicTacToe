import java.util.Scanner;

public class Main {
    private static Boolean[][] matrix = new Boolean[3][3];

    public static void main(String[] args) {
        runGame();
    }


    private static void runGame() {
        int rounds = 0;
        while (rounds < 9) {
            UserMove userMove = new UserMove();
            System.out.println(CliMessages.getMoveInput());
            userMove.setCol(getMoveCoordinate());
            userMove.setRow(getMoveCoordinate());
            while (!UserInputValidator.isValidMove(userMove, matrix)) {
                System.out.println(CliMessages.getMoveInput());
                userMove.setCol(getMoveCoordinate());
                userMove.setRow(getMoveCoordinate());
            }
            matrix[userMove.getRow()][userMove.getCol()] = true;
            rounds++;
            printMatrix();
            if (UserInputValidator.checkGameOver(matrix)) {
                System.out.println("User " + (rounds % 2 + 1) + " won the game!");
                break;
            }
        }
    }

    private static void printMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                String item;
                if (Boolean.TRUE.equals(matrix[i][j])) {
                    item = "[X]";
                } else if (Boolean.FALSE.equals(matrix[i][j])) {
                    item = "[O]";
                } else {
                    item = "[ ]";
                }
                if (j < matrix[i].length - 1) {
                    System.out.print(item + " | ");
                } else {
                    System.out.print(item);
                }
            }
            if (i < matrix.length - 1) {
                System.out.println("\n---------------");
            }
            else {
                System.out.println();
            }
        }
        System.out.println();
    }

    private static int getMoveCoordinate() {
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }
}