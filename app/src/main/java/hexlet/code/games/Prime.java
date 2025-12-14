package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.GameRound;
import hexlet.code.questions.BooleanQuestion;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class Prime {
    public static final int NUMBER_VALUE = 99;
    public static final int INCREASE = 2;
    public static final int DIVIDER_THREE = 3;

    private static final String TASK_DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private final Random random;
    private final Engine engine;
    private final int roundsNumber;


    public Prime(Random injectedRandom,
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

    public GameRound<BooleanQuestion> buildRound() {
        return new GameRound<>(TASK_DESCRIPTION, buildQuestions());
    }


    List<BooleanQuestion> buildQuestions() {
        List<BooleanQuestion> questions = new ArrayList<>();
        for (int i = 0; i < roundsNumber; i++) {
            var question = buildEvenQuestion();
            questions.add(question);
        }
        return questions;
    }


    public BooleanQuestion buildEvenQuestion() {
        int number = random.nextInt(NUMBER_VALUE) + INCREASE;
        return new BooleanQuestion(number, Answer.getValueByPrime(number));
    }

}
