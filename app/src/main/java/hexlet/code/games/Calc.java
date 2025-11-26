package hexlet.code.games;

import hexlet.code.Engine;


public class Calc extends Engine {
    public static final int RANDOM_VALUE = 10;
    public static final int THREE = 3;

    /**
     * Starts a round of the calculator game.
     * Generates two random numbers and an operation, asks the user for the result.
     */
    @Override
    @SuppressWarnings("checkstyle:DesignForExtension")
    public void startRound() {
        // Генерируем два случайных числа (например, от 1 до 10)
        int a = getRandom().nextInt(RANDOM_VALUE);
        int b = getRandom().nextInt(RANDOM_VALUE);
        // Случайный выбор операции: 0 -> '+', 1 -> '-', 2 -> '*'
        int operation = getRandom().nextInt(THREE);

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

        System.out.println("What is the result of the expression?");

        System.out.println("Question: " + a + " " + opSymbol + " " + b);
        int answer = getScanner().nextInt();
        System.out.println("Your answer: " + answer);
        getResult(answer, result);
    }

    private void getResult(int usersAnswer, int result) {
        if (usersAnswer == result) {
            incrementCounter();  // вызвали счетчик из родительского класса
            System.out.println("Correct!");
        } else {
            System.out.println(String.format("""
                    '%s' is wrong answer ;(. Correct answer was '%s'.
                    Let's try again, %s!
                    """, usersAnswer, result, getUserName()));
            System.exit(0);
        }
    }
}
