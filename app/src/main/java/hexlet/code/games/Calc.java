package hexlet.code.games;


import hexlet.code.utils.Utils;

import static hexlet.code.Engine.ROUNDS_NUMBER;
import static hexlet.code.Engine.run;


public final class Calc {
    public static final int MAX_VALUE = 10;
    public static final int TWO = 2;
    public static final String TASK_DESCRIPTION = "What is the result of the expression?";

    public Calc() {
        runGame();
    }

    public void runGame() {
        run(TASK_DESCRIPTION, buildQuestions());
    }

    String[][] buildQuestions() {
        String[][] round = new String[ROUNDS_NUMBER][TWO];
        for (int i = 0; i < ROUNDS_NUMBER; i++) {
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
        var pair = new String[TWO];
        int a = Utils.generateNumber(MAX_VALUE);
        int b = Utils.generateNumber(MAX_VALUE);
        final char[] operators = {'+', '-', '*'};
        var indexOperator = Utils.generateNumber(operators.length);
        var operator = operators[indexOperator];

        var result = calculate(a, b, operator);
        pair[0] = a + " " + operator + " " + b;
        pair[1] = String.valueOf(result);
        return pair;
    }

    private int calculate(int a, int b, char operator) {
        return switch (operator) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            default -> 0;
        };
    }
}

