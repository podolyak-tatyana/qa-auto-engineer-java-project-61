package hexlet.code.games;

import java.util.Random;

import static hexlet.code.Engine.run;

public final class Prime {
    public static final int NUMBER_VALUE = 99;
    public static final int INCREASE = 2;
    public static final int DIVIDER_THREE = 3;

    private static final String TASK_DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private final Random random = new Random();
    private final int roundsNumber;


    public Prime(int roundsNumberValue) {
        this.roundsNumber = roundsNumberValue;
        run(TASK_DESCRIPTION, buildQuestions());
    }

    String[][] buildQuestions() {
        String[][] round = new String[3][2];
        for (int i = 0; i < roundsNumber; i++) {
            var pair = buildPair();
            round[i] = pair;
        }
        return round;
    }

    public String[] buildPair() {
        String[] pair = new String[2];
        int number = random.nextInt(NUMBER_VALUE) + INCREASE;
        pair[0] = String.valueOf(number);
        pair[1] = getRightAnswer(getValueByPrime(number));
        return pair;
    }


    public static String getRightAnswer(Boolean value) {
        return value ? "yes" : "no";
    }

    public static Boolean getValueByPrime(int n) {
        if (n < 2) {
            return Boolean.FALSE;
        }
        if (n == 2) {
            return Boolean.TRUE;
        }
        if (n % 2 == 0) {
            return Boolean.FALSE;
        }
        // Проверяем делители только до sqrt(n), только нечётные
        for (int i = DIVIDER_THREE; i <= n / i; i += 2) {
            if (n % i == 0) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

}
