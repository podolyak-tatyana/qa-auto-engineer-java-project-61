package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Even {

    static int counter = 0;

    public static void even(String userName){
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        while (counter < 3) {
            var r = new Random();
            int randomNumber = r.nextInt(100);
            System.out.println("Question: " + randomNumber);
            boolean isEven = isEven(randomNumber);
            Scanner scanner = new Scanner(System.in);
            String input = scanner.next().toLowerCase();
            Answer usersAnswer = Answer.getAnswerByValue(input); // enum

            System.out.println("Your answer: " + input);

            if (Answer.ERROR.equals(usersAnswer)) {
                System.out.println(input + " is wrong answer ;(. Correct answer was '" + Answer.getValueByEven(isEven) + "'.\nLet's try again, " + userName + "!");
                continue;
            }

            checkAnswer(usersAnswer, isEven, userName);
        }
        System.out.println("Congratulations, " + userName + "!");
    }


    private static boolean isEven(int number) {
        return number %2 == 0;
    }

    private static void checkAnswer(Answer userAnswer, boolean isEven, String userName) {
        if ((Answer.YES.equals(userAnswer) && isEven) || (Answer.NO.equals(userAnswer) && !isEven)) {
            System.out.println("Correct!");
            counter++;
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
