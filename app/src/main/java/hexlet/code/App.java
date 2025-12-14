package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Greet;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Random;
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
        Random random = new Random();
        Engine engine = new Engine();

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
            case ONE -> new Greet(engine);
            case TWO -> new Even(random, engine, ROUNDS_NUMBER);
            case THREE -> new Calc(random, engine, ROUNDS_NUMBER);
            case FOUR -> new GCD(random, engine, ROUNDS_NUMBER);
            case FIFE -> new Progression(random, engine, ROUNDS_NUMBER);
            case SIX -> new Prime(random, engine, ROUNDS_NUMBER);
            default -> System.out.println("Wrong number");
        }
    }
}
