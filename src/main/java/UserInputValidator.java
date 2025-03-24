import java.util.Scanner;

public class UserInputValidator {

    public static boolean isValidMove(UserMove move, Boolean[][] matrix) {
        if (!isOutOfBounds(move, matrix.length - 1, matrix[0].length - 1) && isAvailable(move, matrix)) {
            return true;
        }
        return false;
    }

    private static boolean isOutOfBounds(UserMove move, int mWidth, int mHeight) {
        if ((move.getCol() < 0 || move.getCol() > mWidth)) {
            System.out.println(CliMessages.wrongMove(move.getCol(), mWidth, "x"));
            return true;
        }
        if (move.getRow() < 0 || move.getRow() > mHeight) {
            System.out.println(CliMessages.wrongMove(move.getRow(), mHeight, "y"));
            return true;
        }
        return false;
    }

    private static boolean isAvailable(UserMove move, Boolean[][] matrix) {
        if (matrix[move.getRow()][move.getCol()] == null) {
            return true;
        }
        System.out.println(CliMessages.unavailableMove(move));
        return false;
    }

    public static boolean checkGameOver(Boolean[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != null) {
                    if (i < matrix.length - 2 && matrix[i + 1][j] == matrix[i][j] && matrix[i + 2][j] == matrix[i][j]) {
                        return true;
                    }
                    if (j < matrix[i].length - 2 && matrix[i][j + 1] == matrix[i][j] && matrix[i][j + 2] == matrix[i][j]) {
                        return true;
                    }
                    if (i < matrix.length - 2 && j < matrix[i].length - 2 && matrix[i + 1][j + 1] == matrix[i][j] && matrix[i + 2][j + 2] == matrix[i][j]) {
                        return true;
                    }
                    if (j - 2 >= 0 && matrix[i +1][j - 1] == matrix[i][j] && matrix[i + 2][j - 2] == matrix[i][j]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
