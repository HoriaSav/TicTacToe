import java.util.Scanner;

public class UserInputValidator {

    public UserInputValidator() {

    }

    public static UserMove getUserMove() {
        Scanner in = new Scanner(System.in);
        UserMove userMove = new UserMove();
        System.out.println("Enter new move: ");
        userMove.setCol(in.nextInt());
        userMove.setRow(in.nextInt());

        return userMove;
    }

}
