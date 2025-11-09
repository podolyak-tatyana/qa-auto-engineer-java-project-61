package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public abstract class Engine {

    private final String userName;
    private int counter = 0;

    private final Scanner scanner;
    private final Random random;

    public String initName() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        String name =  scanner.next();
        System.out.println("Hello, " + name + "!");
        return name;
    }

    public void startGame() {
        while (counter < 3) {
            startRound();
        }
        System.out.println("Congratulations, " + getUserName() + "!");
    }

    public void startRound() {
    }

    public Engine() {
        this.random = new Random();
        this.scanner = new Scanner(System.in);
        this.userName = initName();
        startGame();
    }

    public String getUserName() {
        return userName;
    }

    public void incrementCounter() {
        this.counter++;
    }

    public void setCounter(int value) {
        this.counter = value;
    }

    public Scanner getScanner() {
        return this.scanner;
    }

    public Random getRandom() {
        return random;
    }
}
