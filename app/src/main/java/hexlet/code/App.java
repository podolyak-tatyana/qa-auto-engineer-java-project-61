package hexlet.code;

import hexlet.code.games.*;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("""  
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calc
                4 - GCD
                5 - Progression
                6 - Prime
                0 - Exit
                """);

        var number = scanner.nextInt();
        switch (number) {
            case 0 -> System.exit(0);
            case 1 -> new Greet();
            case 2 -> new Even();
            case 3 -> new Calc();
            case 4 -> new GCD();
            case 5 -> new Progression();
            default -> System.out.println("Wrong number");
        }
    }
}
