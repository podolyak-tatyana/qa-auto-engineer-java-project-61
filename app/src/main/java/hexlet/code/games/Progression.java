package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.GameRound;
import hexlet.code.questions.StringQuestion;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class Progression {
    private static final int START_RANDOM_VALUE = 10;
    private static final int LENGTH_VALUE_MIN = 5;
    private static final int LENGTH_VALUE_MAX = 15;
    private static final int STEP_VALUE = 3;
    private static final String TASK_DESCRIPTION = "What number is missing in the progression?";

    private final Random random;
    private final Engine engine;
    private final int roundsNumber;

    public Progression(Random injectedRandom,
                       Engine injectedEngine,
                       int roundsNumberValue
                       ) {
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
     * Starts a round of the progression game.
     * Generates an arithmetic progression with a hidden number and asks the user to find it.
     *
     * @return a StringQuestion containing the progression with a hidden element
     *         and the correct missing number as the answer
     */
    public StringQuestion buildStringQuestion() {
        int start = random.nextInt(START_RANDOM_VALUE);
        int length = random.nextInt(LENGTH_VALUE_MIN, LENGTH_VALUE_MAX);
        int step = random.nextInt(STEP_VALUE, START_RANDOM_VALUE);
        int hiddenIndex = random.nextInt(length);

        var sequenceList = generateSequence(start, length, step);
        var hiddenNumber = sequenceList.get(hiddenIndex);
        sequenceList.set(hiddenIndex, "..");
        return new StringQuestion(String.join(" ", sequenceList), Integer.valueOf(hiddenNumber));
    }


    private List<String> generateSequence(int start, int length, int step) {
        List<String> result = new ArrayList<>(length);

        for (int i = 0; i < length; i++) {
            result.add(String.valueOf(start + i * step));
        }
        return result;
    }

}
