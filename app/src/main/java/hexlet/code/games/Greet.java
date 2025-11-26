package hexlet.code.games;

import hexlet.code.Engine;

public class Greet extends Engine {
    public static final int COUNTER = 3;

    /**
     * Starts a round of the greeting game.
     * Sets the counter to the specified value.
     */
    @Override
    @SuppressWarnings("checkstyle:DesignForExtension")
    public void startRound() {
        setCounter(COUNTER);
    }
}
