package hexlet.code.games;

import hexlet.code.Engine;

import java.util.ArrayList;
import java.util.List;

public class Progression extends Engine {

    @Override
    public void startRound() {
        int start = getRandom().nextInt(10);
        int length = getRandom().nextInt(5, 15);
        int step = getRandom().nextInt(3, 10);
        int hiddenIndex = getRandom().nextInt(length);


        var sequenceList = generateSequence(start, length, step);
        var hiddenNumber = sequenceList.get(hiddenIndex);
        sequenceList.set(hiddenIndex, "..");


        System.out.println("What number is missing in the progression?");
        System.out.println("Question: " + String.join(" ", sequenceList));

        String usersAnswer = getScanner().next();
        System.out.println("Your answer: " + usersAnswer);

        boolean isGuess = isGuess(usersAnswer, hiddenNumber);
        if (isGuess) {
            System.out.println("Correct!");
            incrementCounter();
        } else {
            System.out.printf("""
                    '%s' is wrong answer ;(. Correct answer was '%s'.
                    Let's try again, %s!
                    %n""", usersAnswer, hiddenNumber, getUserName());
            System.exit(0);
        }

    }

    private boolean isGuess(String answer, String rightNumber) {
        try {
            int answerInt = Integer.parseInt(answer);
            int rightNumberInt = Integer.parseInt(rightNumber);
            return answerInt == rightNumberInt;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private List<String> generateSequence(int start, int length, int step) {
        List<String> result = new ArrayList<>(length);

        for (int i = 0; i < length; i++) {
            result.add(String.valueOf(start + i * step));
        }
        return result;
    }


}