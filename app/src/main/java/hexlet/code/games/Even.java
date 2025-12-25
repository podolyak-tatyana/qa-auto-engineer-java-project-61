package hexlet.code.games;

import java.util.Random;

import static hexlet.code.Engine.run;

public final class Even {
    public static final int MAX_RANDOM_NUMBER = 100;
    private static final String TASK_DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    private final Random random = new Random();
    private final int roundsNumber;


    public Even(int roundsNumberValue) {
        this.roundsNumber = roundsNumberValue;
        runGame();
    }

    public void runGame() {
        run(TASK_DESCRIPTION, buildQuestions());
    }

    String[][] buildQuestions() {
        String[][] round = new String[3][2];
        for (int i = 0; i < roundsNumber; i++) {
            int randomNumber = random.nextInt(MAX_RANDOM_NUMBER);
            round[i][0] = String.valueOf(randomNumber);
            round[i][1] = getRightAnswer(getValueByEven(randomNumber));
        }
        return round;
    }


    public static String getRightAnswer(Boolean value) {
        return value ? "yes" : "no";
//        if (value == Boolean.TRUE) {
//            return "yes";
//        }
//        return "no";
    }

    public static Boolean getValueByEven(Integer number) {
        return number % 2 == 0 ? Boolean.TRUE : Boolean.FALSE;
    }

}
