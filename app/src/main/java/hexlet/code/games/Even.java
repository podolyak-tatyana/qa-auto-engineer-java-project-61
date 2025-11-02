package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Even extends Engine {

    @Override
    public void startRound() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        var r = new Random();              // рандомные числа
        int randomNumber = r.nextInt(100);
        System.out.println("Question: " + randomNumber);
        boolean isEven = isEven(randomNumber);
        String input = getScanner().next().toLowerCase();
        Answer usersAnswer = Answer.getAnswerByValue(input); // enum

        System.out.println("Your answer: " + input);

        if (Answer.ERROR.equals(usersAnswer)) {
            System.out.println(input + " is wrong answer ;(. Correct answer was '" + Answer.getValueByEven(isEven) + "'.\nLet's try again, " + getUserName() + "!");
            return;
        }
        checkAnswer(usersAnswer, isEven, getUserName());
        System.out.println("Congratulations, " + getUserName() + "!");
    }


    private boolean isEven(int number) {
        return number % 2 == 0;
    }

    private void checkAnswer(Answer userAnswer, boolean isEven, String userName) {
        if ((Answer.YES.equals(userAnswer) && isEven) || (Answer.NO.equals(userAnswer) && !isEven)) {
            System.out.println("Correct!");
            incrementCounter();
        } else {
            System.out.println(userAnswer.value + " is wrong answer ;(. Correct answer was '" + Answer.getValueByEven(isEven) + "'.\nLet's try again, " + userName + "!");
        }
    }

    private enum Answer {
        YES("yes"),
        NO("no"),
        ERROR(null);

        final String value;

        Answer(String answer) {
            this.value = answer;
        }

        static String getValueByEven(boolean isEven) {
            return isEven ? YES.value : NO.value;
        }

        static Answer getAnswerByValue(String value) {
            return switch (value) {
                case "yes" -> YES;
                case "no" -> NO;
                default -> ERROR;
            };
        }
    }
}
