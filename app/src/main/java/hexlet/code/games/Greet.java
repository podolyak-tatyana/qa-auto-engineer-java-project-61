package hexlet.code.games;


import static hexlet.code.Engine.run;

public final class Greet {

    public static final int ZERO = 0;

    public Greet() {
        runGame();
    }

    public void runGame() {
        run(null, new String[ZERO][ZERO]);
    }
}
