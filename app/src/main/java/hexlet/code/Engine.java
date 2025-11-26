package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public abstract class Engine {
    public static final int COUNTER = 3;

    private final String userName;
    private int counter = 0;

    private final Scanner scanner;
    private final Random random;

    public final String initName() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        String name =  scanner.next();
        System.out.println("Hello, " + name + "!");
        return name;
    }

    /**
     * Starts the game loop, running rounds until the counter reaches COUNTER.
     * Calls startRound() which should be overridden by subclasses.
     * Safe to extend - subclasses should override startRound() instead.
     */
    @SuppressWarnings("checkstyle:DesignForExtension")
    public void startGame() {
        while (counter < COUNTER) {
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

    /**
     * Returns the user's name.
     * Safe to call from subclasses.
     *
     * @return the user's name
     */
    @SuppressWarnings("checkstyle:DesignForExtension")
    public String getUserName() {
        return userName;
    }

    /**
     * Increments the game round counter.
     * Safe to call from subclasses.
     */
    @SuppressWarnings("checkstyle:DesignForExtension")
    public void incrementCounter() {
        this.counter++;
    }

    /**
     * Sets the game round counter to a specific value.
     * Safe to call from subclasses.
     *
     * @param value the value to set the counter to
     */
    @SuppressWarnings("checkstyle:DesignForExtension")
    public void setCounter(int value) {
        this.counter = value;
    }

    /**
     * Returns the Scanner instance for reading user input.
     * Safe to call from subclasses.
     *
     * @return the Scanner instance
     */
    @SuppressWarnings("checkstyle:DesignForExtension")
    public Scanner getScanner() {
        return this.scanner;
    }

    /**
     * Returns the Random instance for generating random numbers.
     * Safe to call from subclasses.
     *
     * @return the Random instance
     */
    @SuppressWarnings("checkstyle:DesignForExtension")
    public Random getRandom() {
        return random;
    }
}
