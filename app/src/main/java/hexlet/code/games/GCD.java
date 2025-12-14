package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.GameRound;
import hexlet.code.questions.StringQuestion;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class GCD {
    private static final int RANDOM_VALUE_MAX = 50;
    private static final String TASK_DESCRIPTION = "Find the greatest common divisor of given numbers.";
    private final Random random;
    private final Engine engine;
    private final int roundsNumber;


    public GCD(Random injectedRandom,
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
     * Starts a round of the GCD game.
     * Generates two random numbers and asks the user to find their greatest common divisor.
     * @return object with filled random numbers
     */
    public StringQuestion buildStringQuestion() {

        int x = random.nextInt(RANDOM_VALUE_MAX) + 1;
        int y = random.nextInt(RANDOM_VALUE_MAX) + 1;

        var question =  x + " " + y;
        return new StringQuestion(question, gcd(x, y));
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
