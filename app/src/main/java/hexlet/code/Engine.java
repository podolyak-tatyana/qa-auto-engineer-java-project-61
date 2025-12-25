package hexlet.code;

import java.util.Scanner;

public final class Engine {
    private static final String ASC_NAME = """
            Welcome to the Brain Games!
            May I have your name?
            """;

    private static final String GREET = "Hello, %s!\n";
    private static String userName;

    private final static Scanner scanner = new Scanner(System.in);

    public static void run(String description, String[][] roundsData) {
        if (isNameEmpty()) {
            greetUser();
        }
        System.out.println(description);
        for (String[] round : roundsData) {
            var question = round[0];
            var rightAnswer = round[1];
            System.out.println("Question: " + question);
            String usersAnswer = getResultFromUser(rightAnswer);
            if (usersAnswer.equals(rightAnswer)) {
                System.out.println("Correct!");
            } else {
                handleError(rightAnswer, usersAnswer);
            }
        }
        System.out.println("Congratulations, " + userName + "!");
    }

    private static void handleError(String rightAnswer, String userRawAnswer) {
        System.out.println(userRawAnswer + " is wrong answer ;(. Correct answer was '"
                + rightAnswer + "'.\nLet's try again, " + userName + "!");
        System.exit(0);
    }

    private static String getResultFromUser(String rightAnswer) {
        var userRawAnswer = scanner.next();
        System.out.println("Your answer: " + userRawAnswer);
        return userRawAnswer;
    }

    static void greetUser() {
        System.out.println(ASC_NAME);
        userName = scanner.next();
        System.out.printf(GREET, userName);
    }

    static boolean isNameEmpty() {
        if (userName == null) {
            return true;
        }
        return userName.isBlank();
    }
}
