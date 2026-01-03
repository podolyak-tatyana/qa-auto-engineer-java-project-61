package hexlet.code.games;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static hexlet.code.Engine.ROUNDS_NUMBER;
import static hexlet.code.Engine.run;

public final class Progression {
    private static final int START_RANDOM_VALUE = 10;
    private static final int LENGTH_VALUE_MIN = 5;
    private static final int LENGTH_VALUE_MAX = 15;
    private static final String TASK_DESCRIPTION = "What number is missing in the progression?";
    public static final int TWO = 2;

    private final Random random = new Random();

    public Progression() {
        runGame();
    }

    public void runGame() {
        run(TASK_DESCRIPTION, buildQuestions());
    }

    String[][] buildQuestions() {
        String[][] round = new String[ROUNDS_NUMBER][TWO];
        for (int i = 0; i < ROUNDS_NUMBER; i++) {
            round[i] = buildPair();
        }
        return round;
    }

    /**
     * Starts a round of the progression game.
     * Generates an arithmetic progression with a hidden number and asks the user to find it.
     *
     * @return a StringQuestion containing the progression with a hidden element
     * and the correct missing number as the answer
     */
    public String[] buildPair() {
        String[] pair = new String[TWO];
        int start = random.nextInt(START_RANDOM_VALUE);
        int length = random.nextInt(LENGTH_VALUE_MIN, LENGTH_VALUE_MAX);
        int step = random.nextInt(ROUNDS_NUMBER, START_RANDOM_VALUE);
        int hiddenIndex = random.nextInt(length);

        var sequenceList = generateSequence(start, length, step);
        var hiddenNumber = sequenceList.get(hiddenIndex);
        sequenceList.set(hiddenIndex, "..");
        pair[0] = String.join(" ", sequenceList);
        pair[1] = String.valueOf(hiddenNumber);
        return pair;
    }

    private List<String> generateSequence(int start, int length, int step) {
        List<String> result = new ArrayList<>(length);

        for (int i = 0; i < length; i++) {
            result.add(String.valueOf(start + i * step));
        }
        return result;
    }
}
