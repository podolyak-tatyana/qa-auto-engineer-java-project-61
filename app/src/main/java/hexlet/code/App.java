package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Greet;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner;

public class App {
    static final int ZERO = 0;
    static final int ONE = 1;
    static final int TWO = 2;
    static final int THREE = 3;
    static final int FOUR = 4;
    static final int FIFE = 5;
    static final int SIX = 6;

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
            case ONE -> new Greet();
            case TWO -> new Even();
            case THREE -> new Calc();
            case FOUR -> new GCD();
            case FIFE -> new Progression();
            case SIX -> new Prime();
            default -> System.out.println("Wrong number");
        }
    }
}
