package com.core.common.util;

public class UserInputValidator {

    public static boolean isValidMove(int position, Boolean[] matrix) {
        return matrix[position] == null;
    }

    public static boolean isGameOver(Boolean[] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] != null) {
                if (i % 3 == 0 && matrix[i] == matrix[i + 1] && matrix[i + 1] == matrix[i + 2]) {
                    return true;
                }
                if (i < 3 && matrix[i] == matrix[i + 3] && matrix[i + 3] == matrix[i + 6]) {
                    return true;
                }
                if (i == 0 && matrix[0] == matrix[4] && matrix[4] == matrix[8]) {
                    return true;
                }
                if (i == 2 && matrix[2] == matrix[4] && matrix[4] == matrix[6]) {
                    return true;
                }
            }
        }
        return false;
    }
}