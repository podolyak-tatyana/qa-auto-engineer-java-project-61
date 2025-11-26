package hexlet.code.games;

import hexlet.code.Engine;

public class Prime extends Engine {
    public static final int NUMBER_VALUE = 99;
    public static final int INCREASE = 2;
    public static final int DIVIDER_THREE = 3;

    /**
     * Starts a round of the prime number game.
     * Generates a random number and asks the user if it's prime.
     */
    @Override
    @SuppressWarnings("checkstyle:DesignForExtension")
    public void startRound() {
        int number = getRandom().nextInt(NUMBER_VALUE) + INCREASE;

        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        System.out.println("Question: " + number);
        String usersInput = getScanner().next();
        System.out.println("Your answer: " + usersInput);
        boolean isPrime = isPrime(number);

        Answer userAnswer = Answer.getAnswerByValue(usersInput);

        checkAnswer(userAnswer, isPrime, usersInput);
    }

    private void checkAnswer(Answer userAnswer, boolean isPrime, String userInput) {
        if ((Answer.YES.equals(userAnswer) && isPrime) || (Answer.NO.equals(userAnswer) && !isPrime)) {
            System.out.println("Correct!");
            incrementCounter();
        } else if (Answer.ERROR.equals(userAnswer)) {
            System.out.println(buildErrorMessage(userInput, isPrime));
            System.exit(0);
        } else {
            System.out.println(buildErrorMessage(Answer.NO.getValue(), isPrime));
            System.exit(0);
        }
    }

    private String buildErrorMessage(String userInput, boolean isPrime) {
        return userInput + " is wrong answer ;(. Correct answer was '" + Answer.getValueByEven(isPrime) + "'.\n"
                + "Let's try again, " + getUserName() + "!";
    }

    private boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        // Проверяем делители только до sqrt(n), только нечётные
        for (int i = DIVIDER_THREE; i <= n / i; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
