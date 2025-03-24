package com.core;

public class UserInputValidator {

    public static boolean isValidMove(int position, Boolean[] matrix) {
        if (isAvailable(position, matrix)) {
            return true;
        }
        return false;
    }

    private static boolean isAvailable(int position, Boolean[] matrix) {
        if (matrix[position] == null) {
            return true;
        }
        return false;
    }

    public static boolean isGameOver(Boolean[] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] != null) {
                if(i%3 == 1 && matrix[i]==matrix[i+1]&&matrix[i+1]==matrix[i+2]) {
                    return true;
                }
                if (i<4&& matrix[i]==matrix[i+3]&&matrix[i+3]==matrix[i+6]){
                    return true;
                }
                if (i==1&& matrix[1]==matrix[5]&&matrix[5]==matrix[9]){
                    return true;
                }
                if (i==3&&matrix[3]==matrix[5]&&matrix[5]==matrix[7]){
                    return true;
                }
            }
        }
        return false;
    }
}