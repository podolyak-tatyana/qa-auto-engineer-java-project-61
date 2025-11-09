package hexlet.code.games;

import hexlet.code.Engine;

public class GCD extends Engine {

    @Override
    public void startRound() {

        // Генерируем два случайных числа (например, от 1 до 100)
        int x = getRandom().nextInt(50) + 1;
        int y = getRandom().nextInt(50) + 1;

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

    public int gcd(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;

    }
}