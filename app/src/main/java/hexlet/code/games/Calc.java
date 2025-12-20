package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.GameRound;
import hexlet.code.questions.StringQuestion;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public final class Calc {
    public static final int RANDOM_VALUE = 10;
    public static final int THREE = 3;
    public static final String TASK_DESCRIPTION = "What is the result of the expression?";

    private final Random random;
    private final Engine engine;
    private final int roundsNumber;

    public Calc(Random injectedRandom,
                Engine injectedEngine,
                int roundsNumberValue) {
        this.random = injectedRandom;
        this.engine = injectedEngine;
        this.roundsNumber = roundsNumberValue;
        runGame();
    }

    public void runGame() {
        engine.play(buildRound());
    }

    public GameRound<StringQuestion> buildRound() {
        return new GameRound<>(TASK_DESCRIPTION, buildQuestions());
    }


    List<StringQuestion> buildQuestions() {
        List<StringQuestion> questions = new ArrayList<>();
        for (int i = 0; i < roundsNumber; i++) {
            var question = buildStringQuestion();
            questions.add(question);
        }
        return questions;
    }

    /**
     * Builds a single arithmetic question for the calculator game.
     * Generates two random numbers and an operation and prepares the question.
     *
     * @return a StringQuestion containing the expression and the correct result
     */
    public StringQuestion buildStringQuestion() {
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
        return new StringQuestion(stringQuestion, result);
    }
}
