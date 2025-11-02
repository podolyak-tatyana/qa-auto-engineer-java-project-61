package hexlet.code.games;

import hexlet.code.Engine;


public class Calc extends Engine {

    @Override
    public void startRound() {
        // Генерируем два случайных числа (например, от 1 до 10)
        int a = getRandom().nextInt(10);
        int b = getRandom().nextInt(10);
        // Случайный выбор операции: 0 -> '+', 1 -> '-', 2 -> '*'
        int operation = getRandom().nextInt(3);

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
        }

        System.out.println("What is the result of the expression?");

        System.out.println("Question: " + a + " " + opSymbol + " " + b);
        int answer = getScanner().nextInt();
        System.out.println("Your answer: " + answer);
        System.out.println(getResult(answer, result));
    }

    private String getResult(int usersAnswer, int result) {
        if (usersAnswer == result) {
            incrementCounter();  // вызвали счетчик из родительского класса
            return "Correct!";
        } else {
            return String.format("""
                    '%s' is wrong answer ;(. Correct answer was '%s'.
                    Let's try again, %s!
                    """, usersAnswer, result, getUserName());
        }
    }
}
