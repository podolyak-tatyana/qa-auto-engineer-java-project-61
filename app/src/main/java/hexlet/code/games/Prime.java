package hexlet.code.games;

import hexlet.code.utils.Utils;

import static hexlet.code.Engine.ROUNDS_NUMBER;
import static hexlet.code.Engine.run;

public final class Prime {
    public static final int NUMBER_VALUE = 99;
    public static final int INCREASE = 2;
    public static final int TWO = 2;

    private static final String TASK_DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public Prime() {
        run(TASK_DESCRIPTION, buildQuestions());
    }

    String[][] buildQuestions() {
        String[][] round = new String[ROUNDS_NUMBER][TWO];
        for (int i = 0; i < ROUNDS_NUMBER; i++) {
            var pair = buildPair();
            round[i] = pair;
        }
        return round;
    }

    public String[] buildPair() {
        String[] pair = new String[TWO];
        int number = Utils.generateNumber(NUMBER_VALUE) + INCREASE;
        pair[0] = String.valueOf(number);
        pair[1] = isPrime(number) ? "yes" : "no";
        return pair;
    }


    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }

        for (int i = ROUNDS_NUMBER; i <= n / i; i++) {
            if (i % 2 == 0) {
                continue;
            }
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


}
