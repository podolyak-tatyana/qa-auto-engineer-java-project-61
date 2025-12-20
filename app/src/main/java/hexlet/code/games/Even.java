package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.questions.BooleanQuestion;
import hexlet.code.GameRound;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class Even {
    public static final int MAX_RANDOM_NUMBER = 100;
    private static final String TASK_DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    private final Random random;
    private final Engine engine;
    private final int roundsNumber;


    public Even(Random injectedRandom,
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
            int randomNumber = random.nextInt(MAX_RANDOM_NUMBER);
            questions.add(new BooleanQuestion(randomNumber,
                    Answer.getValueByEven(randomNumber)));
        }
        return questions;
    }
}
