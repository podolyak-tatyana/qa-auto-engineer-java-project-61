package hexlet.code.games;

import java.util.Random;

import static hexlet.code.Engine.run;


public final class Calc {
    public static final int RANDOM_VALUE = 10;
    public static final int THREE = 3;
    public static final String TASK_DESCRIPTION = "What is the result of the expression?";

    private final Random random = new Random();
    private final int roundsNumber;

    public Calc(int roundsNumberValue) {
        this.roundsNumber = roundsNumberValue;
        runGame();
    }

    public void runGame() {
        run(TASK_DESCRIPTION, buildQuestions());
    }

    String[][] buildQuestions() {
        String[][] round = new String[3][2];
        for (int i = 0; i < roundsNumber; i++) {
            var pair = buildStringQuestion();
            round[i] = pair;
        }
        return round;
    }

    /**
     * Builds a single arithmetic question for the calculator game.
     * Generates two random numbers and an operation and prepares the question.
     *
     * @return a StringQuestion containing the expression and the correct result
     */
    public String[] buildStringQuestion() {
        var pair = new String[2];
        // Генерируем два случайных числа (например, от 1 до 10)
        int a = random.nextInt(RANDOM_VALUE);
        int b = random.nextInt(RANDOM_VALUE);
        // Случайный выбор операции: 0 -> '+', 1 -> '-', 2 -> '*'
        int operation = random.nextInt(THREE);

        int result = 0;
        char opSymbol = ' ';

        switch (operation) {
            case 0:
                result = a + b;
                opSymbol = '+';
                break;
            case 1:
                result = a - b;
                opSymbol = '-';
                break;
            case 2:
                result = a * b;
                opSymbol = '*';
                break;
            default:
        }

        var stringQuestion = a + " " + opSymbol + " " + b;
        pair[0] = stringQuestion;
        pair[1] = String.valueOf(result);
        return pair;
    }
}
