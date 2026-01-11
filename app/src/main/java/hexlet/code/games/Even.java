package hexlet.code.games;


import hexlet.code.utils.Utils;

import static hexlet.code.Engine.ROUNDS_NUMBER;
import static hexlet.code.Engine.run;

public final class Even {
    public static final int MAX_RANDOM_NUMBER = 100;
    private static final String TASK_DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    public static final int TWO = 2;

    public Even() {
        runGame();
    }

    public void runGame() {
        run(TASK_DESCRIPTION, buildQuestions());
    }

    String[][] buildQuestions() {
        String[][] round = new String[ROUNDS_NUMBER][TWO];
        for (int i = 0; i < ROUNDS_NUMBER; i++) {
            int randomNumber = Utils.generateNumber(MAX_RANDOM_NUMBER);
            round[i][0] = String.valueOf(randomNumber);
            round[i][1] = isEven(randomNumber) ? "yes" : "no";
        }
        return round;
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
