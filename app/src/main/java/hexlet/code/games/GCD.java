package hexlet.code.games;

import java.util.Random;

import static hexlet.code.Engine.run;

public final class GCD {
    private static final int RANDOM_VALUE_MAX = 50;
    private static final String TASK_DESCRIPTION = "Find the greatest common divisor of given numbers.";
    public static final int TWO = 2;
    public static final int THREE = 3;

    private final Random random = new Random();
    private final int roundsNumber;


    public GCD(int roundsNumberValue) {
        this.roundsNumber = roundsNumberValue;
        run(TASK_DESCRIPTION, buildQuestions());
    }

    String[][] buildQuestions() {
        String[][] round = new String[THREE][TWO];
        for (int i = 0; i < roundsNumber; i++) {
            var pair = buildStringQuestion();
            round[i] = pair;
        }
        return round;
    }

    /**
     * Starts a round of the GCD game.
     * Generates two random numbers and asks the user to find their greatest common divisor.
     * @return object with filled random numbers
     */
    public String[] buildStringQuestion() {
        String[] pair = new String[2];
        int x = random.nextInt(RANDOM_VALUE_MAX) + 1;
        int y = random.nextInt(RANDOM_VALUE_MAX) + 1;

        var question =  x + " " + y;
        pair[0] = question;
        pair[1] = String.valueOf(gcd(x, y));
        return pair;
    }

    /**
     * Calculates the greatest common divisor of two numbers using Euclidean algorithm.
     *
     * @param x first number
     * @param y second number
     * @return the greatest common divisor of x and y
     */
    public int gcd(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }
}
