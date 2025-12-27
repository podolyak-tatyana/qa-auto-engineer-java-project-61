package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Cli;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner;

public class App {
    private static final int ROUNDS_NUMBER = 3;
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIFE = 5;
    private static final int SIX = 6;


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
            case ZERO -> System.exit(0);
            case ONE -> Cli.greet();
            case TWO -> new Even(ROUNDS_NUMBER);
            case THREE -> new Calc(ROUNDS_NUMBER);
            case FOUR -> new GCD(ROUNDS_NUMBER);
            case FIFE -> new Progression(ROUNDS_NUMBER);
            case SIX -> new Prime(ROUNDS_NUMBER);
            default -> System.out.println("Unknown user choice: " + number);
        }
    }
}
