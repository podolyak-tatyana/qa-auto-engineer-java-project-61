package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userName = "";

        System.out.println("""
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                0 - Exit
                """);

        var number = scanner.nextInt();
        if (number == 1) {
            userName = Greet.greet();
        } else if (number == 0) {
            System.exit(0);
        } else {
            if (userName.isEmpty()) {
                userName = Greet.greet();
            }
            Even.even(userName);
        }

    }
}
