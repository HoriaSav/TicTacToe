public class Main {
    private static Boolean[][] matrix = new Boolean[3][3];

    public static void main(String[] args) {
        runGame();
    }


    private static void runGame() {
        int rounds = 0;
        while (rounds < 9) {
            UserMove userMove = UserInputValidator.getUserMove();
            matrix[userMove.getRow()][userMove.getCol()] = true;
            rounds++;
            printMatrix();
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
                System.out.print(item + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}