package hexlet.code.games;

import hexlet.code.Engine;

public class GCD extends Engine {
    public static final int RANDOM_VALUE_MAX = 50;

    /**
     * Starts a round of the GCD game.
     * Generates two random numbers and asks the user to find their greatest common divisor.
     */
    @Override
    @SuppressWarnings("checkstyle:DesignForExtension")
    public void startRound() {

        // Генерируем два случайных числа (например, от 1 до 50)
        int x = getRandom().nextInt(RANDOM_VALUE_MAX) + 1;
        int y = getRandom().nextInt(RANDOM_VALUE_MAX) + 1;

        System.out.println("Find the greatest common divisor of given numbers.");
        System.out.println("Question: " + x + " " + y);
        int answer = getScanner().nextInt();
        System.out.println("Your answer: " + answer);
        getResult(answer, gcd(x, y));
    }

    private void getResult(int usersAnswer, int gcd) {
        if (usersAnswer == gcd) {
            incrementCounter();
            System.out.println("Correct!");
        } else {
            System.out.println(String.format("""
                    '%s' is wrong answer ;(. Correct answer was '%s'.
                    Let's try again, %s!
                    """, usersAnswer, gcd, getUserName()));
            System.exit(0);
        }
    }

    /**
     * Calculates the greatest common divisor of two numbers using Euclidean algorithm.
     *
     * @param x first number
     * @param y second number
     * @return the greatest common divisor of x and y
     */
    @SuppressWarnings("checkstyle:DesignForExtension")
    public int gcd(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }
}
