package hexlet.code.games;

import hexlet.code.Engine;

public class Even extends Engine {
    public static final int MAX_RANDOM_NUMBER = 100;

    /**
     * Starts a round of the even number game.
     * Generates a random number and asks the user if it's even.
     */
    @Override
    @SuppressWarnings("checkstyle:DesignForExtension")
    public void startRound() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        int randomNumber = getRandom().nextInt(MAX_RANDOM_NUMBER);
        System.out.println("Question: " + randomNumber);
        boolean isEven = isEven(randomNumber);
        String input = getScanner().next().toLowerCase();
        Answer usersAnswer = Answer.getAnswerByValue(input); // enum

        System.out.println("Your answer: " + input);

        if (Answer.ERROR.equals(usersAnswer)) {
            System.out.println(input + " is wrong answer ;(. Correct answer was '"
                    + Answer.getValueByEven(isEven) + "'.\n Let's try again, " + getUserName() + "!");
            return;
        }
        checkAnswer(usersAnswer, isEven, getUserName());
    }

    private boolean isEven(int number) {
        return number % 2 == 0;
    }

    private void checkAnswer(Answer userAnswer, boolean isEven, String userName) {
        if ((Answer.YES.equals(userAnswer) && isEven) || (Answer.NO.equals(userAnswer) && !isEven)) {
            System.out.println("Correct!");
            incrementCounter();
        } else {
            System.out.println(userAnswer.getValue() + " is wrong answer ;(. Correct answer was '"
                    + Answer.getValueByEven(isEven) + "'.\nLet's try again, " + userName + "!");
            System.exit(0);
        }
    }
}
