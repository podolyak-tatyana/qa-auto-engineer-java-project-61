package hexlet.code;

import java.util.Scanner;

public final class Engine {
    public static final int ROUNDS_NUMBER = 3;
    private static final String ASK_NAME = """
            Welcome to the Brain Games!
            May I have your name?
            """;

    private static final String GREET = "Hello, %s!\n";

    public static void run(String description, String[][] roundsData) {
        if (roundsData.length == 0) {
            System.exit(0);
        }
        Scanner scanner = new Scanner(System.in);

        System.out.println(ASK_NAME);
        String userName = scanner.next();
        System.out.println(String.format(GREET, userName));

        System.out.println(description);
        for (String[] round : roundsData) {
            var question = round[0];
            var rightAnswer = round[1];
            System.out.println("Question: " + question);
            String usersAnswer = getResultFromUser();
            if (usersAnswer.equalsIgnoreCase(rightAnswer)) {
                System.out.println("Correct!");
            } else {
                handleError(rightAnswer, usersAnswer, userName);
            }
        }
        System.out.println("Congratulations, " + userName + "!");
    }

    private static void handleError(String rightAnswer, String userRawAnswer, String userName) {
        System.out.println(userRawAnswer + " is wrong answer ;(. Correct answer was '"
                + rightAnswer + "'.\nLet's try again, " + userName + "!");
        System.exit(0);
    }

    private static String getResultFromUser() {
        Scanner scanner = new Scanner(System.in);
        var userRawAnswer = scanner.next();
        System.out.println("Your answer: " + userRawAnswer);
        return userRawAnswer;
    }
}
