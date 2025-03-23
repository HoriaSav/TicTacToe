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
}
