package hexlet.code;


import hexlet.code.questions.Question;

import java.util.Scanner;

public final class Engine {
    private static final String ASC_NAME = """
            Welcome to the Brain Games!
            May I have your name?
            """;

    private static final String GREET = "Hello, %s!\n";
    private String userName;

    private final Scanner scanner = new Scanner(System.in);

    public void play(GameRound<? extends Question> gameRound) {
        if (isNameEmpty()) {
            greetUser();
        }
        printMessage(gameRound.getTaskDescription());
        for (Question q : gameRound.getQuestionList()) {
            printMessage("Question: " + q.getGiven());
            Result result = getResultFromUser(q);
            if (result.userAnswer().equals(q.getRightAnswer())) {
                printMessage("Correct!");
            } else {
                handleError(q, result.userRawAnswer);
            }
        }
        printMessage("Congratulations, " + userName + "!" );
    }

    private void handleError(Question q, String userRawAnswer) {
        printMessage(userRawAnswer + " is wrong answer ;(. Correct answer was '"
            + q.getRightAnswer() + "'.\nLet's try again, " + userName + "!");
        System.exit(0);
    }

    private Result getResultFromUser(Question q) {
        var userRawAnswer = readStrValue();
        try {
            printMessage("Your answer: " + userRawAnswer);
            Number userAnswer = q.handleUsersValue(userRawAnswer);
            return new Result(userRawAnswer, userAnswer);
        } catch (IllegalArgumentException e) {
            handleError(q, userRawAnswer);
            throw new IllegalStateException("Invalid user's value");
        }
    }


    public String readStrValue() {
        return scanner.next();
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    void greetUser() {
        printMessage(ASC_NAME);
        this.userName = readStrValue();
        System.out.printf(GREET, userName);
    }

    // checking for multisession
    boolean isNameEmpty() {
        if (this.userName == null) {
            return true;
        }
        return this.userName.isBlank();
    }

    private record Result(String userRawAnswer, Number userAnswer) {
    }

}
